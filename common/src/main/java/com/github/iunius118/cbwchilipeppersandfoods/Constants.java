package com.github.iunius118.cbwchilipeppersandfoods;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    public static final String MOD_ID = "cbwchilipeppersandfoods";
    public static final String MOD_NAME = "CBW Chili Peppers and Foods";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final String CBW_MOD_ID = "chilibulletweapons";

    public static class Blocks {
        public static final ResourceLocation CHILI_PEPPER = CommonClass.modCBWLocation("chili_pepper");
        public static final ResourceLocation CURVED_CHILI_STRING = CommonClass.modCBWLocation("curved_chili_string");
        public static final ResourceLocation HOT_SAUCE_BARREL = CommonClass.modCBWLocation("hot_sauce_barrel");
        public static final ResourceLocation FERROCAPSICUMIUM_BLOCK = CommonClass.modCBWLocation("ferrocapsicumium_block");
    }

    public static class Items {
        // Plants
        public static final ResourceLocation CHILI_SEEDS = CommonClass.modCBWLocation("chili_seeds");
        public static final ResourceLocation CURVED_GREEN_CHILI = CommonClass.modCBWLocation("curved_green_chili");
        public static final ResourceLocation CURVED_CHILI = CommonClass.modCBWLocation("curved_chili");
        public static final ResourceLocation CURVED_CHILI_STRING = CommonClass.modCBWLocation("curved_chili_string");
        public static final ResourceLocation DRIED_CURVED_CHILI = CommonClass.modCBWLocation("dried_curved_chili");
        public static final ResourceLocation CURVED_CHILI_SACK = CommonClass.modCBWLocation("curved_chili_sack");

        // Fuel
        public static final ResourceLocation CHILI_BIOFUEL = CommonClass.modCBWLocation("chili_biofuel");

        // Foods
        public static final ResourceLocation HOT_SAUCE = CommonClass.modCBWLocation("hot_sauce");
        public static final ResourceLocation HOT_SAUCE_BARREL = CommonClass.modCBWLocation("hot_sauce_barrel");
        public static final ResourceLocation GREEN_HOT_SAUCE = CommonClass.modCBWLocation("green_hot_sauce");
        public static final ResourceLocation PICKLED_GREEN_CHILI = CommonClass.modCBWLocation("pickled_green_chili");
        public static final ResourceLocation CHILI_CHICKEN_SANDWICH = CommonClass.modCBWLocation("chili_chicken_sandwich");
        public static final ResourceLocation CHILI_FISH_SANDWICH = CommonClass.modCBWLocation("chili_fish_sandwich");
        public static final ResourceLocation CHILI_MEAT_SANDWICH = CommonClass.modCBWLocation("chili_meat_sandwich");
        public static final ResourceLocation CHILI_POTATO_SANDWICH = CommonClass.modCBWLocation("chili_potato_sandwich");
        public static final ResourceLocation HALF_CHILI_CHICKEN_SANDWICH = CommonClass.modCBWLocation("half_chili_chicken_sandwich");
        public static final ResourceLocation HALF_CHILI_FISH_SANDWICH = CommonClass.modCBWLocation("half_chili_fish_sandwich");
        public static final ResourceLocation HALF_CHILI_MEAT_SANDWICH = CommonClass.modCBWLocation("half_chili_meat_sandwich");
        public static final ResourceLocation HALF_CHILI_POTATO_SANDWICH = CommonClass.modCBWLocation("half_chili_potato_sandwich");
        public static final ResourceLocation PASTA_OIL_AND_CHILI = CommonClass.modCBWLocation("pasta_oil_and_chili");
        public static final ResourceLocation FRIED_CHILI_PEPPER = CommonClass.modCBWLocation("fried_chili_pepper");
        public static final ResourceLocation CHILI_CHOCOLATE = CommonClass.modCBWLocation("chili_chocolate");
        public static final ResourceLocation CHILI_CHOCOLATE_CHICKEN = CommonClass.modCBWLocation("chili_chocolate_chicken");

        // Materials
        public static final ResourceLocation CAPSAICIN_POWDER = CommonClass.modCBWLocation("capsaicin_powder");
        public static final ResourceLocation FERROCAPSICUMIUM_NUGGET = CommonClass.modCBWLocation("ferrocapsicumium_nugget");
        public static final ResourceLocation FERROCAPSICUMIUM_INGOT = CommonClass.modCBWLocation("ferrocapsicumium_ingot");
        public static final ResourceLocation FERROCAPSICUMIUM_BLOCK = CommonClass.modCBWLocation("ferrocapsicumium_block");

        // Creative tab icon
        public static final ResourceLocation ICON_MAIN = CommonClass.modCBWLocation("icon_main");
    }

    public static class SoundEvents {
        public static final ResourceLocation CHILI_PEPPER_PICK_CHILI_PEPPERS = CommonClass.modCBWLocation("block_chili_pepper_pick_chili_peppers");
    }

    public static class CreativeModeTabs {
        public static final ResourceLocation MAIN = CommonClass.modCBWLocation("main");

        // Translation keys
        public static final String TITLE_MOD_MAIN = "itemGroup.%s.main".formatted(Constants.MOD_ID);
        public static final String TITLE_CBW_MAIN = "itemGroup.%s.main".formatted(Constants.CBW_MOD_ID);
    }
}
