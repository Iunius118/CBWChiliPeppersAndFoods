package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.CommonClass;
import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.CBW_MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerChiliPepper();
        registerTrivialBlockWithItem(ModBlocks.HOT_SAUCE_BARREL);
        registerCrossBlock(ModBlocks.CURVED_CHILI_STRING);
        this.simpleBlock(ModBlocks.FERROCAPSICUMIUM_BLOCK);
    }

    private void registerChiliPepper() {
        this.getVariantBuilder(ModBlocks.CHILI_PEPPER).forAllStatesExcept(state -> {
            Integer age = state.getValue(CropBlock.AGE);
            String name = "chili_pepper_stage" + age;
            ModelFile model = models().crop(name, CommonClass.modCBWLocation("block/" + name)).renderType("cutout");
            return ConfiguredModel.builder().modelFile(model).build();
        });
    }

    private void registerTrivialBlockWithItem(Block block) {
        ResourceLocation id = getBlockId(block);
        String namespace = id.getNamespace();
        String path = id.getPath();
        this.simpleBlockWithItem(block,
                models().cubeBottomTop(path,
                        ResourceLocation.fromNamespaceAndPath(namespace, "block/" + path + "_side"),
                        ResourceLocation.fromNamespaceAndPath(namespace, "block/" + path + "_bottom"),
                        ResourceLocation.fromNamespaceAndPath(namespace, "block/" + path + "_top")
                ));
    }

    private void registerCrossBlock(Block block) {
        ResourceLocation id = getBlockId(block);
        String namespace = id.getNamespace();
        String path = id.getPath();
        this.simpleBlock(block, models().cross(path, ResourceLocation.fromNamespaceAndPath(namespace, "block/" + path)).renderType("cutout"));
    }

    private ResourceLocation getBlockId(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
