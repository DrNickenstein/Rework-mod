package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ReworkMod.MODID);


    public static final RegistryObject<SoundEvent> BIZARRE_WHISTLE = SOUNDS.register("bizarre_whistle",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ReworkMod.MODID, "bizarre_whistle")));

}
