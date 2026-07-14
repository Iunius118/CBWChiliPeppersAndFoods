package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.ModCriteriaTriggers;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.platform.Services;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModRegistries {
    private static Holder<Item> iconMain;

    public static void registerGameObjects() {
        // Blocks
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.BLOCK, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.Blocks.CHILI_PEPPER.getPath(), () -> ModBlocks.CHILI_PEPPER);
                    r.register(Constants.Blocks.CURVED_CHILI_STRING.getPath(), () -> ModBlocks.CURVED_CHILI_STRING);
                    r.register(Constants.Blocks.HOT_SAUCE_BARREL.getPath(), () -> ModBlocks.HOT_SAUCE_BARREL);
                    r.register(Constants.Blocks.FERROCAPSICUMIUM_BLOCK.getPath(),
                            () -> ModBlocks.FERROCAPSICUMIUM_BLOCK);
                });
        // Items
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.ITEM, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    // Plants
                    r.register(Constants.Items.CHILI_SEEDS.getPath(), () -> ModItems.CHILI_SEEDS);
                    r.register(Constants.Items.CURVED_GREEN_CHILI.getPath(), () -> ModItems.CURVED_GREEN_CHILI);
                    r.register(Constants.Items.CURVED_CHILI.getPath(), () -> ModItems.CURVED_CHILI);
                    r.register(Constants.Items.CURVED_CHILI_STRING.getPath(), () -> ModItems.CURVED_CHILI_STRING);
                    r.register(Constants.Items.DRIED_CURVED_CHILI.getPath(), () -> ModItems.DRIED_CURVED_CHILI);
                    r.register(Constants.Items.CURVED_CHILI_SACK.getPath(), () -> ModItems.CURVED_CHILI_SACK);
                    // Fuel
                    r.register(Constants.Items.CHILI_BIOFUEL.getPath(), () -> ModItems.CHILI_BIOFUEL);
                    // Foods
                    r.register(Constants.Items.HOT_SAUCE.getPath(), () -> ModItems.HOT_SAUCE);
                    r.register(Constants.Items.HOT_SAUCE_BARREL.getPath(), () -> ModItems.HOT_SAUCE_BARREL);
                    r.register(Constants.Items.GREEN_HOT_SAUCE.getPath(), () -> ModItems.GREEN_HOT_SAUCE);
                    r.register(Constants.Items.PICKLED_GREEN_CHILI.getPath(), () -> ModItems.PICKLED_GREEN_CHILI);
                    r.register(Constants.Items.CHILI_CHICKEN_SANDWICH.getPath(), () -> ModItems.CHILI_CHICKEN_SANDWICH);
                    r.register(Constants.Items.CHILI_FISH_SANDWICH.getPath(), () -> ModItems.CHILI_FISH_SANDWICH);
                    r.register(Constants.Items.CHILI_MEAT_SANDWICH.getPath(), () -> ModItems.CHILI_MEAT_SANDWICH);
                    r.register(Constants.Items.CHILI_POTATO_SANDWICH.getPath(), () -> ModItems.CHILI_POTATO_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH.getPath(),
                            () -> ModItems.HALF_CHILI_CHICKEN_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_FISH_SANDWICH.getPath(),
                            () -> ModItems.HALF_CHILI_FISH_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_MEAT_SANDWICH.getPath(),
                            () -> ModItems.HALF_CHILI_MEAT_SANDWICH);
                    r.register(Constants.Items.HALF_CHILI_POTATO_SANDWICH.getPath(),
                            () -> ModItems.HALF_CHILI_POTATO_SANDWICH);
                    r.register(Constants.Items.PASTA_OIL_AND_CHILI.getPath(), () -> ModItems.PASTA_OIL_AND_CHILI);
                    r.register(Constants.Items.FRIED_CHILI_PEPPER.getPath(), () -> ModItems.FRIED_CHILI_PEPPER);
                    r.register(Constants.Items.CHILI_CHOCOLATE.getPath(), () -> ModItems.CHILI_CHOCOLATE);
                    r.register(Constants.Items.CHILI_CHOCOLATE_CHICKEN.getPath(),
                            () -> ModItems.CHILI_CHOCOLATE_CHICKEN);
                    // Materials
                    r.register(Constants.Items.CAPSICUM_CRYSTAL.getPath(), () -> ModItems.CAPSICUM_CRYSTAL);
                    r.register(Constants.Items.CAPSICUM_CRYSTAL_BOTTLE.getPath(),
                            () -> ModItems.CAPSICUM_CRYSTAL_BOTTLE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_NUGGET.getPath(),
                            () -> ModItems.FERROCAPSICUMIUM_NUGGET);
                    r.register(Constants.Items.FERROCAPSICUMIUM_INGOT.getPath(), () -> ModItems.FERROCAPSICUMIUM_INGOT);
                    r.register(Constants.Items.FERROCAPSICUMIUM_BLOCK.getPath(), () -> ModItems.FERROCAPSICUMIUM_BLOCK);
                    // Tools
                    r.register(Constants.Items.FERROCAPSICUMIUM_SHOVEL.getPath(),
                            () -> ModItems.FERROCAPSICUMIUM_SHOVEL);
                    r.register(Constants.Items.FERROCAPSICUMIUM_AXE.getPath(), () -> ModItems.FERROCAPSICUMIUM_AXE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_HOE.getPath(), () -> ModItems.FERROCAPSICUMIUM_HOE);
                    r.register(Constants.Items.FERROCAPSICUMIUM_SHEARS.getPath(),
                            () -> ModItems.FERROCAPSICUMIUM_SHEARS);
                    // Misc.
                    r.register(Constants.Items.CAPSAICIN_POWDER.getPath(), () -> ModItems.CAPSAICIN_POWDER);
                    // Creative tab icon
                    iconMain = r.register(Constants.Items.ICON_MAIN.getPath(), () -> ModItems.ICON_MAIN);
                });
        // Sound events
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.SOUND_EVENT, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.SoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS.getPath(),
                            () -> ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);
                });
        // Trigger types
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.TRIGGER_TYPES, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.CriterionTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS.getPath(),
                            () -> ModCriteriaTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS);
                    r.register(Constants.CriterionTriggers.THREW_HOT_SAUCE.getPath(),
                            () -> ModCriteriaTriggers.THREW_HOT_SAUCE);
                });
        // Creative mode tabs
        Services.PLATFORM.createModObjectRegistry(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID)
                .registerObjects(r -> {
                    r.register(Constants.CreativeModeTabs.MAIN.getPath(),
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
