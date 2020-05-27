package dev.bitnet.yogttt.block;

import dev.bitnet.yogttt.tile_entity.C4Tile;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class C4Block extends DirectionalBlock {
    private final VoxelShape DOWN = VoxelShapes.create(.1875, 0, .3125, 0.8125, 0.453125, 0.6875);
    private final VoxelShape UP = VoxelShapes.create(.1875, .546875, .3125, .8125, 1, .6875);
    private final VoxelShape NORTH = VoxelShapes.create(.3125, 0.6875, 0, 0.8125, .3125, .453125);
    private final VoxelShape SOUTH = VoxelShapes.create(.3125, 0.6875, .546875, 0.8125, .3125, 1);
    private final VoxelShape WEST = VoxelShapes.create(0, .6875, .8125, .453125, .3125, .1875);
    private final VoxelShape EAST = VoxelShapes.create(.546875, .6875, .8125, 1, .3125, .1875);

    public C4Block() {
        super(Properties.create(Material.WOOL)
                .sound(SoundType.CLOTH)
        );
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateContainer.getBaseState()).with(FACING, Direction.UP)));
    }

    @Override
    public boolean isNormalCube(BlockState p_220081_1_, IBlockReader p_220081_2_, BlockPos p_220081_3_) {
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        switch ((Direction) state.get(FACING)) {
            case DOWN:
                return DOWN;
            case SOUTH:
                return SOUTH;
            case NORTH:
                return NORTH;
            case EAST:
                return EAST;
            case WEST:
                return WEST;
            default:
                return UP;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite().getOpposite());
    }

    public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity) {
        Vec3d vec = entity.getPositionVec();
        return Direction.getFacingFromVector((float) (vec.x - clickedBlock.getX()), (float) (vec.y - clickedBlock.getY()), (float) (vec.z - clickedBlock.getZ()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        return false;
    }

    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        worldIn.createExplosion((Entity)null, pos.getX(), pos.getY(), pos.getZ(), 12.0F, Explosion.Mode.BREAK);
        super.onExplosionDestroy(worldIn, pos, explosionIn);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new C4Tile();
    }
}
