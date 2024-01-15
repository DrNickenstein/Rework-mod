package io.github.drnickenstein.reworkmod.client.renderer;

import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.client.model.FlutteryMushroomModel;
import io.github.drnickenstein.reworkmod.entities.FlutteryMushroom;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class FlutteryMushroomRenderer extends MobRenderer<FlutteryMushroom, FlutteryMushroomModel<FlutteryMushroom>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(ReworkMod.MODID, "textures/entity/fluttery_mushroom.png");

    public FlutteryMushroomRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FlutteryMushroomModel(pContext.bakeLayer(FlutteryMushroomModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FlutteryMushroom pEntity) {
        return TEXTURE;
    }
}
