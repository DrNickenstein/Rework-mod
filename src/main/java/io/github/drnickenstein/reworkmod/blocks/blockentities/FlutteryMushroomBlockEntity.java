package io.github.drnickenstein.reworkmod.blocks.blockentities;

import io.github.drnickenstein.reworkmod.blocks.blockentities.util.TickingBE;
import io.github.drnickenstein.reworkmod.entities.FlutteryMushroom;
import io.github.drnickenstein.reworkmod.init.RwrkBlockEntities;
import io.github.drnickenstein.reworkmod.init.RwrkEntities;
import io.github.drnickenstein.reworkmod.init.RwrkItems;
import io.github.drnickenstein.reworkmod.init.RwrkParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class FlutteryMushroomBlockEntity extends BlockEntity implements TickingBE {

    private long lastSporeRelease = 0;

    public FlutteryMushroomBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(RwrkBlockEntities.FLUTTERY_MUSHROOM_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {

        if(!level.isClientSide()) {

            AABB boundingBox = new AABB(pos).inflate(10.0D);
            List<Player> players = level.getEntitiesOfClass(Player.class, boundingBox);
            List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, boundingBox);

            if(getLastSporeRelease() + 400 <= level.getGameTime()) {
                releaseSpores(level.getGameTime());
            }

            if(getLastSporeRelease() + 190 >= level.getGameTime()) {
                for(LivingEntity entity : entities) {
                    if(!entity.hasEffect(MobEffects.LEVITATION)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200));
                    }
                }
                spawnParticlesInAABB(boundingBox, level);
            }

            for(Player player : players) {

                if(player.isUsingItem()) {

                    if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == RwrkItems.BIZARRE_WHISTLE.get() &&
                    player.getTicksUsingItem() == 99) {

                        level.removeBlock(this.getBlockPos(), false);
                        FlutteryMushroom flutteryMushroom = RwrkEntities.FLUTTERY_MUSHROOM.get().create(level);
                        level.addFreshEntity(flutteryMushroom);
                        flutteryMushroom.setPos(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ());


                    } else if(player.getItemInHand(InteractionHand.OFF_HAND).getItem() == RwrkItems.BIZARRE_WHISTLE.get()
                    && player.getTicksUsingItem() == 99) {

                        level.removeBlock(this.getBlockPos(), false);
                        FlutteryMushroom flutteryMushroom = RwrkEntities.FLUTTERY_MUSHROOM.get().create(level);
                        level.addFreshEntity(flutteryMushroom);
                        flutteryMushroom.setPos(pos.getX(), pos.getY(), pos.getZ());
                    }
                }
            }
        }
        this.level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
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

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.lastSporeRelease = pTag.getLong("lastSporeRelease");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putLong("lastSporeRelease", lastSporeRelease);
    }

    private void releaseSpores(long currentTime) {

        this.lastSporeRelease = currentTime;
        setChanged();

    }

    public long getLastSporeRelease() {

        return this.lastSporeRelease;

    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        saveAdditional(nbt);
        return nbt;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
