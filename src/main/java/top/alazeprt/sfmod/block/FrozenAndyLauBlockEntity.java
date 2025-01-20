package top.alazeprt.sfmod.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.alazeprt.sfmod.SpringFestivalMod;

import static top.alazeprt.sfmod.SpringFestivalMod.ANDY_LAU;
import static top.alazeprt.sfmod.block.FrozenAndyLauBlock.FROZEN_LEVEL;

public class FrozenAndyLauBlockEntity extends BlockEntity {
    public FrozenAndyLauBlockEntity(BlockPos pos, BlockState state) {
        super(SpringFestivalMod.FROZEN_ANDY_LAU_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, FrozenAndyLauBlockEntity blockEntity) {
        FrozenAndyLauBlock block = (FrozenAndyLauBlock) blockState.getBlock();
        block.levelFactor -= (world.getLightLevel(blockPos)) * 2;
        if (block.levelFactor <= 0) {
            world.breakBlock(blockPos, false);
            if (!world.isClient()) {
                ANDY_LAU.spawn((ServerWorld) world, blockPos, null);
            }
            return;
        }
        world.setBlockState(blockPos, blockState.with(FROZEN_LEVEL, (block.levelFactor / 1000 == 0 ? 1 : block.levelFactor / 1000)));
    }
}
