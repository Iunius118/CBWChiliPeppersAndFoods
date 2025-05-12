package com.github.iunius118.cbwchilipeppersandfoods;

import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class CBWChiliPeppersAndFoodsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBlockRenderType();
    }

    private void registerBlockRenderType() {
        // Set render type of crop block to cutout
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHILI_PEPPER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURVED_CHILI_STRING, RenderType.cutout());
    }
}
