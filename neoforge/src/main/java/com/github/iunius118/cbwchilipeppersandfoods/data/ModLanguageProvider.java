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
        add(ModBlocks.FERROCAPSICUMIUM_BLOCK, "Block of Fe-Cap");

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
        add(ModItems.CAPSICUM_CRYSTAL, "Capsicum Crystal");
        add(ModItems.CAPSICUM_CRYSTAL_BOTTLE, "Bottle of Capsicum Crystal");
        add(ModItems.FERROCAPSICUMIUM_NUGGET, "Fe-Cap Nugget");
        add(ModItems.FERROCAPSICUMIUM_INGOT, "Fe-Cap Ingot");
        // Item.Tools
        add(ModItems.FERROCAPSICUMIUM_SHOVEL, "Fe-Cap Shovel");
        add(ModItems.FERROCAPSICUMIUM_AXE, "Fe-Cap Axe");
        add(ModItems.FERROCAPSICUMIUM_HOE, "Fe-Cap Hoe");
        add(ModItems.FERROCAPSICUMIUM_SHEARS, "Fe-Cap Shears");
        // Item.Misc
        add(ModItems.CAPSAICIN_POWDER, "Capsaicin Powder");

        // Advancements
        add("advancements.chilibulletweapons.main.root.title", "CBW Chili Peppers and Foods");
        add("advancements.chilibulletweapons.main.root.description", "Chili peppers and foods");
        add("advancements.chilibulletweapons.main.curved_chili.title", "Hot Topic");
        add("advancements.chilibulletweapons.main.curved_chili.description", "Obtain a Curved Chili Pepper");
        add("advancements.chilibulletweapons.main.harvested_chili_pepper_with_shears.title", "Be Gentle");
        add("advancements.chilibulletweapons.main.harvested_chili_pepper_with_shears.description", "Harvest Curved Chili Peppers using shears");
        add("advancements.chilibulletweapons.main.half_sandwich.title", "Let's Go Halves");
        add("advancements.chilibulletweapons.main.half_sandwich.description", "Obtain half-sized sandwiches");
        add("advancements.chilibulletweapons.main.threw_hot_sauce.title", "Non-Lethal?");
        add("advancements.chilibulletweapons.main.threw_hot_sauce.description", "Throw a bottle of hot chili sauce");
        add("advancements.chilibulletweapons.main.capsicum_crystal.title", "Corrosive, Toxic, Irritant");
        add("advancements.chilibulletweapons.main.capsicum_crystal.description", "Obtain a Capsicum Crystal");
        add("advancements.chilibulletweapons.main.ferrocapsicumium_ingot.title", "Fer-Ro-Cap-Sic ... What?");
        add("advancements.chilibulletweapons.main.ferrocapsicumium_ingot.description", "Obtain a ferro-capsicumium ... Fe-Cap Ingot");
    }
}
