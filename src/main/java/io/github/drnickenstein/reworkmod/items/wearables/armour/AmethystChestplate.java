package io.github.drnickenstein.reworkmod.items.wearables.armour;

import io.github.drnickenstein.reworkmod.init.RwrkItems;
import io.github.drnickenstein.reworkmod.init.RwrkMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AmethystChestplate extends ArmorItem {

    /*Items are singletons, therefore variables that indicate
    the cooldown time or whether the set is full or not are specific
    to the ItemStack and are created as CompoundTags.

    currentTime is a class variable because it is the same for all
    instances of the item.*/
    long currentTime;

    public AmethystChestplate(ArmorMaterial material, Type slot, Properties properties) {

        super(material, slot, properties);
        currentTime = 0;

    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

        super.inventoryTick(stack, level, entity, slotId, isSelected);

        Player player;

        /*The following code is only executed if the LivingEntity
        wearing the armour is an instance of Player, since only
        players can activate abilities through the keyboard.*/

        if(entity instanceof Player) {
            player = (Player)entity;
        } else {
            return;
        }

        //We are creating the 'ability' tag, under which
        //we will put several different values

        CompoundTag tag = stack.getOrCreateTagElement("ability");

        tag.putBoolean("isSetFull", player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RwrkItems.AMETHYST_HELMET.get() &&
                player.getItemBySlot(EquipmentSlot.CHEST).getItem() == RwrkItems.AMETHYST_CHESTPLATE.get() &&
                player.getItemBySlot(EquipmentSlot.LEGS).getItem() == RwrkItems.AMETHYST_LEGGINGS.get() &&
                player.getItemBySlot(EquipmentSlot.FEET).getItem() == RwrkItems.AMETHYST_BOOTS.get());

        currentTime = level.getGameTime();

        System.out.println("tick start, isEffectActive: " + tag.getBoolean("isEffectActive"));

        if(tag.getLong("lastUsage") != 0 && shouldDeactivateEffects(stack)) {

            player.removeEffect(RwrkMobEffects.INVULNERABILITY.get());
            player.setInvulnerable(false);
            System.out.println("Invulnerability removed");
            tag.putBoolean("isEffectActive", false);

        }

        if(tag.getBoolean("isEffectActive")) {

            if(currentTime - tag.getLong("lastUsage") >= 3800) {
                stack.getOrCreateTagElement("ability").putLong("lastUsage", currentTime);
            }

            if(tag.getLong("lastUsage") == currentTime) {
                player.addEffect(new MobEffectInstance(RwrkMobEffects.INVULNERABILITY.get(), 200));
            }

            player.setInvulnerable(true);
            System.out.println("Invulnerability set");
            System.out.println("isEffect active if, isEffectActive: " + tag.getBoolean("isEffectActive"));

        }

        tag.putLong("cooldownTime", 180 - (currentTime - tag.getLong("lastUsage")) / 20);

        System.out.println("tick end, isEffectActive: " + tag.getBoolean("isEffectActive"));

    }

    public void activateEffects(ItemStack stack) {

        long lastUsage = stack.getOrCreateTagElement("ability").getLong("lastUsage");

        if(currentTime - lastUsage >= 3800) {
            System.out.println("Effect applied.");
            stack.getOrCreateTagElement("ability").putBoolean("isEffectActive", true);
        }

        System.out.println("activateEffects call ending. " + stack.getOrCreateTagElement("ability").getBoolean("isEffectActive"));
    }
    public boolean shouldDeactivateEffects(ItemStack stack) {

        long lastUsage = stack.getOrCreateTagElement("ability").getLong("lastUsage");

        if(currentTime - lastUsage >= 200) {
            return true;
        }
        return false;
    }

    public boolean isSetFull(ItemStack stack) {
            return stack.getOrCreateTagElement("ability").getBoolean("isSetFull");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        super.appendHoverText(stack, level, components, tooltipFlag);

        Component useDescription = Component.translatable("tooltip.amethyst_armour.use");
        Component cooldown = Component.translatable("tooltip.amethyst_armour.cooldown");
        Component readyForUse = Component.translatable("tooltip.amethyst_armour.ready_for_use");

        components.add(Component.literal(useDescription.getString()));

        long cooldownTime = stack.getOrCreateTagElement("ability").getLong("cooldownTime");

        if(cooldownTime > 0) {

            components.add(Component.literal(cooldown.getString() + cooldownTime + "s"));

        } else {

            components.add(Component.literal(readyForUse.getString()).withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.ITALIC));

        }

    }

}
