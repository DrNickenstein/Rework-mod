package io.github.drnickenstein.reworkmod.events;

import io.github.drnickenstein.reworkmod.init.RwrkParticles;
import io.github.drnickenstein.reworkmod.particles.ParticleFlutteryMushroomSpores;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RwrkParticleFactories  {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(RwrkParticles.FLUTTERY_MUSHROOM_SPORES.get(), ParticleFlutteryMushroomSpores.Provider::new);
    }
}
