package com.github.iunius118.cbwchilipeppersandfoods.item;

import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.world.item.*;
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
    public static final Item CHILI_SEEDS = add(new ItemNameBlockItem(ModBlocks.CHILI_PEPPER, new Item.Properties()));
    public static final Item CURVED_GREEN_CHILI = add(new Item(new Item.Properties()));
    public static final Item CURVED_CHILI = add(new Item(new Item.Properties()));
    public static final Item CURVED_CHILI_STRING = add(new BlockItem(ModBlocks.CURVED_CHILI_STRING, new Item.Properties()));
    public static final Item DRIED_CURVED_CHILI = add(new Item(new Item.Properties()));
    public static final Item CURVED_CHILI_SACK = add(new Item(new Item.Properties()));

    // Fuel
    public static final Item CHILI_BIOFUEL = add(new Item(new Item.Properties()));

    // Foods
    public static final Item HOT_SAUCE = add(new HotSauceItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE),
            HotSauceItem.RED_HOT_SAUCE_COLOR));
    public static final Item HOT_SAUCE_BARREL = add(new BlockItem(ModBlocks.HOT_SAUCE_BARREL, new Item.Properties()));
    public static final Item GREEN_HOT_SAUCE = add(new HotSauceItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE),
            HotSauceItem.GREEN_HOT_SAUCE_COLOR));
    public static final Item PICKLED_GREEN_CHILI = add(new Item(new Item.Properties().food(ModFoods.PICKLED_GREEN_CHILI)));
    public static final Item CHILI_CHICKEN_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.CHILI_CHICKEN_SANDWICH)));
    public static final Item CHILI_FISH_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.CHILI_FISH_SANDWICH)));
    public static final Item CHILI_MEAT_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.CHILI_MEAT_SANDWICH)));
    public static final Item CHILI_POTATO_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.CHILI_POTATO_SANDWICH)));
    public static final Item HALF_CHILI_CHICKEN_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.HALF_CHILI_CHICKEN_SANDWICH)));
    public static final Item HALF_CHILI_FISH_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.HALF_CHILI_FISH_SANDWICH)));
    public static final Item HALF_CHILI_MEAT_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.HALF_CHILI_MEAT_SANDWICH)));
    public static final Item HALF_CHILI_POTATO_SANDWICH = add(new Item(new Item.Properties().food(ModFoods.HALF_CHILI_POTATO_SANDWICH)));
    public static final Item PASTA_OIL_AND_CHILI = add(new Item(new Item.Properties().stacksTo(1).food(ModFoods.PASTA_OIL_AND_CHILI)));
    public static final Item FRIED_CHILI_PEPPER = add(new Item(new Item.Properties().food(ModFoods.FRIED_CHILI_PEPPER)));
    public static final Item CHILI_CHOCOLATE = add(new Item(new Item.Properties().food(ModFoods.CHILI_CHOCOLATE)));
    public static final Item CHILI_CHOCOLATE_CHICKEN = add(new Item(new Item.Properties().food(ModFoods.CHILI_CHOCOLATE_CHICKEN)));

    // Materials
    public static final Item CAPSAICIN_POWDER = add(new Item(new Item.Properties()));
    public static final Item FERROCAPSICUMIUM_NUGGET = add(new Item(new Item.Properties()));
    public static final Item FERROCAPSICUMIUM_INGOT = add(new Item(new Item.Properties()));
    public static final Item FERROCAPSICUMIUM_BLOCK = add(new BlockItem(ModBlocks.FERROCAPSICUMIUM_BLOCK, new Item.Properties()));

    // Tools
    public static final Item FERROCAPSICUMIUM_SHOVEL = add(new ShovelItem(ModTiers.FERROCAPSICUMIUM,
            new Item.Properties().attributes(ShovelItem.createAttributes(ModTiers.FERROCAPSICUMIUM, 1.5F, -3.0F))));
    public static final Item FERROCAPSICUMIUM_AXE = add(new AxeItem(ModTiers.FERROCAPSICUMIUM,
            new Item.Properties().attributes(AxeItem.createAttributes(ModTiers.FERROCAPSICUMIUM, 6.0F, -3.1F))));
    public static final Item FERROCAPSICUMIUM_HOE = add(new HoeItem(ModTiers.FERROCAPSICUMIUM,
            new Item.Properties().attributes(HoeItem.createAttributes(ModTiers.FERROCAPSICUMIUM, -2.0F, -1.0F))));
    public static final Item FERROCAPSICUMIUM_SHEARS = add(new ShearsItem(
            new Item.Properties().durability(ModTiers.FERROCAPSICUMIUM.getUses()).component(DataComponents.TOOL, ShearsItem.createToolProperties())));

    // Creative tab icon
    // This will not be added to creative tabs
    public static final Item ICON_MAIN = new Item(new Item.Properties());

    private static Item add(Item item) {
        ITEMS.add(item);
        return item;
    }

    static {
        // Register dispense item behaviors
        DispenserBlock.registerProjectileBehavior(HOT_SAUCE);
        DispenserBlock.registerProjectileBehavior(GREEN_HOT_SAUCE);
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
