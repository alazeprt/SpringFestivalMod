package top.alazeprt.sfmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import top.alazeprt.sfmod.entity.client.AndyLauModel;
import top.alazeprt.sfmod.entity.client.AndyLauRenderer;
import top.alazeprt.sfmod.entity.client.MobModelLayers;

public class SpringFestivalClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(SpringFestivalMod.ANDY_LAU, AndyLauRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MobModelLayers.ANDY_LAU, AndyLauModel::getTexturedModelData);
    }
}
