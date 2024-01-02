package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.mobeffects.InvulnerabilityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkMobEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ReworkMod.MODID);


    public static final RegistryObject<MobEffect> INVULNERABILITY = MOB_EFFECTS.register("invulnerability", () -> new InvulnerabilityEffect(MobEffectCategory.BENEFICIAL, 21266245));

}
