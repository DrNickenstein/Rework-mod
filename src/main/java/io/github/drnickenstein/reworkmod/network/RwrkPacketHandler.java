package io.github.drnickenstein.reworkmod.network;

import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class RwrkPacketHandler {

    private static final SimpleChannel INSTANCE = ChannelBuilder.named(new ResourceLocation(ReworkMod.MODID, "main"))
            .serverAcceptedVersions(((status, version) -> true))
            .clientAcceptedVersions(((status, version) -> true))
            .networkProtocolVersion(1)
            .simpleChannel();

    public static void register() {

        INSTANCE.messageBuilder(AmethystArmourC2SPacket.class, NetworkDirection.PLAY_TO_SERVER)
                .encoder(AmethystArmourC2SPacket::encode)
                .decoder(AmethystArmourC2SPacket::new)
                .consumerMainThread(AmethystArmourC2SPacket::handle)
                .add();

    }

    public static void sendToServer(Object message) {

        INSTANCE.send(message, PacketDistributor.SERVER.noArg());

    }

}
