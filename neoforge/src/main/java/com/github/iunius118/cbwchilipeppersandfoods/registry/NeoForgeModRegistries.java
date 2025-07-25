package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.ModCriteriaTriggers;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.platform.Services;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeModRegistries {

    public static void registerGameObjects(IEventBus modEventBus) {
        registerBlocks(modEventBus);
        registerItems(modEventBus);
        registerSoundEvents(modEventBus);
        registerCriterionTriggers(modEventBus);
        registerCreativeModeTabs(modEventBus);
    }

    private static void registerBlocks(IEventBus modEventBus) {
        var blockRegister = DeferredRegister.createBlocks(Constants.CBW_MOD_ID);

        blockRegister.register(Constants.Blocks.CHILI_PEPPER.getPath(), () -> ModBlocks.CHILI_PEPPER);
        blockRegister.register(Constants.Blocks.CURVED_CHILI_STRING.getPath(), () -> ModBlocks.CURVED_CHILI_STRING);
        blockRegister.register(Constants.Blocks.HOT_SAUCE_BARREL.getPath(), () -> ModBlocks.HOT_SAUCE_BARREL);
        blockRegister.register(Constants.Blocks.FERROCAPSICUMIUM_BLOCK.getPath(), () -> ModBlocks.FERROCAPSICUMIUM_BLOCK);

        blockRegister.register(modEventBus);
    }

    private static void registerItems(IEventBus modEventBus) {
        var itemRegister = DeferredRegister.createItems(Constants.CBW_MOD_ID);

        // Plants
        itemRegister.register(Constants.Items.CHILI_SEEDS.getPath(), () -> ModItems.CHILI_SEEDS);
        itemRegister.register(Constants.Items.CURVED_GREEN_CHILI.getPath(), () -> ModItems.CURVED_GREEN_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI.getPath(), () -> ModItems.CURVED_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI_STRING.getPath(), () -> ModItems.CURVED_CHILI_STRING);
        itemRegister.register(Constants.Items.DRIED_CURVED_CHILI.getPath(), () -> ModItems.DRIED_CURVED_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI_SACK.getPath(), () -> ModItems.CURVED_CHILI_SACK);
        // Fuel
        itemRegister.register(Constants.Items.CHILI_BIOFUEL.getPath(), () -> ModItems.CHILI_BIOFUEL);
        // Foods
        itemRegister.register(Constants.Items.HOT_SAUCE.getPath(), () -> ModItems.HOT_SAUCE);
        itemRegister.register(Constants.Items.HOT_SAUCE_BARREL.getPath(), () -> ModItems.HOT_SAUCE_BARREL);
        itemRegister.register(Constants.Items.GREEN_HOT_SAUCE.getPath(), () -> ModItems.GREEN_HOT_SAUCE);
        itemRegister.register(Constants.Items.PICKLED_GREEN_CHILI.getPath(), () -> ModItems.PICKLED_GREEN_CHILI);
        itemRegister.register(Constants.Items.CHILI_CHICKEN_SANDWICH.getPath(), () -> ModItems.CHILI_CHICKEN_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_FISH_SANDWICH.getPath(), () -> ModItems.CHILI_FISH_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_MEAT_SANDWICH.getPath(), () -> ModItems.CHILI_MEAT_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_POTATO_SANDWICH.getPath(), () -> ModItems.CHILI_POTATO_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH.getPath(), () -> ModItems.HALF_CHILI_CHICKEN_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_FISH_SANDWICH.getPath(), () -> ModItems.HALF_CHILI_FISH_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_MEAT_SANDWICH.getPath(), () -> ModItems.HALF_CHILI_MEAT_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_POTATO_SANDWICH.getPath(), () -> ModItems.HALF_CHILI_POTATO_SANDWICH);
        itemRegister.register(Constants.Items.PASTA_OIL_AND_CHILI.getPath(), () -> ModItems.PASTA_OIL_AND_CHILI);
        itemRegister.register(Constants.Items.FRIED_CHILI_PEPPER.getPath(), () -> ModItems.FRIED_CHILI_PEPPER);
        itemRegister.register(Constants.Items.CHILI_CHOCOLATE.getPath(), () -> ModItems.CHILI_CHOCOLATE);
        itemRegister.register(Constants.Items.CHILI_CHOCOLATE_CHICKEN.getPath(), () -> ModItems.CHILI_CHOCOLATE_CHICKEN);
        // Materials
        itemRegister.register(Constants.Items.CAPSICUM_CRYSTAL.getPath(), () -> ModItems.CAPSICUM_CRYSTAL);
        itemRegister.register(Constants.Items.CAPSICUM_CRYSTAL_BOTTLE.getPath(), () -> ModItems.CAPSICUM_CRYSTAL_BOTTLE);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_NUGGET.getPath(), () -> ModItems.FERROCAPSICUMIUM_NUGGET);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_INGOT.getPath(), () -> ModItems.FERROCAPSICUMIUM_INGOT);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_BLOCK.getPath(), () -> ModItems.FERROCAPSICUMIUM_BLOCK);
        // Tools
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_SHOVEL.getPath(), () -> ModItems.FERROCAPSICUMIUM_SHOVEL);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_AXE.getPath(), () -> ModItems.FERROCAPSICUMIUM_AXE);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_HOE.getPath(), () -> ModItems.FERROCAPSICUMIUM_HOE);
        itemRegister.register(Constants.Items.FERROCAPSICUMIUM_SHEARS.getPath(), () -> ModItems.FERROCAPSICUMIUM_SHEARS);
        // Misc.
        itemRegister.register(Constants.Items.CAPSAICIN_POWDER.getPath(), () -> ModItems.CAPSAICIN_POWDER);
        // Creative tab icon
        itemRegister.register(Constants.Items.ICON_MAIN.getPath(), () -> ModItems.ICON_MAIN);

        itemRegister.register(modEventBus);
    }

    private static void registerSoundEvents(IEventBus modEventBus) {
        var soundEventRegister = DeferredRegister.create(Registries.SOUND_EVENT, Constants.CBW_MOD_ID);

        soundEventRegister.register(Constants.SoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS.getPath(), () -> ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);

        soundEventRegister.register(modEventBus);
    }

    private static void registerCriterionTriggers(IEventBus modEventBus) {
        var criterionTriggerRegistry = DeferredRegister.create(Registries.TRIGGER_TYPE, Constants.CBW_MOD_ID);

        criterionTriggerRegistry.register(Constants.CriterionTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS.getPath(), () -> ModCriteriaTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS);
        criterionTriggerRegistry.register(Constants.CriterionTriggers.THREW_HOT_SAUCE.getPath(), () -> ModCriteriaTriggers.THREW_HOT_SAUCE);

        criterionTriggerRegistry.register(modEventBus);
    }

    private static void registerCreativeModeTabs(IEventBus modEventBus) {
        var creativeModeTabRegister = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID);

        creativeModeTabRegister.register(Constants.CreativeModeTabs.MAIN.getPath(), NeoForgeModRegistries::getMainCreativeModeTab);

        creativeModeTabRegister.register(modEventBus);
    }

    private static CreativeModeTab getMainCreativeModeTab() {
        // Use different title depending on whether CBW is loaded or not
        String titleKey = Services.PLATFORM.isModLoaded(Constants.CBW_MOD_ID) ? Constants.CreativeModeTabs.TITLE_CBW_MAIN
                : Constants.CreativeModeTabs.TITLE_MOD_MAIN;
        return CreativeModeTab.builder()
                .title(Component.translatable(titleKey))
                .icon(() -> new ItemStack(ModItems.ICON_MAIN))
                .displayItems((params, output) -> {
                    for (Item i : ModItems.ITEMS) {
                        if (i != null) output.accept(i);
                    }
                })
                .build();
    }
}
