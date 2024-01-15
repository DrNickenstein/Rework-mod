package io.github.drnickenstein.reworkmod.client.model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.entities.FlutteryMushroom;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class FlutteryMushroomModel<T extends FlutteryMushroom> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ReworkMod.MODID, "fluttery_mushroom"), "main");
	private final ModelPart Mushroom;

	public FlutteryMushroomModel(ModelPart root) {
		this.Mushroom = root.getChild("Mushroom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Mushroom = partdefinition.addOrReplaceChild("Mushroom", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Stem = Mushroom.addOrReplaceChild("Stem", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 14).addBox(-2.0F, -4.0F, 3.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 30).addBox(3.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 30).addBox(-4.0F, -4.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 28).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Cap = Mushroom.addOrReplaceChild("Cap", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-5.0F, -12.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(16, 13).addBox(4.0F, -12.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(-4.0F, -12.0F, -5.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(-4.0F, -12.0F, 4.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Legs = Mushroom.addOrReplaceChild("Legs", CubeListBuilder.create().texOffs(34, 17).addBox(-1.0F, 1.0F, 1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 23).addBox(-1.0F, 1.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = Mushroom.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 1.0F));

		PartDefinition cube_r1 = Arms.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Arms.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 1.0F, 1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Mushroom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}