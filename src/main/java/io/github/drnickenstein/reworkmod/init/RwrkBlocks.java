package io.github.drnickenstein.reworkmod.init;


import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.blocks.FlutteryMushroomBlock;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkMod.MODID);

    public static final RegistryObject<DropExperienceBlock> DEEPSLATE_VOID_CRYSTAL_ORE = BLOCKS.register("deepslate_void_crystal_ore",
            () -> new DropExperienceBlock(ConstantInt.of(10),
                    BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .lightLevel(state -> 10)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
            )
    );

    public static final RegistryObject<Block> FLUTTERY_MUSHROOM_BLOCK = BLOCKS.register("fluttery_mushroom_block",
            () -> new FlutteryMushroomBlock(Blocks.MUSHROOM_STEM.properties().lightLevel((lightLevel) -> 8)));
}
