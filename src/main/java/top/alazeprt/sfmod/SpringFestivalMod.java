package top.alazeprt.sfmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;

public class SpringFestivalMod implements ModInitializer {

    public static final EntityType<AndyLauEntity> ANDY_LAU = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("sfmod", "andy_lau"),
            EntityType.Builder.create(AndyLauEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2f).build()
    );

    public static final SoundEvent ANDY_LAU_MUSIC = registerSound("andy_lau_music");

    public static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of("sfmod", name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ANDY_LAU, AndyLauEntity.createAndyLauAttributes());
        new Thread(() -> {
            while (true) {
                AndyLauEntity.tickMap();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
