package io.github.drnickenstein.reworkmod.network;

import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class AmethystArmourC2SPacket {

    public AmethystArmourC2SPacket() {

    }

    public AmethystArmourC2SPacket(FriendlyByteBuf buffer) {

    }

    public void encode(FriendlyByteBuf buffer) {

    }

    public void handle(CustomPayloadEvent.Context context) {

        context.enqueueWork(() -> {

            System.out.println("packet sent");

            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            ItemStack wornItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
            Item wornItem = wornItemStack.getItem();

            if(wornItem instanceof AmethystChestplate) {

                AmethystChestplate wornAmethystChestplate = (AmethystChestplate)wornItem;

                if(wornAmethystChestplate.isSetFull(wornItemStack)) {

                    System.out.println("set is full");
                    wornAmethystChestplate.activateEffects(wornItemStack);

                }

            }

        });

    }
}
