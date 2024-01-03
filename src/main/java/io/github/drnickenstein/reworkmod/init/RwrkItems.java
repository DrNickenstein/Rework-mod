package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.items.misc.SonicBoomDevice;
import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import io.github.drnickenstein.reworkmod.util.RwrkArmorMaterials;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RwrkItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkMod.MODID);


    //Oggetti vari

    public static final RegistryObject<Item> VOID_CRYSTAL = ITEMS.register("void_crystal", () -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> WARDENS_LARYNX = ITEMS.register("wardens_larynx",() -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SONIC_BOOM_DEVICE = ITEMS.register("sonic_boom_device", () -> new SonicBoomDevice(new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> AMETHYST_TALISMAN = ITEMS.register("amethyst_talisman", () -> new Item(new Item.Properties()
            .stacksTo(1)));


    //Armature

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",() -> new AmethystChestplate(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",() -> new ArmorItem(RwrkArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));

    //Utensili


}
