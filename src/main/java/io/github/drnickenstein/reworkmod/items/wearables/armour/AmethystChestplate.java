package io.github.drnickenstein.reworkmod.items.wearables.armour;

import io.github.drnickenstein.reworkmod.init.RwrkItems;
import net.minecraft.network.chat.Component;
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

    public boolean isFullSet;

    public AmethystChestplate(ArmorMaterial material, Type slot, Properties properties) {

        super(material, slot, properties);
        isFullSet = false;

    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

        super.inventoryTick(stack, level, entity, slotId, isSelected);

        Player player;

        if(entity instanceof Player) {

            player = (Player)entity;

        } else {

            return;

        }

        isFullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RwrkItems.AMETHYST_HELMET.get() &&
                    player.getItemBySlot(EquipmentSlot.CHEST).getItem() == RwrkItems.AMETHYST_CHESTPLATE.get() &&
                    player.getItemBySlot(EquipmentSlot.LEGS).getItem() == RwrkItems.AMETHYST_LEGGINGS.get() &&
                    player.getItemBySlot(EquipmentSlot.FEET).getItem() == RwrkItems.AMETHYST_BOOTS.get();

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        super.appendHoverText(stack, level, components, tooltipFlag);

        Component useDescription = Component.translatable("tooltip.amethyst_armour.use");

        components.add(Component.literal(useDescription.getString()));

    }

    public boolean isSetComplete() {

        return isFullSet;

    }
}
