package top.alazeprt.sfmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.alazeprt.sfmod.SpringFestivalMod;

import java.util.HashMap;
import java.util.Map;

import static top.alazeprt.sfmod.SpringFestivalMod.ANDY_LAU_MUSIC;

public class AndyLauEntity extends PassiveEntity {

    private static final Logger log = LoggerFactory.getLogger(AndyLauEntity.class);
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public static final Map<String, Integer> map = new HashMap<>();


    public AndyLauEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return SpringFestivalMod.ANDY_LAU.create(world);
    }

    public static DefaultAttributeContainer.Builder createAndyLauAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ARMOR, 1f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TemptGoal(this, 0.4f, Ingredient.ofItems(Items.GOLDEN_APPLE), false));
        this.goalSelector.add(4, new MoveThroughVillageGoal(this, 0.4f, false, 8, () -> false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.8f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8f));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(posDelta * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
        this.getWorld().getPlayers().forEach(player -> {
            if (this.distanceTo(player) < 20 && map.getOrDefault(this.getUuidAsString(), 0) <= 0) {
                this.playSound(SpringFestivalMod.ANDY_LAU_MUSIC, 1.0f, 1.0f);
                map.put(this.getUuidAsString(), 200);
            } else if (map.getOrDefault(this.getUuidAsString(), 0) <= 0) {
                map.remove(this.getUuidAsString());
            }
        });
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public static void tickMap() {
        for (String key : map.keySet()) {
            map.put(key, map.get(key) - 1);
        }
    }
}
