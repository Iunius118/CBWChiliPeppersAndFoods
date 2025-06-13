package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput, HolderLookup.Provider holderLookup) {
        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistry = holderLookup.lookupOrThrow(Registries.ENCHANTMENT);

        //* Plants *//

        // Seeds
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHILI_SEEDS)
                .group(getItemId(ModItems.CHILI_SEEDS).toString())
                .requires(ModItems.CURVED_CHILI)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_SEEDS));

        // Drying Curved Chili Peppers
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CURVED_CHILI_STRING)
                .group(getItemId(ModItems.CURVED_CHILI_STRING).toString())
                .pattern("ccc")
                .pattern("ccc")
                .pattern("ccc")
                .define('c', ModItems.CURVED_CHILI)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CURVED_CHILI_STRING));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CURVED_CHILI, 9)
                .group(getItemId(ModItems.CURVED_CHILI).toString())
                .requires(ModItems.CURVED_CHILI_STRING)
                .unlockedBy("has_curved_chili_string", has(ModItems.CURVED_CHILI_STRING))
                .save(recipeOutput, getItemId(ModItems.CURVED_CHILI) + "_from_string");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.MISC, ModItems.DRIED_CURVED_CHILI, 0.1F, 200)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.DRIED_CURVED_CHILI));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.FOOD, ModItems.DRIED_CURVED_CHILI, 0.1F, 100)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.FOOD, ModItems.DRIED_CURVED_CHILI, 0.1F, 600)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_campfire_cooking");

        // Storage items
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CURVED_CHILI_SACK)
                .group(getItemId(ModItems.CURVED_CHILI_SACK).toString())
                .pattern("ccc")
                .pattern("ccc")
                .pattern("ccc")
                .define('c', ModItems.DRIED_CURVED_CHILI)
                .unlockedBy("has_dried_curved_chili", has(ModItems.DRIED_CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CURVED_CHILI_SACK));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DRIED_CURVED_CHILI, 9)
                .group(getItemId(ModItems.DRIED_CURVED_CHILI).toString())
                .requires(ModItems.CURVED_CHILI_SACK)
                .unlockedBy("has_curved_chili_sack", has(ModItems.CURVED_CHILI_SACK))
                .save(recipeOutput, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_sack");

        //* Fuel *//

        // Chili Plant Biofuel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHILI_BIOFUEL)
                .group(getItemId(ModItems.CHILI_BIOFUEL).toString())
                .pattern("cc")
                .pattern("cc")
                .define('c', ModItemTags.CHILI_BIOMASS)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_BIOFUEL));

        //* Foods *//

        // Hot sauce
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOT_SAUCE, 3)
                .group(getItemId(ModItems.HOT_SAUCE).toString())
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ggg")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItemTags.FOODS_RED_CHILI_PEPPER)
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.HOT_SAUCE));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOT_SAUCE, 8)
                .group(getItemId(ModItems.HOT_SAUCE).toString())
                .pattern("ggg")
                .pattern("g#g")
                .pattern("ggg")
                .define('g', Items.GLASS_BOTTLE)
                .define('#', ModItems.HOT_SAUCE_BARREL)
                .unlockedBy("has_hot_sauce", has(ModItems.HOT_SAUCE))
                .save(recipeOutput, getItemId(ModItems.HOT_SAUCE) + "_from_barrel");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOT_SAUCE_BARREL)
                .group(getItemId(ModItems.HOT_SAUCE_BARREL).toString())
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ccc")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItemTags.FOODS_RED_CHILI_PEPPER)
                .unlockedBy("has_hot_sauce", has(ModItems.HOT_SAUCE))
                .save(recipeOutput, getItemId(ModItems.HOT_SAUCE_BARREL));

        // Green chili sauce
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.GREEN_HOT_SAUCE, 3)
                .group(getItemId(ModItems.GREEN_HOT_SAUCE).toString())
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ggg")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItems.CURVED_GREEN_CHILI)
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_GREEN_CHILI))
                .save(recipeOutput, getItemId(ModItems.GREEN_HOT_SAUCE));

        // Picked green chili pepper
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PICKLED_GREEN_CHILI, 6)
                .group(getItemId(ModItems.PICKLED_GREEN_CHILI).toString())
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ccc")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItems.CURVED_GREEN_CHILI)
                .unlockedBy("has_hot_sauce", has(ModItems.CURVED_GREEN_CHILI))
                .save(recipeOutput, getItemId(ModItems.PICKLED_GREEN_CHILI));

        // Sandwiches
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_CHICKEN_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_CHICKEN_SANDWICH).toString())
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(Items.COOKED_CHICKEN)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_CHICKEN_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_FISH_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_FISH_SANDWICH).toString())
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(ModItemTags.FOODS_COOKED_FISH)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_FISH_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_MEAT_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_MEAT_SANDWICH).toString())
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(ModItemTags.FOODS_COOKED_MEAT)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_MEAT_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_POTATO_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_POTATO_SANDWICH).toString())
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(Items.BAKED_POTATO)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_POTATO_SANDWICH));

        // Half-sized sandwiches
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HALF_CHILI_CHICKEN_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_CHICKEN_SANDWICH).toString())
                .requires(ModItems.CHILI_CHICKEN_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_CHICKEN_SANDWICH))
                .save(recipeOutput, getItemId(ModItems.HALF_CHILI_CHICKEN_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HALF_CHILI_FISH_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_FISH_SANDWICH).toString())
                .requires(ModItems.CHILI_FISH_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_FISH_SANDWICH))
                .save(recipeOutput, getItemId(ModItems.HALF_CHILI_FISH_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HALF_CHILI_MEAT_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_MEAT_SANDWICH).toString())
                .requires(ModItems.CHILI_MEAT_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_MEAT_SANDWICH))
                .save(recipeOutput, getItemId(ModItems.HALF_CHILI_MEAT_SANDWICH));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.HALF_CHILI_POTATO_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_POTATO_SANDWICH).toString())
                .requires(ModItems.CHILI_POTATO_SANDWICH)
                .unlockedBy("has_curved_chili", has(ModItems.CHILI_POTATO_SANDWICH))
                .save(recipeOutput, getItemId(ModItems.HALF_CHILI_POTATO_SANDWICH));

        // Pasta
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PASTA_OIL_AND_CHILI)
                .group(getItemId(ModItems.PASTA_OIL_AND_CHILI).toString())
                .pattern(" c ")
                .pattern("www")
                .pattern(" b ")
                .define('c', ModItemTags.FOODS_CHILI_PEPPERS)
                .define('w', Tags.Items.CROPS_WHEAT)
                .define('b', Items.BOWL)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.PASTA_OIL_AND_CHILI));

        // Fried chili pepper
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRIED_CHILI_PEPPER, 3)
                .group(getItemId(ModItems.FRIED_CHILI_PEPPER).toString())
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(Items.WHEAT)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.FRIED_CHILI_PEPPER));

        // Chili Chocolate
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_CHOCOLATE, 3)
                .group(getItemId(ModItems.CHILI_CHOCOLATE).toString())
                .requires(ModItems.DRIED_CURVED_CHILI)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.CHILI_CHOCOLATE));

        // Chicken with Chili Chocolate Sauce
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CHILI_CHOCOLATE_CHICKEN)
                .group(getItemId(ModItems.CHILI_CHOCOLATE_CHICKEN).toString())
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.CHILI_CHOCOLATE)
                .unlockedBy("has_chili_chocolate", has(ModItems.CHILI_CHOCOLATE))
                .save(recipeOutput, getItemId(ModItems.CHILI_CHOCOLATE_CHICKEN));

        //* Materials *//

        // Capsaicin Powder
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CAPSAICIN_POWDER)
                .group(getItemId(ModItems.CAPSAICIN_POWDER).toString())
                .requires(ModItems.HOT_SAUCE_BARREL)
                .requires(Items.NETHER_WART)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy("has_hot_sauce_barrel", has(ModItems.HOT_SAUCE_BARREL))
                .save(recipeOutput, getItemId(ModItems.CAPSAICIN_POWDER));

        // Ferro-Capsicumium Nugget
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_NUGGET, 9)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_NUGGET).toString())
                .requires(ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_NUGGET));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT).toString())
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .define('n', ModItems.FERROCAPSICUMIUM_NUGGET)
                .unlockedBy("has_ferrocapsicumium_nugget", has(ModItems.FERROCAPSICUMIUM_NUGGET))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_INGOT) + "_from_nuggets");

        // Ferro-Capsicumium Nugget from smelting ferro-capsicumium items
        var ingredientsForNugget = Ingredient.of(
                ModItems.FERROCAPSICUMIUM_SHOVEL,
                ModItems.FERROCAPSICUMIUM_AXE,
                ModItems.FERROCAPSICUMIUM_HOE);
        SimpleCookingRecipeBuilder.smelting(ingredientsForNugget, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_NUGGET, 0.1F, 200)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_NUGGET) + "_from_smelting");
        SimpleCookingRecipeBuilder.blasting(ingredientsForNugget, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_NUGGET, 0.1F, 100)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_NUGGET) + "_from_blasting");

        // Ferro-Capsicumium Ingot
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT, 4)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT).toString())
                .pattern("iir")
                .pattern("igc")
                .pattern("rcc")
                .define('i', Tags.Items.INGOTS_IRON)
                .define('r', Tags.Items.DUSTS_REDSTONE)
                .define('g', Tags.Items.INGOTS_GOLD)
                .define('c', ModItems.CAPSAICIN_POWDER)
                .unlockedBy("has_capsaicin_powder", has(ModItems.CAPSAICIN_POWDER))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_INGOT));

        // Iron Ingot from Ferro-Capsicumium Ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.FERROCAPSICUMIUM_INGOT), RecipeCategory.MISC, Items.IRON_INGOT, 0.1F, 200)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, Constants.CBW_MOD_ID + ":iron_ingot_from_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.FERROCAPSICUMIUM_INGOT), RecipeCategory.MISC, Items.IRON_INGOT, 0.1F, 100)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, Constants.CBW_MOD_ID + ":iron_ingot_from_blasting");

        // Block of Ferro-Capsicumium
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FERROCAPSICUMIUM_BLOCK)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_BLOCK).toString())
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_BLOCK));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT, 9)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT).toString())
                .requires(ModItems.FERROCAPSICUMIUM_BLOCK)
                .unlockedBy("has_ferrocapsicumium_block", has(ModItems.FERROCAPSICUMIUM_BLOCK))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_INGOT) + "_from_block");

        //* Tools *//

        // Ferro-Capsicumium Shovel
        ItemStack feCapShovel = new ItemStack(ModItems.FERROCAPSICUMIUM_SHOVEL);
        // Add enchantments to shovel
        feCapShovel.enchant(enchantmentRegistry.getOrThrow(Enchantments.EFFICIENCY), 1);
        feCapShovel.enchant(enchantmentRegistry.getOrThrow(Enchantments.UNBREAKING), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, feCapShovel)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_SHOVEL).toString())
                .pattern("i")
                .pattern("s")
                .pattern("s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_SHOVEL));

        // Ferro-Capsicumium Axe
        ItemStack feCapAxe = new ItemStack(ModItems.FERROCAPSICUMIUM_AXE);
        // Add enchantments to axe
        feCapAxe.enchant(enchantmentRegistry.getOrThrow(Enchantments.EFFICIENCY), 1);
        feCapAxe.enchant(enchantmentRegistry.getOrThrow(Enchantments.UNBREAKING), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, feCapAxe)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_AXE).toString())
                .pattern("ii")
                .pattern("is")
                .pattern(" s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_AXE));

        // Ferro-Capsicumium Hoe
        ItemStack feCapHoe = new ItemStack(ModItems.FERROCAPSICUMIUM_HOE);
        // Add enchantments to hoe
        feCapHoe.enchant(enchantmentRegistry.getOrThrow(Enchantments.FORTUNE), 1);
        feCapHoe.enchant(enchantmentRegistry.getOrThrow(Enchantments.UNBREAKING), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, feCapHoe)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_HOE).toString())
                .pattern("ii")
                .pattern(" s")
                .pattern(" s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_HOE));

        // Ferro-Capsicumium Shears
        ItemStack feCapShears = new ItemStack(ModItems.FERROCAPSICUMIUM_SHEARS);
        // Add enchantments to shears
        feCapShears.enchant(enchantmentRegistry.getOrThrow(Enchantments.UNBREAKING), 1);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, feCapShears)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_SHEARS).toString())
                .pattern(" i")
                .pattern("i ")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(recipeOutput, getItemId(ModItems.FERROCAPSICUMIUM_SHEARS));
    }

    private ResourceLocation getItemId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
