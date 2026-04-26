package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.ModCriteriaTriggers;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class FabricModRegistries {

    public static void registerGameObjects() {
        registerBlocks();
        registerItems();
        registerSoundEvents();
        registerCriterionTriggers();
        registerCreativeModeTabs();
    }

    private static void registerBlocks() {
        var blocks = ModObjectRegistry.create(BuiltInRegistries.BLOCK, Constants.CBW_MOD_ID);

        blocks.register(Constants.Blocks.CHILI_PEPPER.getPath(), ModBlocks.CHILI_PEPPER);
        blocks.register(Constants.Blocks.CURVED_CHILI_STRING.getPath(), ModBlocks.CURVED_CHILI_STRING);
        blocks.register(Constants.Blocks.HOT_SAUCE_BARREL.getPath(), ModBlocks.HOT_SAUCE_BARREL);
        blocks.register(Constants.Blocks.FERROCAPSICUMIUM_BLOCK.getPath(), ModBlocks.FERROCAPSICUMIUM_BLOCK);
    }

    private static void registerItems() {
        var items = ModObjectRegistry.create(BuiltInRegistries.ITEM, Constants.CBW_MOD_ID);

        // Plants
        items.register(Constants.Items.CHILI_SEEDS.getPath(), ModItems.CHILI_SEEDS);
        items.register(Constants.Items.CURVED_GREEN_CHILI.getPath(), ModItems.CURVED_GREEN_CHILI);
        items.register(Constants.Items.CURVED_CHILI.getPath(), ModItems.CURVED_CHILI);
        items.register(Constants.Items.CURVED_CHILI_STRING.getPath(), ModItems.CURVED_CHILI_STRING);
        items.register(Constants.Items.DRIED_CURVED_CHILI.getPath(), ModItems.DRIED_CURVED_CHILI);
        items.register(Constants.Items.CURVED_CHILI_SACK.getPath(), ModItems.CURVED_CHILI_SACK);
        // Fuel
        items.register(Constants.Items.CHILI_BIOFUEL.getPath(), ModItems.CHILI_BIOFUEL);
        // Foods
        items.register(Constants.Items.HOT_SAUCE.getPath(), ModItems.HOT_SAUCE);
        items.register(Constants.Items.HOT_SAUCE_BARREL.getPath(), ModItems.HOT_SAUCE_BARREL);
        items.register(Constants.Items.GREEN_HOT_SAUCE.getPath(), ModItems.GREEN_HOT_SAUCE);
        items.register(Constants.Items.PICKLED_GREEN_CHILI.getPath(), ModItems.PICKLED_GREEN_CHILI);
        items.register(Constants.Items.CHILI_CHICKEN_SANDWICH.getPath(), ModItems.CHILI_CHICKEN_SANDWICH);
        items.register(Constants.Items.CHILI_FISH_SANDWICH.getPath(), ModItems.CHILI_FISH_SANDWICH);
        items.register(Constants.Items.CHILI_MEAT_SANDWICH.getPath(), ModItems.CHILI_MEAT_SANDWICH);
        items.register(Constants.Items.CHILI_POTATO_SANDWICH.getPath(), ModItems.CHILI_POTATO_SANDWICH);
        items.register(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH.getPath(), ModItems.HALF_CHILI_CHICKEN_SANDWICH);
        items.register(Constants.Items.HALF_CHILI_FISH_SANDWICH.getPath(), ModItems.HALF_CHILI_FISH_SANDWICH);
        items.register(Constants.Items.HALF_CHILI_MEAT_SANDWICH.getPath(), ModItems.HALF_CHILI_MEAT_SANDWICH);
        items.register(Constants.Items.HALF_CHILI_POTATO_SANDWICH.getPath(), ModItems.HALF_CHILI_POTATO_SANDWICH);
        items.register(Constants.Items.PASTA_OIL_AND_CHILI.getPath(), ModItems.PASTA_OIL_AND_CHILI);
        items.register(Constants.Items.FRIED_CHILI_PEPPER.getPath(), ModItems.FRIED_CHILI_PEPPER);
        items.register(Constants.Items.CHILI_CHOCOLATE.getPath(), ModItems.CHILI_CHOCOLATE);
        items.register(Constants.Items.CHILI_CHOCOLATE_CHICKEN.getPath(), ModItems.CHILI_CHOCOLATE_CHICKEN);
        // Materials
        items.register(Constants.Items.CAPSICUM_CRYSTAL.getPath(), ModItems.CAPSICUM_CRYSTAL);
        items.register(Constants.Items.CAPSICUM_CRYSTAL_BOTTLE.getPath(), ModItems.CAPSICUM_CRYSTAL_BOTTLE);
        items.register(Constants.Items.FERROCAPSICUMIUM_NUGGET.getPath(), ModItems.FERROCAPSICUMIUM_NUGGET);
        items.register(Constants.Items.FERROCAPSICUMIUM_INGOT.getPath(), ModItems.FERROCAPSICUMIUM_INGOT);
        items.register(Constants.Items.FERROCAPSICUMIUM_BLOCK.getPath(), ModItems.FERROCAPSICUMIUM_BLOCK);
        // Tools
        items.register(Constants.Items.FERROCAPSICUMIUM_SHOVEL.getPath(), ModItems.FERROCAPSICUMIUM_SHOVEL);
        items.register(Constants.Items.FERROCAPSICUMIUM_AXE.getPath(), ModItems.FERROCAPSICUMIUM_AXE);
        items.register(Constants.Items.FERROCAPSICUMIUM_HOE.getPath(), ModItems.FERROCAPSICUMIUM_HOE);
        items.register(Constants.Items.FERROCAPSICUMIUM_SHEARS.getPath(), ModItems.FERROCAPSICUMIUM_SHEARS);
        // Misc.
        items.register(Constants.Items.CAPSAICIN_POWDER.getPath(), ModItems.CAPSAICIN_POWDER);
        // Creative tab icon
        items.register(Constants.Items.ICON_MAIN.getPath(), ModItems.ICON_MAIN);
    }

    private static void registerSoundEvents() {
        var soundEvents = ModObjectRegistry.create(BuiltInRegistries.SOUND_EVENT, Constants.CBW_MOD_ID);

        soundEvents.register(Constants.SoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS.getPath(),
                ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);
    }

    private static void registerCriterionTriggers() {
        var criterionTriggers = ModObjectRegistry.create(BuiltInRegistries.TRIGGER_TYPES, Constants.CBW_MOD_ID);

        criterionTriggers.register(Constants.CriterionTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS.getPath(),
                ModCriteriaTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS);
        criterionTriggers.register(Constants.CriterionTriggers.THREW_HOT_SAUCE.getPath(),
                ModCriteriaTriggers.THREW_HOT_SAUCE);
    }

    private static void registerCreativeModeTabs() {
        var creativeModeTabs = ModObjectRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID);

        creativeModeTabs.register(Constants.CreativeModeTabs.MAIN.getPath(), getMainCreativeModeTab());
    }

    private static CreativeModeTab getMainCreativeModeTab() {
        // Use different title depending on whether CBW is loaded or not
        // ** Only on Fabric, change the title on CBW side due to mod loading and initialization timing **
        String titleKey = Constants.CreativeModeTabs.TITLE_MOD_MAIN;
        return FabricCreativeModeTab.builder()
                .icon(() -> new ItemStack(ModItems.ICON_MAIN))
                .title(Component.translatable(titleKey))
                .displayItems((params, output) -> {
                    for (Item i : ModItems.ITEMS) {
                        if (i != null) output.accept(i);
                    }
                })
                .build();
    }

    private record ModObjectRegistry<V, T extends V>(Registry<V> registry, String modId) {

        public static <V, T extends V> ModObjectRegistry<V, T> create(Registry<V> registry, String modId) {
            return new ModObjectRegistry<>(registry, modId);
        }

        public void register(String id, T object) {
            Registry.register(registry, Identifier.fromNamespaceAndPath(modId, id), object);
        }
    }
}
