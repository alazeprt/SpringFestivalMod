package top.alazeprt.sfmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CoupletsVerticalBlock extends HorizontalFacingBlock {
    public static final MapCodec<CoupletsVerticalBlock> CODEC = createCodec(CoupletsVerticalBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public CoupletsVerticalBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(6/16f, 2/16f, 15.8/16f, 10/16f, 30/16f, 1f);
            case SOUTH -> VoxelShapes.cuboid(6/16f, 2/16f, 0.0f, 10/16f, 30/16f, 0.2/16f);
            case EAST -> VoxelShapes.cuboid(0f, 2/16f, 6/16f, 0.2/16f, 30/16f, 10/16f);
            case WEST -> VoxelShapes.cuboid(15.8/16f, 2/16f, 6/16f, 1.0f, 30/16f, 10/16f);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    protected VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return super.getRaycastShape(state, world, pos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
