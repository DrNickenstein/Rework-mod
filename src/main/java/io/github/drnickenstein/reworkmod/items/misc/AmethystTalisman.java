package io.github.drnickenstein.reworkmod.items.misc;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class AmethystTalisman extends Item {

    public AmethystTalisman(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if(!pLevel.isClientSide()) {
            Player player;

            if(pEntity instanceof Player) {
                player = (Player)pEntity;
            } else {
                return;
            }

            if((player.getItemInHand(InteractionHand.MAIN_HAND)).getItem() == this
                    || (player.getItemInHand(InteractionHand.OFF_HAND)).getItem() == this) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0, true, false));

            }
        }
        System.out.println("Tick");

    }
}