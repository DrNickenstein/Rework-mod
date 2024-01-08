package io.github.drnickenstein.reworkmod.client.renderer;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.client.model.MadFungusSageModel;
import io.github.drnickenstein.reworkmod.entities.MadFungusSage;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MadFungusSageRenderer extends MobRenderer<MadFungusSage, MadFungusSageModel<MadFungusSage>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(ReworkMod.MODID, "textures/entity/mad_fungus_sage.png");

    public MadFungusSageRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MadFungusSageModel(pContext.bakeLayer(MadFungusSageModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull MadFungusSage pEntity) {
        return TEXTURE;
    }
}
