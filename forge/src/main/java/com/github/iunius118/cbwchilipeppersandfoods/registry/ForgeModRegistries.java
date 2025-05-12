package com.github.iunius118.cbwchilipeppersandfoods.registry;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ForgeModRegistries {

    public static void registerGameObjects(IEventBus modEventBus) {
        registerBlocks(modEventBus);
        registerItems(modEventBus);
        registerSoundEvents(modEventBus);
        registerCreativeModeTabs(modEventBus);
    }

    private static void registerBlocks(IEventBus modEventBus) {
        var blockRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.CBW_MOD_ID);

        blockRegister.register("chili_pepper", () -> ModBlocks.CHILI_PEPPER);
        blockRegister.register("curved_chili_string", () -> ModBlocks.CURVED_CHILI_STRING);
        blockRegister.register("hot_sauce_barrel", () -> ModBlocks.HOT_SAUCE_BARREL);

        blockRegister.register(modEventBus);
    }

    private static void registerItems(IEventBus modEventBus) {
        var itemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.CBW_MOD_ID);

        // Plants
        itemRegister.register("chili_seeds", () -> ModItems.CHILI_SEEDS);
        itemRegister.register("curved_chili", () -> ModItems.CURVED_CHILI);
        itemRegister.register("curved_chili_string", () -> ModItems.CURVED_CHILI_STRING);
        itemRegister.register("dried_curved_chili", () -> ModItems.DRIED_CURVED_CHILI);
        itemRegister.register("curved_chili_sack", () -> ModItems.CURVED_CHILI_SACK);
        // Foods
        itemRegister.register("hot_sauce", () -> ModItems.HOT_SAUCE);
        itemRegister.register("hot_sauce_barrel", () -> ModItems.HOT_SAUCE_BARREL);
        itemRegister.register("chili_chicken_sandwich", () -> ModItems.CHILI_CHICKEN_SANDWICH);
        itemRegister.register("chili_fish_sandwich", () -> ModItems.CHILI_FISH_SANDWICH);
        itemRegister.register("chili_meat_sandwich", () -> ModItems.CHILI_MEAT_SANDWICH);
        itemRegister.register("chili_potato_sandwich", () -> ModItems.CHILI_POTATO_SANDWICH);
        itemRegister.register("half_chili_chicken_sandwich", () -> ModItems.HALF_CHILI_CHICKEN_SANDWICH);
        itemRegister.register("half_chili_fish_sandwich", () -> ModItems.HALF_CHILI_FISH_SANDWICH);
        itemRegister.register("half_chili_meat_sandwich", () -> ModItems.HALF_CHILI_MEAT_SANDWICH);
        itemRegister.register("half_chili_potato_sandwich", () -> ModItems.HALF_CHILI_POTATO_SANDWICH);
        itemRegister.register("pasta_oil_and_chili", () -> ModItems.PASTA_OIL_AND_CHILI);
        itemRegister.register("fried_chili_pepper", () -> ModItems.FRIED_CHILI_PEPPER);
        // Misc.
        itemRegister.register("capsaicin_powder", () -> ModItems.CAPSAICIN_POWDER);

        itemRegister.register(modEventBus);
    }

    private static void registerSoundEvents(IEventBus modEventBus) {
        var soundEventRegister = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Constants.CBW_MOD_ID);

        soundEventRegister.register("block_chili_pepper_pick_chili_peppers", () -> ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS);

        soundEventRegister.register(modEventBus);
    }

    private static void registerCreativeModeTabs(IEventBus modEventBus) {
        var creativeModeTabRegister = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.CBW_MOD_ID);

        creativeModeTabRegister.register("main", ForgeModRegistries::getMainCreativeModeTab);

        creativeModeTabRegister.register(modEventBus);
    }

    private static CreativeModeTab getMainCreativeModeTab() {
        return CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.%s.main".formatted(Constants.CBW_MOD_ID)))
                .icon(() -> new ItemStack(ModItems.CURVED_CHILI))
                .displayItems((params, output) -> {
                    for (Item i : ModItems.ITEMS) {
                        if (i != null) output.accept(i);
                    }
                })
                .build();
    }
}
