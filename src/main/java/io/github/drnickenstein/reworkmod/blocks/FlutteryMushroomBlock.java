package io.github.drnickenstein.reworkmod.blocks;

import io.github.drnickenstein.reworkmod.blocks.blockentities.FlutteryMushroomBlockEntity;
import io.github.drnickenstein.reworkmod.blocks.blockentities.util.TickingBE;
import io.github.drnickenstein.reworkmod.init.RwrkBlockEntities;
import io.github.drnickenstein.reworkmod.init.RwrkParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FlutteryMushroomBlock extends Block implements EntityBlock {

    public FlutteryMushroomBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 13, 13 );

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return RwrkBlockEntities.FLUTTERY_MUSHROOM_BLOCK_ENTITY.get().create(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return TickingBE.getTickerHelper(pLevel);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        BlockEntity be = pLevel.getBlockEntity(pPos);

        if(be instanceof FlutteryMushroomBlockEntity flutteryMushroomBE) {
            AABB boundingBox = new AABB(pPos).inflate(10.0D);

            System.out.println("Last spore release: " + flutteryMushroomBE.getLastSporeRelease());
            System.out.println("Game time: " + pLevel.getGameTime());

            if(flutteryMushroomBE.getLastSporeRelease() + 190 >= pLevel.getGameTime()) {
                spawnParticlesInAABB(boundingBox, pLevel);
                System.out.println("particles spawned");
            }
        }
    }

    private void spawnParticlesInAABB(AABB boundingBox, Level level) {

        Random random = new Random();

        double i = boundingBox.getCenter().x;
        double j = boundingBox.getCenter().y;
        double k = boundingBox.getCenter().z;

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 30; ++l) {
            blockpos$mutableblockpos.set(i + random.nextInt(20) - 10, j - random.nextInt(10) + 5, k + random.nextInt(20) - 10);
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(RwrkParticles.FLUTTERY_MUSHROOM_SPORES.get(), (double) blockpos$mutableblockpos.getX() + random.nextDouble(), (double) blockpos$mutableblockpos.getY() + random.nextDouble(), (double) blockpos$mutableblockpos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

}
