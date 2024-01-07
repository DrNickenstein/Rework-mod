package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.items.wearables.AmethystTalisman;
import io.github.drnickenstein.reworkmod.items.misc.SonicBoomDevice;
import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import io.github.drnickenstein.reworkmod.util.RwrkArmorMaterials;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.drnickenstein.reworkmod.init.RwrkCreativeTabs.addToTab;

public class RwrkItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkMod.MODID);


    //Misc items

    public static final RegistryObject<Item> VOID_CRYSTAL = addToTab(ITEMS.register("void_crystal", () -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> WARDEN_LARYNX = addToTab(ITEMS.register("warden_larynx",() -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> SONIC_BOOM_DEVICE = addToTab(ITEMS.register("sonic_boom_device", () -> new SonicBoomDevice(new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> FROG_TONGUE = addToTab(ITEMS.register("frog_tongue", () -> new Item(new Item.Properties())));
    public static final RegistryObject<Item> BAT_WING = addToTab(ITEMS.register("bat_wing", () -> new Item(new Item.Properties())));


    //Wearables
    public static final RegistryObject<Item> AMETHYST_TALISMAN = addToTab(ITEMS.register("amethyst_talisman", () -> new AmethystTalisman(new Item.Properties()
            .stacksTo(1))));


    //Armour

    public static final RegistryObject<Item> AMETHYST_HELMET = addToTab(ITEMS.register("amethyst_helmet",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties())));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = addToTab(ITEMS.register("amethyst_chestplate",() -> new AmethystChestplate(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties())));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = addToTab(ITEMS.register("amethyst_leggings",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties())));
    public static final RegistryObject<Item> AMETHYST_BOOTS = addToTab(ITEMS.register("amethyst_boots",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties())));


    //Blocks

    public static final RegistryObject<BlockItem> DEEPSLATE_VOID_CRYSTAL_ORE_ITEM = addToTab(ITEMS.register("deepslate_void_crystal_ore", () -> new BlockItem(RwrkBlocks.DEEPSLATE_VOID_CRYSTAL_ORE.get(),
                    new Item.Properties()
            )));


    //Tools

}
