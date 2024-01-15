package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.entities.FlutteryMushroom;
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
                    .sized(0.6f, 1.95f)
                    .build(new ResourceLocation(ReworkMod.MODID, "mad_fungus_sage").toString()));

    public static final RegistryObject<EntityType<FlutteryMushroom>> FLUTTERY_MUSHROOM = ENTITIES.register("fluttery_mushroom",
            () -> EntityType.Builder.<FlutteryMushroom>of(FlutteryMushroom::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.8f)
                    .build(new ResourceLocation(ReworkMod.MODID, "fluttery_mushroom").toString()));

}
