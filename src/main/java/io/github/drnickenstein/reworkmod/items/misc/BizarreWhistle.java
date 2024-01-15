package io.github.drnickenstein.reworkmod.items.misc;

import io.github.drnickenstein.reworkmod.init.RwrkSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BizarreWhistle extends Item {

    public BizarreWhistle(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 100;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        pPlayer.startUsingItem(pUsedHand);
        pLevel.playLocalSound(pPlayer.getOnPos(), RwrkSounds.BIZARRE_WHISTLE.get(), SoundSource.MASTER, 0.3f, 1.0f, false);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        if(pLivingEntity instanceof Player) {
            Player player = (Player)pLivingEntity;
            player.getCooldowns().addCooldown(pStack.getItem(), 60);
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
