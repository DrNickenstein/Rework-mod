package io.github.drnickenstein.reworkmod;

import io.github.drnickenstein.reworkmod.events.RwrkParticleFactories;
import io.github.drnickenstein.reworkmod.init.*;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ReworkMod.MODID)
public class ReworkMod {

    public static final String MODID = "rwrk";

    public ReworkMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RwrkItems.ITEMS.register(bus);
        RwrkItems.POTIONS.register(bus);
        RwrkBlockEntities.BLOCK_ENTITIES.register(bus);
        RwrkBlocks.BLOCKS.register(bus);
        RwrkMobEffects.MOB_EFFECTS.register(bus);
        RwrkCreativeTabs.TABS.register(bus);
        RwrkEntities.ENTITIES.register(bus);
        RwrkLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);
        RwrkSounds.SOUNDS.register(bus);
        RwrkParticles.PARTICLES.register(bus);

        bus.addListener(RwrkParticleFactories::registerParticleFactories);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(RwrkBlocks.FLUTTERY_MUSHROOM_BLOCK.get(), RenderType.translucent());
    }

}
