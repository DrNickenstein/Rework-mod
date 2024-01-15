package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.blocks.blockentities.FlutteryMushroomBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ReworkMod.MODID);


    public static final RegistryObject<BlockEntityType<FlutteryMushroomBlockEntity>> FLUTTERY_MUSHROOM_BLOCK_ENTITY = BLOCK_ENTITIES.register("fluttery_mushroom_block_entity",
    () -> BlockEntityType.Builder.of(FlutteryMushroomBlockEntity::new, RwrkBlocks.FLUTTERY_MUSHROOM_BLOCK.get())
            .build(null));

}
