package io.github.drnickenstein.reworkmod.items.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class SonicBoomDevice extends Item {

    public SonicBoomDevice(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 60;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        pPlayer.startUsingItem(pUsedHand);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        if(!pLevel.isClientSide()) {

            BlockPos pos = pLivingEntity.getOnPos();
            Player player;

            if(pLivingEntity instanceof Player) {
                player = (Player)pLivingEntity;
            } else {
                return super.finishUsingItem(pStack, pLevel, pLivingEntity);
            }

            AABB boundingBox = new AABB(pos).expandTowards(player.getLookAngle()).inflate(20D);

            for(LivingEntity entity : pLevel.getEntitiesOfClass(LivingEntity.class, boundingBox)) {

                if(!(entity instanceof Player)) {

                    entity.hurt(pLevel.damageSources().sonicBoom(player), 40.0f);

                }

            }

            player.getCooldowns().addCooldown(pStack.getItem(), 100);

        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);

    }
}
