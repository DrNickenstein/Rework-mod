package io.github.drnickenstein.reworkmod;

import io.github.drnickenstein.reworkmod.init.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ReworkMod.MODID)
public class ReworkMod {

    public static final String MODID = "rwrk";

    public ReworkMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RwrkItems.ITEMS.register(bus);
        RwrkBlocks.BLOCKS.register(bus);
        RwrkMobEffects.MOB_EFFECTS.register(bus);
        RwrkCreativeTabs.TABS.register(bus);
        RwrkLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);
    }
}
