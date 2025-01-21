package top.alazeprt.sfmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
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
import top.alazeprt.sfmod.block.*;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;
import top.alazeprt.sfmod.item.CustomSpawnEgg;
import top.alazeprt.sfmod.item.HongBaoItem;

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

    public static final BlockEntityType<FrozenAndyLauBlockEntity> FROZEN_ANDY_LAU_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("sfmod", "frozen_andy_lau"),
            BlockEntityType.Builder.create(FrozenAndyLauBlockEntity::new, FROZEN_ANDY_LAU_BLOCK).build()
    );

    public static final Block FUYIN1 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "fuyin1"),
            new FuyinBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).noCollision().nonOpaque())
    );

    public static final Block FUYIN2 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "fuyin2"),
            new FuyinBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).noCollision().nonOpaque())
    );

    public static final Block FUYIN3 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "fuyin3"),
            new FuyinBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).noCollision().nonOpaque())
    );

    public static final Block FUYIN4 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "fuyin4"),
            new FuyinBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).noCollision().nonOpaque())
    );

    public static final Block COUPLETS_HORIZONTAL = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_horizontal"),
            new CoupletsHorizontalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_VERTICAL = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_vertical"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_TOP_1 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_top_1"),
            new CoupletsHorizontalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_TOP_2 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_top_2"),
            new CoupletsHorizontalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_TOP_3 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_top_3"),
            new CoupletsHorizontalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_LEFT_1 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_left_1"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_LEFT_2 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_left_2"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_LEFT_3 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_left_3"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_RIGHT_1 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_right_1"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_RIGHT_2 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_right_2"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
    );

    public static final Block COUPLETS_RIGHT_3 = Registry.register(
            Registries.BLOCK,
            Identifier.of("sfmod", "couplets_right_3"),
            new CoupletsVerticalBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK))
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

    public static final Item FUYIN1_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "fuyin1"),
            new BlockItem(FUYIN1, new Item.Settings())
    );

    public static final Item FUYIN2_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "fuyin2"),
            new BlockItem(FUYIN2, new Item.Settings())
    );

    public static final Item FUYIN3_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "fuyin3"),
            new BlockItem(FUYIN3, new Item.Settings())
    );

    public static final Item FUYIN4_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "fuyin4"),
            new BlockItem(FUYIN4, new Item.Settings())
    );

    public static final Item HONGBAO1_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "hongbao1"),
            new HongBaoItem(new Item.Settings())
    );

    public static final Item HONGBAO2_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "hongbao2"),
            new HongBaoItem(new Item.Settings())
    );

    public static final Item HONGBAO3_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "hongbao3"),
            new HongBaoItem(new Item.Settings())
    );

    public static final Item HONGBAO4_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "hongbao4"),
            new HongBaoItem(new Item.Settings())
    );

    public static final Item COUPLETS_VERTICAL_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_vertical"),
            new BlockItem(COUPLETS_VERTICAL, new Item.Settings())
    );

    public static final Item COUPLETS_HORIZONTAL_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_horizontal"),
            new BlockItem(COUPLETS_HORIZONTAL, new Item.Settings())
    );

    public static final Item COUPLETS_TOP_1_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_top_1"),
            new BlockItem(COUPLETS_TOP_1, new Item.Settings())
    );

    public static final Item COUPLETS_TOP_2_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_top_2"),
            new BlockItem(COUPLETS_TOP_2, new Item.Settings())
    );

    public static final Item COUPLETS_TOP_3_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_top_3"),
            new BlockItem(COUPLETS_TOP_3, new Item.Settings())
    );

    public static final Item COUPLETS_LEFT_1_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_left_1"),
            new BlockItem(COUPLETS_LEFT_1, new Item.Settings())
    );

    public static final Item COUPLETS_LEFT_2_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_left_2"),
            new BlockItem(COUPLETS_LEFT_2, new Item.Settings())
    );

    public static final Item COUPLETS_LEFT_3_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_left_3"),
            new BlockItem(COUPLETS_LEFT_3, new Item.Settings())
    );

    public static final Item COUPLETS_RIGHT_1_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_right_1"),
            new BlockItem(COUPLETS_RIGHT_1, new Item.Settings())
    );

    public static final Item COUPLETS_RIGHT_2_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_right_2"),
            new BlockItem(COUPLETS_RIGHT_2, new Item.Settings())
    );

    public static final Item COUPLETS_RIGHT_3_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of("sfmod", "couplets_right_3"),
            new BlockItem(COUPLETS_RIGHT_3, new Item.Settings())
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
            itemGroup.add(FUYIN1_ITEM);
            itemGroup.add(FUYIN2_ITEM);
            itemGroup.add(FUYIN3_ITEM);
            itemGroup.add(FUYIN4_ITEM);
            itemGroup.add(HONGBAO1_ITEM);
            itemGroup.add(HONGBAO2_ITEM);
            itemGroup.add(HONGBAO3_ITEM);
            itemGroup.add(HONGBAO4_ITEM);
            itemGroup.add(COUPLETS_VERTICAL_ITEM);
            itemGroup.add(COUPLETS_HORIZONTAL_ITEM);
            itemGroup.add(COUPLETS_TOP_1_ITEM);
            itemGroup.add(COUPLETS_TOP_2_ITEM);
            itemGroup.add(COUPLETS_TOP_3_ITEM);
            itemGroup.add(COUPLETS_LEFT_1_ITEM);
            itemGroup.add(COUPLETS_LEFT_2_ITEM);
            itemGroup.add(COUPLETS_LEFT_3_ITEM);
            itemGroup.add(COUPLETS_RIGHT_1_ITEM);
            itemGroup.add(COUPLETS_RIGHT_2_ITEM);
            itemGroup.add(COUPLETS_RIGHT_3_ITEM);
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
