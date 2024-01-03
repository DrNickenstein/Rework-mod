package io.github.drnickenstein.reworkmod.items.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class SonicBoomDevice extends Item {

    public SonicBoomDevice(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 60;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {

        pPlayer.startUsingItem(pUsedHand);
        pPlayer.playSound(SoundEvents.WARDEN_SONIC_CHARGE, 3.0f, 1.0f);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack pStack, Level pLevel, @NotNull LivingEntity pLivingEntity) {
        
        pLivingEntity.playSound(SoundEvents.WARDEN_SONIC_BOOM, 3.0f, 1.0f);

        if(!pLevel.isClientSide()) {

            BlockPos pos = pLivingEntity.getOnPos();
            Player player;

            if(pLivingEntity instanceof Player) {
                player = (Player)pLivingEntity;
            } else {
                return super.finishUsingItem(pStack, pLevel, pLivingEntity);
            }

            AABB boundingBox = new AABB(pos).inflate(10.0D).move(getXMovement(player.getDirection()),
                                                                        getYMovement(player.getDirection()),
                                                                        getZMovement(player.getDirection()));

            for(LivingEntity entity : pLevel.getEntitiesOfClass(LivingEntity.class, boundingBox)) {
                if(!(entity == player) && !(entity instanceof Warden)) {
                    entity.hurt(pLevel.damageSources().sonicBoom(player), 40.0f);
                }
            }

            player.getCooldowns().addCooldown(pStack.getItem(), 100);

        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);

    }

    private double getXMovement(Direction d) {

        return switch (d) {
            case EAST -> 10.0D;
            case WEST -> -10.0D;
            default -> 0;
        };
    }

    private double getYMovement(Direction d) {
        return switch (d) {
            case UP -> 10.0D;
            case DOWN -> -10.0D;
            default -> 0;
        };
    }

    private double getZMovement(Direction d) {
        return switch (d) {
            case SOUTH -> 10.0D;
            case NORTH -> -10.0D;
            default -> 0;
        };
    }

}
