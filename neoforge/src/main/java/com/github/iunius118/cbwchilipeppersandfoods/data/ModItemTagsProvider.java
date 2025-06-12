package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Constants.CBW_MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Namespace: minecraft
        tag(ItemTags.SHOVELS).add(ModItems.FERROCAPSICUMIUM_SHOVEL);
        tag(ItemTags.HOES).add(ModItems.FERROCAPSICUMIUM_HOE);

        // Namespace: c
        tag(Tags.Items.CROPS).addTag(ModItemTags.C_CROPS_CHILI);
        tag(ModItemTags.C_CROPS_CHILI).add(ModItems.CURVED_CHILI, ModItems.CURVED_GREEN_CHILI);
        tag(Tags.Items.SEEDS).addTag(ModItemTags.C_SEEDS_CHILI);
        tag(ModItemTags.C_SEEDS_CHILI).add(ModItems.CHILI_SEEDS);
        tag(Tags.Items.NUGGETS).add(ModItems.FERROCAPSICUMIUM_NUGGET);
        tag(Tags.Items.INGOTS).add(ModItems.FERROCAPSICUMIUM_INGOT);
        tag(Tags.Items.STORAGE_BLOCKS).add(ModItems.FERROCAPSICUMIUM_BLOCK, ModItems.CURVED_CHILI_STRING);

        // Namespace: chilibulletweapons
        tag(ModItemTags.FOODS_RED_CHILI_PEPPER).add(ModItems.CURVED_CHILI, ModItems.DRIED_CURVED_CHILI);
        tag(ModItemTags.FOODS_GREEN_CHILI_PEPPER).add(ModItems.CURVED_GREEN_CHILI, ModItems.PICKLED_GREEN_CHILI);
        tag(ModItemTags.FOODS_CHILI_PEPPERS).addTag(ModItemTags.FOODS_RED_CHILI_PEPPER).addTag(ModItemTags.FOODS_GREEN_CHILI_PEPPER);
        tag(ModItemTags.FOODS_CHILI_SEASONING).addTag(ModItemTags.FOODS_CHILI_PEPPERS).add(ModItems.HOT_SAUCE, ModItems.GREEN_HOT_SAUCE);
        tag(ModItemTags.FOODS_COOKED_FISH).add(Items.COOKED_COD, Items.COOKED_SALMON);
        tag(ModItemTags.FOODS_COOKED_MEAT).add(Items.COOKED_BEEF, Items.COOKED_MUTTON, Items.COOKED_PORKCHOP, Items.COOKED_RABBIT);
        tag(ModItemTags.CHILI_BIOMASS).add(ModItems.CURVED_CHILI_STRING, ModItems.CURVED_CHILI_SACK);
    }
}
