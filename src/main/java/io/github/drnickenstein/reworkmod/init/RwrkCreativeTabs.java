package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RwrkCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReworkMod.MODID);

    public static final RegistryObject<CreativeModeTab> REWORK_TAB = TABS.register("rework_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rework_tab"))
                    .icon(RwrkItems.VOID_CRYSTAL.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        output.accept(RwrkItems.VOID_CRYSTAL.get());
                        output.accept(RwrkItems.AMETHYST_BOOTS.get());
                        output.accept(RwrkItems.AMETHYST_CHESTPLATE.get());
                        output.accept(RwrkItems.AMETHYST_HELMET.get());
                        output.accept(RwrkItems.AMETHYST_LEGGINGS.get());
                        output.accept(RwrkItems.AMETHYST_TALISMAN.get());
                        output.accept(RwrkItems.SONIC_BOOM_DEVICE.get());
                        output.accept(RwrkItems.WARDEN_LARYNX.get());
                    })
                    .build()
    );

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(RwrkItems.AMETHYST_BOOTS);
            event.accept(RwrkItems.AMETHYST_HELMET);
            event.accept(RwrkItems.AMETHYST_CHESTPLATE);
            event.accept(RwrkItems.AMETHYST_LEGGINGS);
            event.accept(RwrkItems.AMETHYST_TALISMAN);
            event.accept(RwrkItems.SONIC_BOOM_DEVICE);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(RwrkItems.VOID_CRYSTAL);
            event.accept(RwrkItems.WARDEN_LARYNX);
        }
    }
}
