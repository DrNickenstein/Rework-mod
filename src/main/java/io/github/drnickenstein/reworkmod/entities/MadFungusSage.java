package io.github.drnickenstein.reworkmod.entities;

import io.github.drnickenstein.reworkmod.init.RwrkEntities;
import io.github.drnickenstein.reworkmod.init.RwrkItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class MadFungusSage extends Animal {

    private static final EntityDataAccessor<Integer> GIVEN_BAT_WINGS = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GIVEN_FROG_TONGUES = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GIVEN_GLOW_BERRIES = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GIVEN_EMERALDS = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Integer> GIVEN_FLUTTERY_MUSHROOM_CAPS = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);
    /*The quest stages are 4:
      0 - Give the items required to start
      the quest to the Mad Fungus Sage

      1 - Obtain the items to proceed with
      the quest (whistle and potion)

      2 - Find and kill the Fluttery Fungus,
      then go back to the Mad Fungus Sage and
      give him the Mushroom Caps

      3 - Get your rewards
    */
    private static final EntityDataAccessor<Integer> QUEST_STAGE = SynchedEntityData.defineId(MadFungusSage.class, EntityDataSerializers.INT);


    public MadFungusSage(EntityType<MadFungusSage> type, Level level) {
        super(type, level);
    }

    public MadFungusSage(Level level, double x, double y, double z) {
        this(RwrkEntities.MAD_FUNGUS_SAGE.get(), level);
        setPos(x, y, z);
    }

    public MadFungusSage(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Override
    protected void defineSynchedData() {

        super.defineSynchedData();
        this.entityData.define(GIVEN_BAT_WINGS, 0);
        this.entityData.define(GIVEN_FROG_TONGUES, 0);
        this.entityData.define(GIVEN_GLOW_BERRIES, 0);
        this.entityData.define(GIVEN_EMERALDS, 0);
        this.entityData.define(QUEST_STAGE, 0);

    }

    private int batWings() {
        return this.entityData.get(GIVEN_BAT_WINGS);
    }

    private void giveBatWing(ItemStack stack) {
        this.entityData.set(GIVEN_BAT_WINGS, batWings() + 1);
        stack.shrink(1);
    }

    private int frogTongues() {
        return this.entityData.get(GIVEN_FROG_TONGUES);
    }

    private void giveFrogTongue(ItemStack stack) {
        this.entityData.set(GIVEN_FROG_TONGUES, frogTongues() + 1);
        stack.shrink(1);
    }

    private int glowBerries() {
        return this.entityData.get(GIVEN_GLOW_BERRIES);
    }

    private void giveGlowBerry(ItemStack stack) {
        this.entityData.set(GIVEN_GLOW_BERRIES, glowBerries() + 1);
        stack.shrink(1);
    }

    private int emeralds() {
        return this.entityData.get(GIVEN_EMERALDS);
    }

    private void giveEmerald(ItemStack stack) {
        this.entityData.set(GIVEN_EMERALDS, emeralds() + 1);
        stack.shrink(1);
    }

    private int flutteryMushroomCaps() {
        return this.entityData.get(GIVEN_FLUTTERY_MUSHROOM_CAPS);
    }

    private void giveFlutteryMushroomCap(ItemStack stack) {
        this.entityData.set(GIVEN_FLUTTERY_MUSHROOM_CAPS, flutteryMushroomCaps() + 1);
        stack.shrink(1);
    }

    private int questStage() {
        return this.entityData.get(QUEST_STAGE);
    }

    private void advanceQuest() {
        this.entityData.set(QUEST_STAGE, questStage() + 1);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {

        if(pHand.equals(InteractionHand.MAIN_HAND)) {

            ItemStack interactingItemStack = pPlayer.getItemInHand(pHand);
            Item item = interactingItemStack.getItem();

            if (questStage() == 0) {

                if (item == RwrkItems.BAT_WING.get() && batWings() < 1) {
                    giveBatWing(interactingItemStack);
                } else if (item == RwrkItems.FROG_TONGUE.get() && frogTongues() < 3) {
                    giveFrogTongue(interactingItemStack);
                } else if (item == Items.EMERALD && emeralds() < 10) {
                    giveEmerald(interactingItemStack);
                } else if (item == Items.GLOW_BERRIES && glowBerries() < 5) {
                    giveGlowBerry(interactingItemStack);
                }

                typeStageOneDialog(item, pPlayer);
            }

            if(questStage() == 2) {

                if(item == RwrkItems.FLUTTERY_MUSHROOM_CAP.get() && flutteryMushroomCaps() < 2) {
                    giveFlutteryMushroomCap(interactingItemStack);
                }

                typeStageTwoDialog(item, pPlayer);
            }

            updateQuestStage(pPlayer);
        }

        return super.mobInteract(pPlayer, pHand);
    }

    private void updateQuestStage(Player player) {

        if(batWings() == 1 && frogTongues() == 3 &&
        glowBerries() == 5 && emeralds() == 10 &&
        questStage() == 0) {
            advanceQuest();
            BehaviorUtils.throwItem(this, new ItemStack(RwrkItems.BIZARRE_WHISTLE.get()), player.position());
            BehaviorUtils.throwItem(this, PotionUtils.setPotion(new ItemStack(Items.POTION), RwrkItems.MINERS_POTION.get()), player.position());
            advanceQuest();
        }

        if(flutteryMushroomCaps() == 2 && questStage() == 2) {

            advanceQuest();
            //LAST PHASE LOGIC

        }
    }

    private void typeStageOneDialog(Item item, Player player) {

        switch(ForgeRegistries.ITEMS.getKey(item).toString()) {

            case "minecraft:air":
                break;
            case "rwrk:bat_wing":
                player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.bat_wing_received"), false);
                break;
            case "rwrk:frog_tongue":
                player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.frog_tongue_received"), false);
                break;
            case "minecraft:glow_berries":
                player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.glow_berries_received"), false);
                break;
            case "minecraft:emerald":
                player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.emerald_received"), false);
                break;
            default:
                player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.nothing_received"), false);
        }

        String dialog = Component.translatable("dialog.mad_fungus_sage.still_need").getString();

        int missingEmeralds = 10 - emeralds();
        int missingGlowBerries = 5 - glowBerries();
        int missingBatWings = 1 - batWings();
        int missingFrogTongues = 3 - frogTongues();

        if(missingEmeralds > 0) {
            dialog += missingEmeralds + Component.translatable("dialog.mad_fungus_sage.missing_emeralds").getString();
        }
        if(missingGlowBerries > 0) {
            dialog += missingGlowBerries + Component.translatable("dialog.mad_fungus_sage.missing_glow_berries").getString();
        }
        if(missingBatWings > 0) {
            dialog += missingBatWings + Component.translatable("dialog.mad_fungus_sage.missing_bat_wings").getString();
        }
        if(missingFrogTongues > 0) {
            dialog += missingFrogTongues + Component.translatable("dialog.mad_fungus_sage.missing_frog_tongues").getString();
        }

        dialog += "\n" + Component.translatable("dialog.mad_fungus_sage.bring_me_stage_0").getString();
        Component dialogComponent = Component.literal(dialog);

        player.displayClientMessage(dialogComponent, false);

    }

    private void typeStageTwoDialog(Item item, Player player) {

        if(item == RwrkItems.FLUTTERY_MUSHROOM_CAP.get()) {
            player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.fluttery_mushroom_cap_received"), false);
        } else if(item != Items.AIR){
            player.displayClientMessage(Component.translatable("dialog.mad_fungus_sage.nothing_received"), false);
        }

        String dialog = Component.translatable("dialog.mad_fungus_sage.still_need").getString();

        int missingCaps = 2 - flutteryMushroomCaps();

        if(missingCaps > 0) {
            dialog += missingCaps + Component.translatable("dialog.mad_fungus_sage.missing_fluttery_mushroom_caps").getString();
        }

        dialog += "\n" + Component.translatable("dialog.mad_fungus_sage.bring_me_stage_2").getString();
        Component dialogComponent = Component.literal(dialog);

        player.displayClientMessage(dialogComponent, false);

    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return new MadFungusSage(pLevel, this.blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.75D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createMadFungusSageAttributes() {
        return Villager.createAttributes();
    }
}
