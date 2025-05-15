package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.CBW_MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Plants
        basicItem(ModItems.CHILI_SEEDS);
        basicItem(ModItems.CURVED_GREEN_CHILI);
        basicItem(ModItems.CURVED_CHILI);
        basicItem(ModItems.CURVED_CHILI_STRING);
        basicItem(ModItems.DRIED_CURVED_CHILI);
        basicItem(ModItems.CURVED_CHILI_SACK);

        // Foods
        basicItem(ModItems.HOT_SAUCE);
        // Item model of hot sauce barrel is generated during block state model generation
        basicItem(ModItems.GREEN_HOT_SAUCE);
        basicItem(ModItems.PICKLED_GREEN_CHILI);
        basicItem(ModItems.CHILI_CHICKEN_SANDWICH);
        basicItem(ModItems.CHILI_FISH_SANDWICH);
        basicItem(ModItems.CHILI_MEAT_SANDWICH);
        basicItem(ModItems.CHILI_POTATO_SANDWICH);
        basicItem(ModItems.HALF_CHILI_CHICKEN_SANDWICH);
        basicItem(ModItems.HALF_CHILI_FISH_SANDWICH);
        basicItem(ModItems.HALF_CHILI_MEAT_SANDWICH);
        basicItem(ModItems.HALF_CHILI_POTATO_SANDWICH);
        basicItem(ModItems.PASTA_OIL_AND_CHILI);
        basicItem(ModItems.FRIED_CHILI_PEPPER);
        basicItem(ModItems.CHILI_CHOCOLATE);
        basicItem(ModItems.CHILI_CHOCOLATE_CHICKEN);

        // Misc.
        basicItem(ModItems.CAPSAICIN_POWDER);

        // Creative mode tab
        basicItem(ModItems.ICON_MAIN);
    }
}
