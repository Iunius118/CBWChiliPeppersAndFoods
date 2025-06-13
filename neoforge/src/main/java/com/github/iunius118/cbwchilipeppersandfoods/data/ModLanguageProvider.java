package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output) {
        super(output, Constants.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative mode tabs
        add(Constants.CreativeModeTabs.TITLE_MOD_MAIN, Constants.MOD_NAME);

        // Blocks
        add(ModBlocks.CHILI_PEPPER, "Chili Pepper Crops (CBW)");
        add(ModBlocks.CURVED_CHILI_STRING, "String of Curved Chili Peppers");
        add(ModBlocks.HOT_SAUCE_BARREL, "Barrel of Hot Chili Sauce");
        add(ModBlocks.FERROCAPSICUMIUM_BLOCK, "Block of Ferro-Capsicumium");

        // Item.Plants
        add(ModItems.CHILI_SEEDS, "Chili Pepper Seeds (CBW)");
        add(ModItems.CURVED_GREEN_CHILI, "Curved Green Chili Pepper");
        add(ModItems.CURVED_CHILI, "Curved Chili Pepper");
        add(ModItems.DRIED_CURVED_CHILI, "Dried Curved Chili Pepper");
        add(ModItems.CURVED_CHILI_SACK, "Sack of Curved Chili Peppers");
        // Item.Fuel
        add(ModItems.CHILI_BIOFUEL, "Chili Plant Biofuel");
        // Item.Foods
        add(ModItems.HOT_SAUCE, "Hot Chili Sauce");
        add(ModItems.GREEN_HOT_SAUCE, "Green Hot Chili Sauce");
        add(ModItems.PICKLED_GREEN_CHILI, "Pickled Green Chili Pepper");
        add(ModItems.CHILI_CHICKEN_SANDWICH, "Chili Chicken Sandwich");
        add(ModItems.CHILI_FISH_SANDWICH, "Chili Fish Sandwich");
        add(ModItems.CHILI_MEAT_SANDWICH, "Chili Meat Sandwich");
        add(ModItems.CHILI_POTATO_SANDWICH, "Chili Potato Sandwich");
        add(ModItems.HALF_CHILI_CHICKEN_SANDWICH, "Half-sized Chili Chicken Sandwich");
        add(ModItems.HALF_CHILI_FISH_SANDWICH, "Half-sized Chili Fish Sandwich");
        add(ModItems.HALF_CHILI_MEAT_SANDWICH, "Half-sized Chili Meat Sandwich");
        add(ModItems.HALF_CHILI_POTATO_SANDWICH, "Half-sized Chili Potato Sandwich");
        add(ModItems.PASTA_OIL_AND_CHILI, "Pasta Olio e Peperoncino");
        add(ModItems.FRIED_CHILI_PEPPER, "Fried Chili Pepper");
        add(ModItems.CHILI_CHOCOLATE, "Chili Chocolate");
        add(ModItems.CHILI_CHOCOLATE_CHICKEN, "Chicken with Chili Chocolate Sauce");
        // Item.Materials
        add(ModItems.CAPSAICIN_POWDER, "Capsaicin Powder");
        add(ModItems.FERROCAPSICUMIUM_NUGGET, "Ferro-Capsicumium Nugget");
        add(ModItems.FERROCAPSICUMIUM_INGOT, "Ferro-Capsicumium Ingot");
        // Item.Tools
        add(ModItems.FERROCAPSICUMIUM_SHOVEL, "Ferro-Capsicumium Shovel");
        add(ModItems.FERROCAPSICUMIUM_AXE, "Ferro-Capsicumium Axe");
        add(ModItems.FERROCAPSICUMIUM_HOE, "Ferro-Capsicumium Hoe");
    }
}
