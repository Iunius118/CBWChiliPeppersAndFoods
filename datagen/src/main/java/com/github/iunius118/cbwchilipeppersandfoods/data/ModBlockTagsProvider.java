package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.CBW_MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // - Namespace: minecraft //
        tag(BlockTags.CROPS).add(ModBlocks.CHILI_PEPPER);
        tag(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.CHILI_PEPPER);
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.CHILI_PEPPER).add(ModBlocks.HOT_SAUCE_BARREL);
        // Mining a block of Fe-Cap requires at least a stone-level pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
        tag(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);

        // - Namespace: c //
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ModBlockTags.C_STORAGE_BLOCKS_CHILI)
                .addTag(ModBlockTags.STORAGE_BLOCKS_FERROCAPSICUMIUM);
        tag(ModBlockTags.C_STORAGE_BLOCKS_CHILI).add(ModBlocks.CURVED_CHILI_STRING);

        // - Namespace: chilibulletweapons //
        tag(ModBlockTags.STORAGE_BLOCKS_FERROCAPSICUMIUM).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
    }
}
