package io.github.drnickenstein.reworkmod.handler;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.init.RwrkKeybindings;
import io.github.drnickenstein.reworkmod.network.AmethystArmourC2SPacket;
import io.github.drnickenstein.reworkmod.network.RwrkPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {

        Minecraft minecraft = Minecraft.getInstance();

        if(RwrkKeybindings.INSTANCE.activateArmourEffect.consumeClick() && minecraft.player != null) {

            //We are sending a packet since we are currently on the client side.
            RwrkPacketHandler.sendToServer(new AmethystArmourC2SPacket());

        }

    }

}
