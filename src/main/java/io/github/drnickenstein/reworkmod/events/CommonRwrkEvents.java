package io.github.drnickenstein.reworkmod.events;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.entities.FlutteryMushroom;
import io.github.drnickenstein.reworkmod.entities.MadFungusSage;
import io.github.drnickenstein.reworkmod.init.RwrkEntities;
import io.github.drnickenstein.reworkmod.network.RwrkPacketHandler;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonRwrkEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {

        event.put(RwrkEntities.MAD_FUNGUS_SAGE.get(), MadFungusSage.createMadFungusSageAttributes().build());
        event.put(RwrkEntities.FLUTTERY_MUSHROOM.get(), FlutteryMushroom.createFlutteryMushroomAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            RwrkPacketHandler.register();
        });
    }

}
