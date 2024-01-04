package io.github.drnickenstein.reworkmod.datagen.loot;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.init.RwrkItems;
import io.github.drnickenstein.reworkmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class RwrkGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public RwrkGlobalLootModifiersProvider(PackOutput output) {
        super(output, ReworkMod.MODID);
    }

    @Override
    protected void start() {

        add("warden_larynx_from_warden", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/warden")).build() }, RwrkItems.WARDEN_LARYNX.get()));

        add("frog_tongue_from_frog", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/frog")).build() }, RwrkItems.FROG_TONGUE.get()));

        add("bat_wing_from_bat", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/bat")).build() }, RwrkItems.BAT_WING.get()));

    }
}
