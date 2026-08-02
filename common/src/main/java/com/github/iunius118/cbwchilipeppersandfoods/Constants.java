package com.github.iunius118.cbwchilipeppersandfoods;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    public static final String MOD_ID = "cbwchilipeppersandfoods";
    public static final String MOD_NAME = "CBW Chili Peppers and Foods";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final String CBW_MOD_ID = "chilibulletweapons";

    public static class Blocks {
        public static final ResourceKey<Block> CHILI_PEPPER = createKey("chili_pepper");
        public static final ResourceKey<Block> CURVED_CHILI_STRING = createKey("curved_chili_string");
        public static final ResourceKey<Block> HOT_SAUCE_BARREL = createKey("hot_sauce_barrel");
        public static final ResourceKey<Block> FERROCAPSICUMIUM_BLOCK = createKey("ferrocapsicumium_block");
        public static final ResourceKey<Block> POTTED_CHILI_PEPPER_FLOWERING =
                createKey("potted_chili_pepper_flowering");
        public static final ResourceKey<Block> POTTED_CHILI_PEPPER_GREEN = createKey("potted_chili_pepper_green");
        public static final ResourceKey<Block> POTTED_CHILI_PEPPER_RED = createKey("potted_chili_pepper_red");

        private static ResourceKey<Block> createKey(String path) {
            return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CBW_MOD_ID, path));
        }
    }

    public static class Items {
        // Plants
        public static final ResourceKey<Item> CHILI_SEEDS = createKey("chili_seeds");
        public static final ResourceKey<Item> CURVED_GREEN_CHILI = createKey("curved_green_chili");
        public static final ResourceKey<Item> CURVED_CHILI = createKey("curved_chili");
        public static final ResourceKey<Item> CURVED_CHILI_STRING = createKey("curved_chili_string");
        public static final ResourceKey<Item> DRIED_CURVED_CHILI = createKey("dried_curved_chili");
        public static final ResourceKey<Item> CURVED_CHILI_SACK = createKey("curved_chili_sack");
        public static final ResourceKey<Item> POTTED_CHILI_PEPPER_FLOWERING =
                createKey("potted_chili_pepper_flowering");
        public static final ResourceKey<Item> POTTED_CHILI_PEPPER_GREEN = createKey("potted_chili_pepper_green");
        public static final ResourceKey<Item> POTTED_CHILI_PEPPER_RED = createKey("potted_chili_pepper_red");

        // Fuel
        public static final ResourceKey<Item> CHILI_BIOFUEL = createKey("chili_biofuel");

        // Foods
        public static final ResourceKey<Item> HOT_SAUCE = createKey("hot_sauce");
        public static final ResourceKey<Item> HOT_SAUCE_BARREL = createKey("hot_sauce_barrel");
        public static final ResourceKey<Item> GREEN_HOT_SAUCE = createKey("green_hot_sauce");
        public static final ResourceKey<Item> PICKLED_GREEN_CHILI = createKey("pickled_green_chili");
        public static final ResourceKey<Item> CHILI_CHICKEN_SANDWICH = createKey("chili_chicken_sandwich");
        public static final ResourceKey<Item> CHILI_FISH_SANDWICH = createKey("chili_fish_sandwich");
        public static final ResourceKey<Item> CHILI_MEAT_SANDWICH = createKey("chili_meat_sandwich");
        public static final ResourceKey<Item> CHILI_POTATO_SANDWICH = createKey("chili_potato_sandwich");
        public static final ResourceKey<Item> HALF_CHILI_CHICKEN_SANDWICH = createKey("half_chili_chicken_sandwich");
        public static final ResourceKey<Item> HALF_CHILI_FISH_SANDWICH = createKey("half_chili_fish_sandwich");
        public static final ResourceKey<Item> HALF_CHILI_MEAT_SANDWICH = createKey("half_chili_meat_sandwich");
        public static final ResourceKey<Item> HALF_CHILI_POTATO_SANDWICH = createKey("half_chili_potato_sandwich");
        public static final ResourceKey<Item> PASTA_OIL_AND_CHILI = createKey("pasta_oil_and_chili");
        public static final ResourceKey<Item> FRIED_CHILI_PEPPER = createKey("fried_chili_pepper");
        public static final ResourceKey<Item> CHILI_CHOCOLATE = createKey("chili_chocolate");
        public static final ResourceKey<Item> CHILI_CHOCOLATE_CHICKEN = createKey("chili_chocolate_chicken");

        // Materials
        public static final ResourceKey<Item> CAPSICUM_CRYSTAL = createKey("capsicum_crystal");
        public static final ResourceKey<Item> CAPSICUM_CRYSTAL_BOTTLE = createKey("capsicum_crystal_bottle");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_NUGGET = createKey("ferrocapsicumium_nugget");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_INGOT = createKey("ferrocapsicumium_ingot");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_BLOCK = createKey("ferrocapsicumium_block");

        // Tools
        public static final ResourceKey<Item> FERROCAPSICUMIUM_SHOVEL = createKey("ferrocapsicumium_shovel");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_AXE = createKey("ferrocapsicumium_axe");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_HOE = createKey("ferrocapsicumium_hoe");
        public static final ResourceKey<Item> FERROCAPSICUMIUM_SHEARS = createKey("ferrocapsicumium_shears");

        // Misc.
        public static final ResourceKey<Item> CAPSAICIN_POWDER = createKey("capsaicin_powder");

        // Creative tab icon
        public static final ResourceKey<Item> ICON_MAIN = createKey("icon_main");

        private static ResourceKey<Item> createKey(String path) {
            return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CBW_MOD_ID, path));
        }
    }

    public static class SoundEvents {
        public static final ResourceKey<SoundEvent> CHILI_PEPPER_PICK_CHILI_PEPPERS =
                createKey("block_chili_pepper_pick_chili_peppers");

        private static ResourceKey<SoundEvent> createKey(String path) {
            return ResourceKey.create(Registries.SOUND_EVENT, Identifier.fromNamespaceAndPath(CBW_MOD_ID, path));
        }
    }

    public static class CriterionTriggers {
        public static final ResourceKey<CriterionTrigger<?>> HARVESTED_CHILI_PEPPER_WITH_SHEARS =
                createKey("harvested_chili_pepper_with_shears");
        public static final ResourceKey<CriterionTrigger<?>> THREW_HOT_SAUCE = createKey("threw_hot_sauce");

        private static ResourceKey<CriterionTrigger<?>> createKey(String path) {
            return ResourceKey.create(Registries.TRIGGER_TYPE, Identifier.fromNamespaceAndPath(CBW_MOD_ID, path));
        }
    }

    public static class CreativeModeTabs {
        public static final ResourceKey<CreativeModeTab> MAIN = createKey("main");

        // Translation keys
        public static final String TITLE_MOD_MAIN = "itemGroup.%s.main".formatted(Constants.MOD_ID);
        public static final String TITLE_CBW_MAIN = "itemGroup.%s.main".formatted(Constants.CBW_MOD_ID);

        private static ResourceKey<CreativeModeTab> createKey(String path) {
            return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(CBW_MOD_ID, path));
        }
    }
}
