package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class FabricModRegistries {

    public static void registerGameObjects() {
        registerBlocks();
        registerItems();
        registerSoundEvents();
        registerCreativeModeTabs();
    }

    private static void registerBlocks() {
        var blockRegister = ModObjectRegistry.create(BuiltInRegistries.BLOCK, Constants.CBW_MOD_ID);

        blockRegister.register(Constants.Blocks.CHILI_PEPPER.getPath(), ModBlocks.CHILI_PEPPER);
        blockRegister.register(Constants.Blocks.CURVED_CHILI_STRING.getPath(), ModBlocks.CURVED_CHILI_STRING);
        blockRegister.register(Constants.Blocks.HOT_SAUCE_BARREL.getPath(), ModBlocks.HOT_SAUCE_BARREL);
    }

    private static void registerItems() {
        var itemRegister = ModObjectRegistry.create(BuiltInRegistries.ITEM, Constants.CBW_MOD_ID);

        // Plants
        itemRegister.register(Constants.Items.CHILI_SEEDS.getPath(), ModItems.CHILI_SEEDS);
        itemRegister.register(Constants.Items.CURVED_GREEN_CHILI.getPath(), ModItems.CURVED_GREEN_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI.getPath(), ModItems.CURVED_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI_STRING.getPath(), ModItems.CURVED_CHILI_STRING);
        itemRegister.register(Constants.Items.DRIED_CURVED_CHILI.getPath(), ModItems.DRIED_CURVED_CHILI);
        itemRegister.register(Constants.Items.CURVED_CHILI_SACK.getPath(), ModItems.CURVED_CHILI_SACK);
        // Foods
        itemRegister.register(Constants.Items.HOT_SAUCE.getPath(), ModItems.HOT_SAUCE);
        itemRegister.register(Constants.Items.HOT_SAUCE_BARREL.getPath(), ModItems.HOT_SAUCE_BARREL);
        itemRegister.register(Constants.Items.GREEN_HOT_SAUCE.getPath(), ModItems.GREEN_HOT_SAUCE);
        itemRegister.register(Constants.Items.PICKLED_GREEN_CHILI.getPath(), ModItems.PICKLED_GREEN_CHILI);
        itemRegister.register(Constants.Items.CHILI_CHICKEN_SANDWICH.getPath(), ModItems.CHILI_CHICKEN_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_FISH_SANDWICH.getPath(), ModItems.CHILI_FISH_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_MEAT_SANDWICH.getPath(), ModItems.CHILI_MEAT_SANDWICH);
        itemRegister.register(Constants.Items.CHILI_POTATO_SANDWICH.getPath(), ModItems.CHILI_POTATO_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH.getPath(), ModItems.HALF_CHILI_CHICKEN_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_FISH_SANDWICH.getPath(), ModItems.HALF_CHILI_FISH_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_MEAT_SANDWICH.getPath(), ModItems.HALF_CHILI_MEAT_SANDWICH);
        itemRegister.register(Constants.Items.HALF_CHILI_POTATO_SANDWICH.getPath(), ModItems.HALF_CHILI_POTATO_SANDWICH);
        itemRegister.register(Constants.Items.PASTA_OIL_AND_CHILI.getPath(), ModItems.PASTA_OIL_AND_CHILI);
        itemRegister.register(Constants.Items.FRIED_CHILI_PEPPER.getPath(), ModItems.FRIED_CHILI_PEPPER);
        itemRegister.register(Constants.Items.CHILI_CHOCOLATE.getPath(), ModItems.CHILI_CHOCOLATE);
        itemRegister.register(Constants.Items.CHILI_CHOCOLATE_CHICKEN.getPath(), ModItems.CHILI_CHOCOLATE_CHICKEN);
        // Misc.
        itemRegister.register(Constants.Items.CAPSAICIN_POWDER.getPath(), ModItems.CAPSAICIN_POWDER);
        // Creative tab icon
        itemRegister.register(Constants.Items.ICON_MAIN.getPath(), ModItems.ICON_MAIN);
    }

    private static void registerSoundEvents() {
        var soundEventRegister = ModObjectRegistry.create(BuiltInRegistries.SOUND_EVENT, Constants.CBW_MOD_ID);

        soundEventRegister.register(Constants.SoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS.getPath(), ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);
    }

    private static void registerCreativeModeTabs() {
        var creativeModeTabRegister = ModObjectRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID);

        creativeModeTabRegister.register(Constants.CreativeModeTabs.MAIN.getPath(), getMainCreativeModeTab());
    }

    private static CreativeModeTab getMainCreativeModeTab() {
        return FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.%s.main".formatted(Constants.CBW_MOD_ID)))
                .icon(() -> new ItemStack(ModItems.ICON_MAIN))
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
            Registry.register(registry, ResourceLocation.fromNamespaceAndPath(modId, id), object);
        }
    }
}
