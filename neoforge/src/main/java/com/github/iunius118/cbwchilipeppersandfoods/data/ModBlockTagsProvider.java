package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.CBW_MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.CROPS).add(ModBlocks.CHILI_PEPPER);
        tag(BlockTags.MAINTAINS_FARMLAND).add(ModBlocks.CHILI_PEPPER);
        tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.CHILI_PEPPER).add(ModBlocks.HOT_SAUCE_BARREL);
        // Block of ferro-capsicumium requires a pickaxe that is at least stone level to mine
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
        tag(BlockTags.BEACON_BASE_BLOCKS).add(ModBlocks.FERROCAPSICUMIUM_BLOCK);
    }
}
