package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = ReworkMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RwrkCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReworkMod.MODID);

    public static final List<Supplier<? extends ItemLike>> RWRK_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> REWORK_TAB = TABS.register("rework_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rework_tab"))
                    .icon(RwrkItems.VOID_CRYSTAL.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        RWRK_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
                    })
                    .build()
    );

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> itemLike) {
        RWRK_TAB_ITEMS.add(itemLike);
        return itemLike;
    }
}
