// Made with Blockbench 4.12.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package top.alazeprt.sfmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import top.alazeprt.sfmod.entity.animation.AndyLauAnimations;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;

public class AndyLauModel<T extends AndyLauEntity> extends SinglePartEntityModel<T> {
	private final ModelPart andy_lau;
	private final ModelPart head;

	public AndyLauModel(ModelPart root) {
		this.andy_lau = root.getChild("andy_lau");
		this.head = andy_lau.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData andy_lau = modelPartData.addChild("andy_lau", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 18.0F, 0.0F));

		ModelPartData hand2 = andy_lau.addChild("hand2", ModelPartBuilder.create().uv(16, 32).cuboid(8.0F, -18.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, 0.0F));

		ModelPartData leg2 = andy_lau.addChild("leg2", ModelPartBuilder.create().uv(0, 32).cuboid(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 6.0F, 0.0F));

		ModelPartData leg1 = andy_lau.addChild("leg1", ModelPartBuilder.create().uv(24, 16).cuboid(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 6.0F, 0.0F));

		ModelPartData hand1 = andy_lau.addChild("hand1", ModelPartBuilder.create().uv(32, 0).cuboid(-7.0F, -24.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 6.0F, 0.0F));

		ModelPartData head = andy_lau.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -26.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData body = andy_lau.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-7.0F, -18.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		andy_lau.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return andy_lau;
	}

	private void setHeadAngles(float yaw, float pitch) {
		yaw = MathHelper.clamp(yaw, -30F, 30F);
		pitch = MathHelper.clamp(pitch, -5F, 10F);

		this.head.yaw = yaw * 0.017453292F;
		this.head.pitch = pitch * 0.017453292F;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);
		this.animateMovement(AndyLauAnimations.WALK, limbAngle, limbDistance, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, AndyLauAnimations.IDLE, animationProgress, 1f);

	}
}