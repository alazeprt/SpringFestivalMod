package top.alazeprt.sfmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import top.alazeprt.sfmod.entity.client.AndyLauModel;
import top.alazeprt.sfmod.entity.client.AndyLauRenderer;
import top.alazeprt.sfmod.entity.client.MobModelLayers;

public class SpringFestivalClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SpringFestivalMod.ANDY_LAU, AndyLauRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MobModelLayers.ANDY_LAU, AndyLauModel::getTexturedModelData);
        BlockRenderLayerMap.INSTANCE.putBlock(SpringFestivalMod.FROZEN_ANDY_LAU_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SpringFestivalMod.FUYIN1, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SpringFestivalMod.FUYIN2, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SpringFestivalMod.FUYIN3, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SpringFestivalMod.FUYIN4, RenderLayer.getCutout());
    }
}
