package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.entities.MadFungusSage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ReworkMod.MODID);


    public static final RegistryObject<EntityType<MadFungusSage>> MAD_FUNGUS_SAGE = ENTITIES.register("mad_fungus_sage",
            () -> EntityType.Builder.<MadFungusSage>of(MadFungusSage::new, MobCategory.MISC)
                    .sized(0.6F, 1.95F)
                    .build(new ResourceLocation(ReworkMod.MODID, "mad_fungus_sage").toString()));

}
