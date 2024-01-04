package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

public class RwrkBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkMod.MODID);

    public static final RegistryObject<Block> DEEPSLATE_VOID_CRYSTAL_ORE = BLOCKS.register("deepslate_void_crystal_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .lightLevel(state -> 10)
                    .strength(5)
                    .pushReaction(PushReaction.PUSH_ONLY)
                    .requiresCorrectToolForDrops()
                    .instrument(NoteBlockInstrument.DRAGON)

    ));

}
