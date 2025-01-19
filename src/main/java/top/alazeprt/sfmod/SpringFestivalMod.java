package top.alazeprt.sfmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;

public class SpringFestivalMod implements ModInitializer {

    public static final EntityType<AndyLauEntity> ANDY_LAU = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("sfmod", "andy_lau"),
            EntityType.Builder.create(AndyLauEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2f).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ANDY_LAU, AndyLauEntity.createAndyLauAttributes());
    }
}
