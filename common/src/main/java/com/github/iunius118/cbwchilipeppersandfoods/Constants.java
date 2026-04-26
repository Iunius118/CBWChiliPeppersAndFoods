package com.github.iunius118.cbwchilipeppersandfoods;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    public static final String MOD_ID = "cbwchilipeppersandfoods";
    public static final String MOD_NAME = "CBW Chili Peppers and Foods";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final String CBW_MOD_ID = "chilibulletweapons";

    public static class Blocks {
        public static final Identifier CHILI_PEPPER = CommonClass.modCBWLocation("chili_pepper");
        public static final Identifier CURVED_CHILI_STRING = CommonClass.modCBWLocation("curved_chili_string");
        public static final Identifier HOT_SAUCE_BARREL = CommonClass.modCBWLocation("hot_sauce_barrel");
        public static final Identifier FERROCAPSICUMIUM_BLOCK = CommonClass.modCBWLocation("ferrocapsicumium_block");
    }

    public static class Items {
        // Plants
        public static final Identifier CHILI_SEEDS = CommonClass.modCBWLocation("chili_seeds");
        public static final Identifier CURVED_GREEN_CHILI = CommonClass.modCBWLocation("curved_green_chili");
        public static final Identifier CURVED_CHILI = CommonClass.modCBWLocation("curved_chili");
        public static final Identifier CURVED_CHILI_STRING = CommonClass.modCBWLocation("curved_chili_string");
        public static final Identifier DRIED_CURVED_CHILI = CommonClass.modCBWLocation("dried_curved_chili");
        public static final Identifier CURVED_CHILI_SACK = CommonClass.modCBWLocation("curved_chili_sack");

        // Fuel
        public static final Identifier CHILI_BIOFUEL = CommonClass.modCBWLocation("chili_biofuel");

        // Foods
        public static final Identifier HOT_SAUCE = CommonClass.modCBWLocation("hot_sauce");
        public static final Identifier HOT_SAUCE_BARREL = CommonClass.modCBWLocation("hot_sauce_barrel");
        public static final Identifier GREEN_HOT_SAUCE = CommonClass.modCBWLocation("green_hot_sauce");
        public static final Identifier PICKLED_GREEN_CHILI = CommonClass.modCBWLocation("pickled_green_chili");
        public static final Identifier CHILI_CHICKEN_SANDWICH = CommonClass.modCBWLocation("chili_chicken_sandwich");
        public static final Identifier CHILI_FISH_SANDWICH = CommonClass.modCBWLocation("chili_fish_sandwich");
        public static final Identifier CHILI_MEAT_SANDWICH = CommonClass.modCBWLocation("chili_meat_sandwich");
        public static final Identifier CHILI_POTATO_SANDWICH = CommonClass.modCBWLocation("chili_potato_sandwich");
        public static final Identifier HALF_CHILI_CHICKEN_SANDWICH =
                CommonClass.modCBWLocation("half_chili_chicken_sandwich");
        public static final Identifier HALF_CHILI_FISH_SANDWICH =
                CommonClass.modCBWLocation("half_chili_fish_sandwich");
        public static final Identifier HALF_CHILI_MEAT_SANDWICH =
                CommonClass.modCBWLocation("half_chili_meat_sandwich");
        public static final Identifier HALF_CHILI_POTATO_SANDWICH =
                CommonClass.modCBWLocation("half_chili_potato_sandwich");
        public static final Identifier PASTA_OIL_AND_CHILI = CommonClass.modCBWLocation("pasta_oil_and_chili");
        public static final Identifier FRIED_CHILI_PEPPER = CommonClass.modCBWLocation("fried_chili_pepper");
        public static final Identifier CHILI_CHOCOLATE = CommonClass.modCBWLocation("chili_chocolate");
        public static final Identifier CHILI_CHOCOLATE_CHICKEN = CommonClass.modCBWLocation("chili_chocolate_chicken");

        // Materials
        public static final Identifier CAPSICUM_CRYSTAL = CommonClass.modCBWLocation("capsicum_crystal");
        public static final Identifier CAPSICUM_CRYSTAL_BOTTLE = CommonClass.modCBWLocation("capsicum_crystal_bottle");
        public static final Identifier FERROCAPSICUMIUM_NUGGET = CommonClass.modCBWLocation("ferrocapsicumium_nugget");
        public static final Identifier FERROCAPSICUMIUM_INGOT = CommonClass.modCBWLocation("ferrocapsicumium_ingot");
        public static final Identifier FERROCAPSICUMIUM_BLOCK = CommonClass.modCBWLocation("ferrocapsicumium_block");

        // Tools
        public static final Identifier FERROCAPSICUMIUM_SHOVEL = CommonClass.modCBWLocation("ferrocapsicumium_shovel");
        public static final Identifier FERROCAPSICUMIUM_AXE = CommonClass.modCBWLocation("ferrocapsicumium_axe");
        public static final Identifier FERROCAPSICUMIUM_HOE = CommonClass.modCBWLocation("ferrocapsicumium_hoe");
        public static final Identifier FERROCAPSICUMIUM_SHEARS = CommonClass.modCBWLocation("ferrocapsicumium_shears");

        // Misc.
        public static final Identifier CAPSAICIN_POWDER = CommonClass.modCBWLocation("capsaicin_powder");

        // Creative tab icon
        public static final Identifier ICON_MAIN = CommonClass.modCBWLocation("icon_main");
    }

    public static class SoundEvents {
        public static final Identifier CHILI_PEPPER_PICK_CHILI_PEPPERS =
                CommonClass.modCBWLocation("block_chili_pepper_pick_chili_peppers");
    }

    public static class CriterionTriggers {
        public static final Identifier HARVESTED_CHILI_PEPPER_WITH_SHEARS =
                CommonClass.modCBWLocation("harvested_chili_pepper_with_shears");
        public static final Identifier THREW_HOT_SAUCE = CommonClass.modCBWLocation("threw_hot_sauce");
    }

    public static class CreativeModeTabs {
        public static final Identifier MAIN = CommonClass.modCBWLocation("main");

        // Translation keys
        public static final String TITLE_MOD_MAIN = "itemGroup.%s.main".formatted(Constants.MOD_ID);
        public static final String TITLE_CBW_MAIN = "itemGroup.%s.main".formatted(Constants.CBW_MOD_ID);
    }
}
