package io.github.drnickenstein.reworkmod;

import io.github.drnickenstein.reworkmod.init.RwrkItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.event.InputEvent;

@Mod(ReworkMod.MODID)
public class ReworkMod {

    public static final String MODID = "rwrk";

    public ReworkMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RwrkItems.ITEMS.register(bus);
    }
}
