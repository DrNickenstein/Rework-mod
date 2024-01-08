package io.github.drnickenstein.reworkmod.events;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.client.model.MadFungusSageModel;
import io.github.drnickenstein.reworkmod.client.renderer.MadFungusSageRenderer;
import io.github.drnickenstein.reworkmod.init.RwrkEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRwrkEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(RwrkEntities.MAD_FUNGUS_SAGE.get(), MadFungusSageRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(MadFungusSageModel.LAYER_LOCATION, MadFungusSageModel::createBodyLayer);

    }

}
