package io.github.drnickenstein.reworkmod.util;


import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.init.RwrkItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum RwrkArmorMaterials implements ArmorMaterial {

    AMETHYST("amethyst", 30, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0f, -1f,
            () -> Ingredient.of(RwrkItems.VOID_ORE.get()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private RwrkArmorMaterials(String materialName, int durability, int[] protections, int enchantability, SoundEvent equipSound, float materialToughness, float knockbackResistanceCoefficient, Supplier<Ingredient> ingredient) {

        this.name = materialName;
        this.durabilityMultiplier = durability;
        this.slotProtections = protections;
        this.enchantmentValue = enchantability;
        this.sound = equipSound;
        this.toughness = materialToughness;
        this.knockbackResistance = knockbackResistanceCoefficient;
        this.repairIngredient = ingredient;

    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_PER_SLOT[type.ordinal()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.slotProtections[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ReworkMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
