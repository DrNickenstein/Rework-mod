package io.github.drnickenstein.reworkmod.init;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.items.misc.SonicBoomDevice;
import io.github.drnickenstein.reworkmod.items.misc.BizarreWhistle;
import io.github.drnickenstein.reworkmod.items.wearables.AmethystTalisman;
import io.github.drnickenstein.reworkmod.items.wearables.armour.AmethystChestplate;
import io.github.drnickenstein.reworkmod.util.RwrkArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.github.drnickenstein.reworkmod.init.RwrkCreativeTabs.addToTab;

public class RwrkItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkMod.MODID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ReworkMod.MODID);


    //Misc items

    public static final RegistryObject<Item> VOID_CRYSTAL = addToTab(ITEMS.register("void_crystal", () -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> WARDEN_LARYNX = addToTab(ITEMS.register("warden_larynx",() -> new Item(new Item.Properties()
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> FROG_TONGUE = addToTab(ITEMS.register("frog_tongue", () -> new Item(new Item.Properties())));
    public static final RegistryObject<Item> BAT_WING = addToTab(ITEMS.register("bat_wing", () -> new Item(new Item.Properties())));
    public static final RegistryObject<Item> FLUTTERY_MUSHROOM_CAP = addToTab(ITEMS.register("fluttery_mushroom_cap", () -> new Item(new Item.Properties())));

    //Special items

    public static final RegistryObject<Item> SONIC_BOOM_DEVICE = addToTab(ITEMS.register("sonic_boom_device", () -> new SonicBoomDevice(new Item.Properties()
            .stacksTo(1)
            .rarity(Rarity.EPIC))));
    public static final RegistryObject<Item> BIZARRE_WHISTLE = addToTab(ITEMS.register("bizarre_whistle", () -> new BizarreWhistle(new Item.Properties()
            .stacksTo(1))));

    //Spawn Eggs

    public static final RegistryObject<ForgeSpawnEggItem> MAD_FUNGUS_SAGE_SPAWN_EGG = addToTab(ITEMS.register("mad_fungus_sage_spawn_egg",
            () -> new ForgeSpawnEggItem(RwrkEntities.MAD_FUNGUS_SAGE, 0xd1d1d1, 0x334a7a, new Item.Properties())));
    public static final RegistryObject<ForgeSpawnEggItem> FLUTTERY_MUSHROOM_SPAWN_EGG = addToTab(ITEMS.register("fluttery_mushroom_spawn_egg",
            () -> new ForgeSpawnEggItem(RwrkEntities.FLUTTERY_MUSHROOM, 0x334a7a, 0xeb8634, new Item.Properties())));


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

    public static final RegistryObject<BlockItem> FLUTTERY_MUSHROOM_BLOCK_ITEM = addToTab(ITEMS.register("fluttery_mushroom_block", () -> new BlockItem(RwrkBlocks.FLUTTERY_MUSHROOM_BLOCK.get(),
            new Item.Properties()
    )));


    //Potions

    public static final RegistryObject<Potion> MINERS_POTION = POTIONS.register("miners_potion", () -> new Potion(
            new MobEffectInstance(MobEffects.NIGHT_VISION, 12000),
            new MobEffectInstance(MobEffects.DIG_SPEED, 12000)));

}
