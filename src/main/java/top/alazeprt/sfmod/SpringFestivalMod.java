package top.alazeprt.sfmod;

import com.jcraft.jorbis.Block;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.alazeprt.sfmod.block.FrozenAndyLauBlock;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;
import top.alazeprt.sfmod.item.CustomSpawnEgg;

public class SpringFestivalMod implements ModInitializer {

    public static final EntityType<AndyLauEntity> ANDY_LAU = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("sfmod", "andy_lau"),
            EntityType.Builder.create(AndyLauEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2f).build()
    );

    public static final SoundEvent ANDY_LAU_MUSIC = registerSound("andy_lau_music");

    public static final FrozenAndyLauBlock FROZEN_ANDY_LAU_BLOCK = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "frozen_andy_lau"),
            new FrozenAndyLauBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(0.5f).slipperiness(0.98F).sounds(BlockSoundGroup.GLASS).nonOpaque())
    );

    public static final Item ANDY_LAU_EGG = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "andy_lau_egg"),
            new CustomSpawnEgg(ANDY_LAU, new Item.Settings()));

    public static final Item FROZEN_ANDY_LAU = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "frozen_andy_lau"),
            new BlockItem(FROZEN_ANDY_LAU_BLOCK, new Item.Settings())
    );

    public static final RegistryKey<ItemGroup> SF_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("sfmod", "sf_group"));

    public static final ItemGroup SF_GROUP = Registry.register(Registries.ITEM_GROUP, SF_GROUP_KEY,
            FabricItemGroup.builder()
            .icon(() -> new ItemStack(ANDY_LAU_EGG))
            .displayName(Text.translatable("itemGroup.sfmod.sf_group"))
            .build()
    );

    public static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of("sfmod", name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(ANDY_LAU, AndyLauEntity.createAndyLauAttributes());
        ItemGroupEvents.modifyEntriesEvent(SF_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ANDY_LAU_EGG);
            itemGroup.add(FROZEN_ANDY_LAU);
        });
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
