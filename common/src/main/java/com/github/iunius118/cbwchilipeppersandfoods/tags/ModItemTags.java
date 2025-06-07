package com.github.iunius118.cbwchilipeppersandfoods.tags;

import com.github.iunius118.cbwchilipeppersandfoods.CommonClass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> C_CROPS = makeCTag("crops");
    public static final TagKey<Item> C_CROPS_CHILI = makeCTag("crops/chili");
    public static final TagKey<Item> C_SEEDS = makeCTag("seeds");
    public static final TagKey<Item> C_SEEDS_CHILI = makeCTag("seeds/chili");
    public static final TagKey<Item> C_TOOLS_SHEAR = makeCTag("tools/shear");

    public static final TagKey<Item> FOODS_CHILI_PEPPERS = makeCBWTag("foods/chili_peppers");
    public static final TagKey<Item> FOODS_RED_CHILI_PEPPER = makeCBWTag("foods/chili_peppers/red");
    public static final TagKey<Item> FOODS_GREEN_CHILI_PEPPER = makeCBWTag("foods/chili_peppers/green");
    public static final TagKey<Item> FOODS_CHILI_SEASONING = makeCBWTag("foods/chili_seasoning");
    public static final TagKey<Item> FOODS_COOKED_FISH = makeCBWTag("foods/cooked_fish");
    public static final TagKey<Item> FOODS_COOKED_MEAT = makeCBWTag("foods/cooked_meat");
    public static final TagKey<Item> CHILI_BIOMASS = makeCBWTag("chili_biomass");

    private static TagKey<Item> makeCBWTag(String id) {
        return TagKey.create(Registries.ITEM, CommonClass.modCBWLocation(id));
    }

    private static TagKey<Item> makeCTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
