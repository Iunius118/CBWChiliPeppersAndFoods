package com.github.iunius118.cbwchilipeppersandfoods.item;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Map<Item, Float> COMPOSTABLES = new HashMap<>();
    public static final Map<Item, Integer> FURNACE_FUELS = new HashMap<>();

    // Plants
    public static final Item CHILI_SEEDS = add(new BlockItem(ModBlocks.CHILI_PEPPER,
            createProperties(Constants.Items.CHILI_SEEDS)
                    .useItemDescriptionPrefix()));
    public static final Item CURVED_GREEN_CHILI = add(new Item(
            createProperties(Constants.Items.CURVED_GREEN_CHILI)));
    public static final Item CURVED_CHILI = add(new Item(
            createProperties(Constants.Items.CURVED_CHILI)));
    public static final Item CURVED_CHILI_STRING = add(new BlockItem(ModBlocks.CURVED_CHILI_STRING,
            createProperties(Constants.Items.CURVED_CHILI_STRING)
                    .useBlockDescriptionPrefix()));
    public static final Item DRIED_CURVED_CHILI = add(new Item(
            createProperties(Constants.Items.DRIED_CURVED_CHILI)));
    public static final Item CURVED_CHILI_SACK = add(new Item(
            createProperties(Constants.Items.CURVED_CHILI_SACK)));

    // Fuel
    public static final Item CHILI_BIOFUEL = add(new Item(
            createProperties(Constants.Items.CHILI_BIOFUEL)));

    // Foods
    public static final Item HOT_SAUCE = add(new HotSauceItem(
            createProperties(Constants.Items.HOT_SAUCE)
                    .craftRemainder(Items.GLASS_BOTTLE),
            HotSauceItem.HOT_SAUCE_DURATION, HotSauceItem.RED_HOT_SAUCE_COLOR));
    public static final Item HOT_SAUCE_BARREL = add(new BlockItem(ModBlocks.HOT_SAUCE_BARREL,
            createProperties(Constants.Items.HOT_SAUCE_BARREL)
                    .useBlockDescriptionPrefix()));
    public static final Item GREEN_HOT_SAUCE = add(new HotSauceItem(
            createProperties(Constants.Items.GREEN_HOT_SAUCE)
                    .craftRemainder(Items.GLASS_BOTTLE),
            HotSauceItem.HOT_SAUCE_DURATION, HotSauceItem.GREEN_HOT_SAUCE_COLOR));
    public static final Item PICKLED_GREEN_CHILI = add(new Item(
            createProperties(Constants.Items.PICKLED_GREEN_CHILI)
                    .food(ModFoods.PICKLED_GREEN_CHILI)
                    .component(DataComponents.CONSUMABLE, Consumable.builder()
                            .consumeSeconds(0.8F)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                    new MobEffectInstance(MobEffects.ABSORPTION, 600)))
                            .build())));
    public static final Item CHILI_CHICKEN_SANDWICH = add(new Item(
            createProperties(Constants.Items.CHILI_CHICKEN_SANDWICH)
                    .food(ModFoods.CHILI_CHICKEN_SANDWICH)));
    public static final Item CHILI_FISH_SANDWICH = add(new Item(
            createProperties(Constants.Items.CHILI_FISH_SANDWICH)
                    .food(ModFoods.CHILI_FISH_SANDWICH)));
    public static final Item CHILI_MEAT_SANDWICH = add(new Item(
            createProperties(Constants.Items.CHILI_MEAT_SANDWICH)
                    .food(ModFoods.CHILI_MEAT_SANDWICH)));
    public static final Item CHILI_POTATO_SANDWICH = add(new Item(
            createProperties(Constants.Items.CHILI_POTATO_SANDWICH)
                    .food(ModFoods.CHILI_POTATO_SANDWICH)));
    public static final Item HALF_CHILI_CHICKEN_SANDWICH = add(new Item(
            createProperties(Constants.Items.HALF_CHILI_CHICKEN_SANDWICH)
                    .food(ModFoods.HALF_CHILI_CHICKEN_SANDWICH)));
    public static final Item HALF_CHILI_FISH_SANDWICH = add(new Item(
            createProperties(Constants.Items.HALF_CHILI_FISH_SANDWICH)
                    .food(ModFoods.HALF_CHILI_FISH_SANDWICH)));
    public static final Item HALF_CHILI_MEAT_SANDWICH = add(new Item(
            createProperties(Constants.Items.HALF_CHILI_MEAT_SANDWICH)
                    .food(ModFoods.HALF_CHILI_MEAT_SANDWICH)));
    public static final Item HALF_CHILI_POTATO_SANDWICH = add(new Item(
            createProperties(Constants.Items.HALF_CHILI_POTATO_SANDWICH)
                    .food(ModFoods.HALF_CHILI_POTATO_SANDWICH)));
    public static final Item PASTA_OIL_AND_CHILI = add(new Item(
            createProperties(Constants.Items.PASTA_OIL_AND_CHILI)
                    .stacksTo(1)
                    .food(ModFoods.PASTA_OIL_AND_CHILI)
                    .usingConvertsTo(Items.BOWL)));
    public static final Item FRIED_CHILI_PEPPER = add(new Item(
            createProperties(Constants.Items.FRIED_CHILI_PEPPER)
                    .food(ModFoods.FRIED_CHILI_PEPPER)
                    .component(DataComponents.CONSUMABLE, Consumable.builder()
                            .consumeSeconds(0.8F)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                    new MobEffectInstance(MobEffects.SPEED, 600)))
                            .build())));
    public static final Item CHILI_CHOCOLATE = add(new Item(
            createProperties(Constants.Items.CHILI_CHOCOLATE)
                    .food(ModFoods.CHILI_CHOCOLATE)
                    .component(DataComponents.CONSUMABLE, Consumable.builder()
                            .consumeSeconds(0.8F)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                    new MobEffectInstance(MobEffects.HASTE, 600)))
                            .build())));
    public static final Item CHILI_CHOCOLATE_CHICKEN = add(new Item(
            createProperties(Constants.Items.CHILI_CHOCOLATE_CHICKEN)
                    .food(ModFoods.CHILI_CHOCOLATE_CHICKEN)));

    // Materials
    public static final Item CAPSICUM_CRYSTAL = add(new Item(
            createProperties(Constants.Items.CAPSICUM_CRYSTAL)));
    // Bottle of capsicum crystal will be added to creative mode tab by Chili Bullet Weapons mod
    public static final Item CAPSICUM_CRYSTAL_BOTTLE = new HotSauceItem(
            createProperties(Constants.Items.CAPSICUM_CRYSTAL_BOTTLE)
                    .craftRemainder(Items.GLASS_BOTTLE),
            HotSauceItem.CAPSICUM_CRYSTAL_DURATION, HotSauceItem.CAPSICUM_CRYSTAL_COLOR);
    public static final Item FERROCAPSICUMIUM_NUGGET = add(new Item(
            createProperties(Constants.Items.FERROCAPSICUMIUM_NUGGET)));
    public static final Item FERROCAPSICUMIUM_INGOT = add(new Item(
            createProperties(Constants.Items.FERROCAPSICUMIUM_INGOT)));
    public static final Item FERROCAPSICUMIUM_BLOCK = add(new BlockItem(ModBlocks.FERROCAPSICUMIUM_BLOCK,
            createProperties(Constants.Items.FERROCAPSICUMIUM_BLOCK)
                    .useBlockDescriptionPrefix()));

    // Tools
    public static final Item FERROCAPSICUMIUM_SHOVEL = add(new ShovelItem(
            ModToolMaterials.FERROCAPSICUMIUM, 1.5F, -3.0F,
            createProperties(Constants.Items.FERROCAPSICUMIUM_SHOVEL)));
    public static final Item FERROCAPSICUMIUM_AXE = add(new AxeItem(
            ModToolMaterials.FERROCAPSICUMIUM, 6.0F, -3.1F,
            createProperties(Constants.Items.FERROCAPSICUMIUM_AXE)));
    public static final Item FERROCAPSICUMIUM_HOE = add(new HoeItem(
            ModToolMaterials.FERROCAPSICUMIUM, -2.0F, -1.0F,
            createProperties(Constants.Items.FERROCAPSICUMIUM_HOE)));
    public static final Item FERROCAPSICUMIUM_SHEARS = add(new ShearsItem(
            createProperties(Constants.Items.FERROCAPSICUMIUM_SHEARS)
                    .durability(ModToolMaterials.FERROCAPSICUMIUM.durability())
                    .repairable(ModToolMaterials.FERROCAPSICUMIUM.repairItems())
                    .component(DataComponents.TOOL, ShearsItem.createToolProperties())));

    // Misc.
    // Capsaicin powder is deprecated since v1.1.1
    public static final Item CAPSAICIN_POWDER = new Item(createProperties(Constants.Items.CAPSAICIN_POWDER));

    // Creative tab icon
    // This will not be added to creative tabs
    public static final Item ICON_MAIN = new Item(createProperties(Constants.Items.ICON_MAIN));

    private static Item add(Item item) {
        ITEMS.add(item);
        return item;
    }

    private static Item.Properties createProperties(Identifier id) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id));
    }

    private static void registerBlockItem(Item item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }
    }

    static {
        // Register block items
        registerBlockItem(CHILI_SEEDS);
        registerBlockItem(CURVED_CHILI_STRING);
        registerBlockItem(HOT_SAUCE_BARREL);
        registerBlockItem(FERROCAPSICUMIUM_BLOCK);

        // Register dispense item behaviors
        DispenserBlock.registerProjectileBehavior(HOT_SAUCE);
        DispenserBlock.registerProjectileBehavior(GREEN_HOT_SAUCE);
        DispenserBlock.registerProjectileBehavior(CAPSICUM_CRYSTAL_BOTTLE);
        DispenserBlock.registerBehavior(FERROCAPSICUMIUM_SHEARS, new ShearsDispenseItemBehavior());

        // Add compostable items
        COMPOSTABLES.put(CHILI_SEEDS, 0.3F);
        COMPOSTABLES.put(CURVED_GREEN_CHILI, 0.3F);
        COMPOSTABLES.put(CURVED_CHILI, 0.3F);
        COMPOSTABLES.put(CURVED_CHILI_STRING, 0.85F);
        COMPOSTABLES.put(DRIED_CURVED_CHILI, 0.3F);
        COMPOSTABLES.put(PICKLED_GREEN_CHILI, 0.3F);
        COMPOSTABLES.put(CHILI_POTATO_SANDWICH, 0.85F);
        COMPOSTABLES.put(HALF_CHILI_POTATO_SANDWICH, 0.5F);
        COMPOSTABLES.put(FRIED_CHILI_PEPPER, 0.3F);
        COMPOSTABLES.put(CHILI_CHOCOLATE, 0.3F);

        // Add fuel items
        FURNACE_FUELS.put(CHILI_BIOFUEL, 1600);
    }
}
