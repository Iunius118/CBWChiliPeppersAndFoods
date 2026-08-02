package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.ModCriteriaTriggers;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.platform.Services;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModRegistries {
    private static ModRegistryObject<Item> iconMain;

    public static void registerGameObjects() {
        // Blocks
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.BLOCK, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.Blocks.CHILI_PEPPER, () -> ModBlocks.CHILI_PEPPER);
                    r.register(Constants.Blocks.CURVED_CHILI_STRING, () -> ModBlocks.CURVED_CHILI_STRING);
                    r.register(Constants.Blocks.POTTED_CHILI_PEPPER_FLOWERING,
                            () -> ModBlocks.POTTED_CHILI_PEPPER_FLOWERING);
                    r.register(Constants.Blocks.POTTED_CHILI_PEPPER_GREEN, () -> ModBlocks.POTTED_CHILI_PEPPER_GREEN);
                    r.register(Constants.Blocks.POTTED_CHILI_PEPPER_RED, () -> ModBlocks.POTTED_CHILI_PEPPER_RED);
                    r.register(Constants.Blocks.HOT_SAUCE_BARREL, () -> ModBlocks.HOT_SAUCE_BARREL);
                    r.register(Constants.Blocks.FERROCAPSICUMIUM_BLOCK, () -> ModBlocks.FERROCAPSICUMIUM_BLOCK);
                });
        // Items
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.ITEM, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    // Plants
                    r.register(Constants.Items.CHILI_SEEDS, () -> ModItems.CHILI_SEEDS);
                    r.register(Constants.Items.CURVED_GREEN_CHILI, () -> ModItems.CURVED_GREEN_CHILI);
                    r.register(Constants.Items.CURVED_CHILI, () -> ModItems.CURVED_CHILI);
                    r.register(Constants.Items.CURVED_CHILI_STRING, () -> ModItems.CURVED_CHILI_STRING);
                    r.register(Constants.Items.DRIED_CURVED_CHILI, () -> ModItems.DRIED_CURVED_CHILI);
                    r.register(Constants.Items.CURVED_CHILI_SACK, () -> ModItems.CURVED_CHILI_SACK);
                    r.register(Constants.Items.POTTED_CHILI_PEPPER_FLOWERING,
                            () -> ModItems.POTTED_CHILI_PEPPER_FLOWERING);
                    r.register(Constants.Items.POTTED_CHILI_PEPPER_GREEN, () -> ModItems.POTTED_CHILI_PEPPER_GREEN);
                    r.register(Constants.Items.POTTED_CHILI_PEPPER_RED, () -> ModItems.POTTED_CHILI_PEPPER_RED);
                    // Fuel
                    r.register(Constants.Items.CHILI_BIOFUEL, () -> ModItems.CHILI_BIOFUEL);
                    // Foods
                    r.register(Constants.Items.HOT_SAUCE, () -> ModItems.HOT_SAUCE);
                    r.register(Constants.Items.HOT_SAUCE_BARREL, () -> ModItems.HOT_SAUCE_BARREL);
                    r.register(Constants.Items.GREEN_HOT_SAUCE, () -> ModItems.GREEN_HOT_SAUCE);
                    r.register(Constants.Items.PICKLED_GREEN_CHILI, () -> ModItems.PICKLED_GREEN_CHILI);
                    r.register(Constants.Items.CHILI_CHICKEN_SANDWICH, () -> ModItems.CHILI_CHICKEN_SANDWICH);
                    r.register(Constants.Items.CHILI_FISH_SANDWICH, () -> ModItems.CHILI_FISH_SANDWICH);
                    r.register(Constants.Items.CHILI_MEAT_SANDWICH, () -> ModItems.CHILI_MEAT_SANDWICH);
                    r.register(Constants.Items.CHILI_POTATO_SANDWICH, () -> ModItems.CHILI_POTATO_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH, () -> ModItems.HALF_CHILI_CHICKEN_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_FISH_SANDWICH, () -> ModItems.HALF_CHILI_FISH_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_MEAT_SANDWICH, () -> ModItems.HALF_CHILI_MEAT_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_POTATO_SANDWICH, () -> ModItems.HALF_CHILI_POTATO_SANDWICH);
                    r.register(Constants.Items.PASTA_OIL_AND_CHILI, () -> ModItems.PASTA_OIL_AND_CHILI);
                    r.register(Constants.Items.FRIED_CHILI_PEPPER, () -> ModItems.FRIED_CHILI_PEPPER);
                    r.register(Constants.Items.CHILI_CHOCOLATE, () -> ModItems.CHILI_CHOCOLATE);
                    r.register(Constants.Items.CHILI_CHOCOLATE_CHICKEN, () -> ModItems.CHILI_CHOCOLATE_CHICKEN);
                    // Materials
                    r.register(Constants.Items.CAPSICUM_CRYSTAL, () -> ModItems.CAPSICUM_CRYSTAL);
                    r.register(Constants.Items.CAPSICUM_CRYSTAL_BOTTLE, () -> ModItems.CAPSICUM_CRYSTAL_BOTTLE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_NUGGET, () -> ModItems.FERROCAPSICUMIUM_NUGGET);
                    r.register(Constants.Items.FERROCAPSICUMIUM_INGOT, () -> ModItems.FERROCAPSICUMIUM_INGOT);
                    r.register(Constants.Items.FERROCAPSICUMIUM_BLOCK, () -> ModItems.FERROCAPSICUMIUM_BLOCK);
                    // Tools
                    r.register(Constants.Items.FERROCAPSICUMIUM_SHOVEL, () -> ModItems.FERROCAPSICUMIUM_SHOVEL);
                    r.register(Constants.Items.FERROCAPSICUMIUM_AXE, () -> ModItems.FERROCAPSICUMIUM_AXE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_HOE, () -> ModItems.FERROCAPSICUMIUM_HOE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_SHEARS, () -> ModItems.FERROCAPSICUMIUM_SHEARS);
                    // Misc.
                    r.register(Constants.Items.CAPSAICIN_POWDER, () -> ModItems.CAPSAICIN_POWDER);
                    // Creative tab icon
                    iconMain = r.register(Constants.Items.ICON_MAIN, () -> ModItems.ICON_MAIN);
                });
        // Sound events
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.SOUND_EVENT, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.SoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS,
                            () -> ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);
                });
        // Trigger types
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.TRIGGER_TYPES, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.CriterionTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS,
                            () -> ModCriteriaTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS);
                    r.register(Constants.CriterionTriggers.THREW_HOT_SAUCE, () -> ModCriteriaTriggers.THREW_HOT_SAUCE);
                });
        // Creative mode tabs
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.CreativeModeTabs.MAIN,
                            ModRegistries::createMainCreativeModeTab);
                });
    }

    private static CreativeModeTab createMainCreativeModeTab() {
        // Use different title depending on whether CBW is loaded or not
        // ** Only on Fabric, change the title on CBW side due to mod loading and initialization timing **
        String titleKey = Services.PLATFORM.isModLoaded(Constants.CBW_MOD_ID) ?
                Constants.CreativeModeTabs.TITLE_CBW_MAIN : Constants.CreativeModeTabs.TITLE_MOD_MAIN;
        return Services.PLATFORM.createCreativeModeTabBuilder()
                .title(Component.translatable(titleKey))
                // Check whether the mod items exist
                .icon(() -> iconMain.isBound() ? new ItemStack(iconMain.value()) : ItemStack.EMPTY)
                .displayItems((params, output) -> {
                    // Check whether the mod items exist
                    if (!iconMain.isBound()) return;

                    for (Item i : ModItems.ITEMS) {
                        output.accept(i);
                    }
                })
                .build();
    }

    private ModRegistries() {}
}
