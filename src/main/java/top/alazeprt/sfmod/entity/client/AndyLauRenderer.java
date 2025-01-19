package top.alazeprt.sfmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;
import top.alazeprt.sfmod.entity.custom.AndyLauEntity;

public class AndyLauRenderer extends MobEntityRenderer<AndyLauEntity, AndyLauModel<AndyLauEntity>> {

    private static final Identifier TEXTURE = Identifier.of("sfmod", "textures/entity/andy_lau.png");

    public AndyLauRenderer(EntityRendererFactory.Context context) {
        super(context, new AndyLauModel<>(context.getPart(MobModelLayers.ANDY_LAU)), 0.6f);
    }

    @Override
    public Identifier getTexture(AndyLauEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AndyLauEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
