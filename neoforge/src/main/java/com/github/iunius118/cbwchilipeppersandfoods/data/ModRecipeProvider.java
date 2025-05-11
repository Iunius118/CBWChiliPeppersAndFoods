package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput, HolderLookup.Provider holderLookup) {
        /* Plants */
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

        /* Foods */
        // Hot sauce
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.HOT_SAUCE, 3)
                .group(getItemId(ModItems.HOT_SAUCE).toString())
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ggg")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItemTags.FOODS_CHILI_PEPPER)
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
                .define('c', ModItemTags.FOODS_CHILI_PEPPER)
                .unlockedBy("has_hot_sauce", has(ModItems.HOT_SAUCE))
                .save(recipeOutput, getItemId(ModItems.HOT_SAUCE_BARREL));

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
                .define('c', ModItemTags.FOODS_CHILI_PEPPER)
                .define('w', Tags.Items.CROPS_WHEAT)
                .define('b', Items.BOWL)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.PASTA_OIL_AND_CHILI));

        // Fried chili pepper
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRIED_CHILI_PEPPER, 3)
                .group(getItemId(ModItems.FRIED_CHILI_PEPPER).toString())
                .requires(ModItemTags.FOODS_CHILI_PEPPER)
                .requires(ModItemTags.FOODS_CHILI_PEPPER)
                .requires(ModItemTags.FOODS_CHILI_PEPPER)
                .requires(Items.WHEAT)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(recipeOutput, getItemId(ModItems.FRIED_CHILI_PEPPER));
    }

    private ResourceLocation getItemId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
