package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModBlockTags;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagCopyingItemTagProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends BlockTagCopyingItemTagProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, Constants.CBW_MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // - Namespace: minecraft //
        // Tools
        tag(ItemTags.SHOVELS).add(ModItems.FERROCAPSICUMIUM_SHOVEL);
        tag(ItemTags.AXES).add(ModItems.FERROCAPSICUMIUM_AXE);
        tag(ItemTags.HOES).add(ModItems.FERROCAPSICUMIUM_HOE);

        // - Namespace: c //
        // Plants
        tag(Tags.Items.CROPS).addTag(ModItemTags.C_CROPS_CHILI);
        tag(ModItemTags.C_CROPS_CHILI).add(ModItems.CURVED_CHILI, ModItems.CURVED_GREEN_CHILI);
        tag(Tags.Items.SEEDS).addTag(ModItemTags.C_SEEDS_CHILI);
        tag(ModItemTags.C_SEEDS_CHILI).add(ModItems.CHILI_SEEDS);
        // Materials
        tag(Tags.Items.NUGGETS).addTag(ModItemTags.NUGGETS_FERROCAPSICUMIUM);
        tag(Tags.Items.INGOTS).addTag(ModItemTags.INGOTS_FERROCAPSICUMIUM);
        copy(ModBlockTags.C_STORAGE_BLOCKS_CHILI, ModItemTags.C_STORAGE_BLOCKS_CHILI);
        // Storage Blocks
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        // Tools
        tag(Tags.Items.TOOLS_SHEAR).add(ModItems.FERROCAPSICUMIUM_SHEARS);

        // - Namespace: chilibulletweapons //
        // Ingredients
        tag(ModItemTags.FOODS_RED_CHILI_PEPPER).add(ModItems.CURVED_CHILI, ModItems.DRIED_CURVED_CHILI);
        tag(ModItemTags.FOODS_GREEN_CHILI_PEPPER).add(ModItems.CURVED_GREEN_CHILI, ModItems.PICKLED_GREEN_CHILI);
        tag(ModItemTags.FOODS_CHILI_PEPPERS).addTag(ModItemTags.FOODS_RED_CHILI_PEPPER)
                .addTag(ModItemTags.FOODS_GREEN_CHILI_PEPPER);
        tag(ModItemTags.FOODS_CHILI_SEASONING).addTag(ModItemTags.FOODS_CHILI_PEPPERS)
                .add(ModItems.HOT_SAUCE, ModItems.GREEN_HOT_SAUCE);
        tag(ModItemTags.FOODS_COOKED_FISH).add(Items.COOKED_COD, Items.COOKED_SALMON);
        tag(ModItemTags.FOODS_COOKED_MEAT)
                .add(Items.COOKED_BEEF, Items.COOKED_MUTTON, Items.COOKED_PORKCHOP, Items.COOKED_RABBIT);
        // Materials
        tag(ModItemTags.NUGGETS_FERROCAPSICUMIUM).add(ModItems.FERROCAPSICUMIUM_NUGGET);
        tag(ModItemTags.INGOTS_FERROCAPSICUMIUM).add(ModItems.FERROCAPSICUMIUM_INGOT);
        copy(ModBlockTags.STORAGE_BLOCKS_FERROCAPSICUMIUM, ModItemTags.STORAGE_BLOCKS_FERROCAPSICUMIUM);
        tag(ModItemTags.FERROCAPSICUMIUM_TOOL_MATERIALS).add(ModItems.FERROCAPSICUMIUM_INGOT);
        // Misc.
        tag(ModItemTags.CHILI_BIOMASS).add(ModItems.CURVED_CHILI_STRING, ModItems.CURVED_CHILI_SACK);
    }
}
