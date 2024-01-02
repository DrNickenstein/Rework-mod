package io.github.drnickenstein.reworkmod.handler;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.init.RwrkKeybindings;
import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {

        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        if(minecraft.player != null) {

            ItemStack wornItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
            Item wornItem = wornItemStack.getItem();
            AmethystChestplate wornAmethystChestplate;

            if (wornItem instanceof AmethystChestplate) {
                wornAmethystChestplate = (AmethystChestplate) wornItem;
            } else {
                return;
            }

            if (RwrkKeybindings.INSTANCE.activateArmourEffect.consumeClick()) {

                System.out.println("key pressed");

                if(wornAmethystChestplate.isSetFull(wornItemStack)) {

                    System.out.println("set is full");
                    wornAmethystChestplate.activateEffects(wornItemStack);

                }

            }

        }

    }

}
