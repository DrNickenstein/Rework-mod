package io.github.drnickenstein.reworkmod.client.model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.drnickenstein.reworkmod.ReworkMod;
import io.github.drnickenstein.reworkmod.entities.MadFungusSage;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MadFungusSageModel<T extends MadFungusSage> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ReworkMod.MODID, "mad_fungus_sage"), "main");
	private final ModelPart stalactiteCaveVillager;

	public MadFungusSageModel(ModelPart root) {
		this.stalactiteCaveVillager = root.getChild("stalactiteCaveVillager");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition stalactiteCaveVillager = partdefinition.addOrReplaceChild("stalactiteCaveVillager", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition head = stalactiteCaveVillager.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -25.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition body = stalactiteCaveVillager.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -25.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = stalactiteCaveVillager.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(14, 44).addBox(-4.0F, -13.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(38, 32).addBox(0.0F, -13.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arms = stalactiteCaveVillager.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tube_r1 = arms.addOrReplaceChild("tube_r1", CubeListBuilder.create().texOffs(14, 36).addBox(-4.0F, -13.0F, -18.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(42, 18).addBox(-8.0F, -17.0F, -18.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 48).addBox(4.0F, -17.0F, -18.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tunic = stalactiteCaveVillager.addOrReplaceChild("tunic", CubeListBuilder.create().texOffs(32, 0).addBox(-3.5F, -24.0F, -15.5F, 9.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 19.0F));

		PartDefinition front = tunic.addOrReplaceChild("front", CubeListBuilder.create().texOffs(52, 0).addBox(4.5F, -18.0F, -7.5F, 1.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(50, 0).addBox(-3.5F, -18.0F, -7.5F, 1.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(3.5F, -17.0F, -7.5F, 1.0F, 17.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(52, 48).addBox(-2.5F, -17.0F, -7.5F, 1.0F, 17.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 54).addBox(2.5F, -16.0F, -7.5F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-1.5F, -16.0F, -7.5F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(46, 48).addBox(-0.5F, -15.0F, -7.5F, 3.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -15.0F));

		PartDefinition sides = tunic.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(0, 29).addBox(5.5F, -24.0F, -22.5F, 0.0F, 18.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(28, 11).addBox(-3.5F, -24.0F, -22.5F, 0.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition collar = tunic.addOrReplaceChild("collar", CubeListBuilder.create().texOffs(19, 0).addBox(-3.5F, -24.0F, -22.5F, 1.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(17, 0).addBox(4.5F, -24.0F, -22.5F, 1.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(-2.5F, -24.0F, -16.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(3.5F, -24.0F, -16.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		stalactiteCaveVillager.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}