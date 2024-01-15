package io.github.drnickenstein.reworkmod.entities;

import io.github.drnickenstein.reworkmod.init.RwrkEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class FlutteryMushroom extends Animal {


    public FlutteryMushroom(EntityType<FlutteryMushroom> type, Level level) {
        super(type, level);
    }

    public FlutteryMushroom(Level level, double x, double y, double z) {
        this(RwrkEntities.FLUTTERY_MUSHROOM.get(), level);
        setPos(x, y, z);
    }

    public FlutteryMushroom(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return new FlutteryMushroom(pLevel, this.blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 10.0f, 0.7D, 0.8D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        if(pSource.is(DamageTypeTags.IS_FALL) || pSource.is(DamageTypeTags.IS_FIRE)) {
            return true;
        }
        return super.isInvulnerableTo(pSource);
    }

    public static AttributeSupplier.Builder createFlutteryMushroomAttributes() {
        return Villager.createAttributes();
    }

}
