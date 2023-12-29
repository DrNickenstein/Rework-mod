package io.github.drnickenstein.reworkmod.handler;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.init.RwrkKeybindings;
import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.sql.SQLOutput;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {

    static int lastUsageTick = 0;

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {

        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        if(minecraft.player != null) {

            Item wornItem = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
            AmethystChestplate wornAmethystChestplate;

            if(player.isInvulnerable() && player.tickCount >= lastUsageTick + 60) {

                player.setInvulnerable(false);
                System.out.println("Invulnerability removed");

            }

            if (wornItem instanceof AmethystChestplate) {

                wornAmethystChestplate = (AmethystChestplate) wornItem;

            } else {
                return;
            }

            if (RwrkKeybindings.INSTANCE.activateArmourEffect.consumeClick()) {

                System.out.println("Keybind clicked");

                if(wornAmethystChestplate.isFullSet) {

                    System.out.println("The player is wearing a full set");

                    if(player.tickCount >= lastUsageTick + 500) {

                        System.out.println("The click wasn't withing the cooldown");

                        lastUsageTick = player.tickCount;
                        player.setInvulnerable(true);
                        System.out.println("Invulnerability set");

                    }

                }



            }

        }

    }

}
