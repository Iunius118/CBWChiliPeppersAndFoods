package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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
        tag(ModItemTags.C_CROPS).addTag(ModItemTags.C_CROPS_CHILI);
        tag(ModItemTags.C_CROPS_CHILI).add(ModItems.CURVED_CHILI);
        tag(ModItemTags.C_SEEDS).addTag(ModItemTags.C_SEEDS_CHILI);
        tag(ModItemTags.C_SEEDS_CHILI).add(ModItems.CHILI_SEEDS);

        tag(ModItemTags.FOODS_CHILI_PEPPER).add(ModItems.CURVED_CHILI, ModItems.DRIED_CURVED_CHILI);
        tag(ModItemTags.FOODS_CHILI_SEASONING).addTag(ModItemTags.FOODS_CHILI_PEPPER).add(ModItems.HOT_SAUCE);
        tag(ModItemTags.FOODS_COOKED_FISH).add(Items.COOKED_COD, Items.COOKED_SALMON);
        tag(ModItemTags.FOODS_COOKED_MEAT).add(Items.COOKED_BEEF, Items.COOKED_MUTTON, Items.COOKED_PORKCHOP, Items.COOKED_RABBIT);
    }
}
