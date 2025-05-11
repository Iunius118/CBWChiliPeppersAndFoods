package com.github.iunius118.cbwchilipeppersandfoods.item;

import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();

    // Plants
    public static final Item CHILI_SEEDS = add(new ItemNameBlockItem(ModBlocks.CHILI_PEPPER, new Item.Properties()));
    public static final Item CURVED_CHILI = add(new Item(new Item.Properties()));
    public static final Item CURVED_CHILI_STRING = add(new BlockItem(ModBlocks.CURVED_CHILI_STRING, new Item.Properties()));
    public static final Item DRIED_CURVED_CHILI = add(new Item(new Item.Properties()));
    public static final Item CURVED_CHILI_SACK = add(new Item(new Item.Properties()));

    // Foods
    public static final Item HOT_SAUCE = add(new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
    public static final Item HOT_SAUCE_BARREL = add(new BlockItem(ModBlocks.HOT_SAUCE_BARREL, new Item.Properties()));
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

    // Misc.
    public static final Item CAPSAICIN_POWDER = add(new Item(new Item.Properties()));

    private static Item add(Item item) {
        ITEMS.add(item);
        return item;
    }
}
