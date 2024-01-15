package io.github.drnickenstein.reworkmod.blocks.blockentities.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public interface TickingBE {

    void tick(Level level, BlockPos pos, BlockState state);

    static <T extends BlockEntity> BlockEntityTicker<T> getTickerHelper(Level level) {
        return level.isClientSide() ? null : (level0, pos0, state0, blockEntity) -> ((TickingBE)blockEntity).tick(level0, pos0, state0);
    }

}
