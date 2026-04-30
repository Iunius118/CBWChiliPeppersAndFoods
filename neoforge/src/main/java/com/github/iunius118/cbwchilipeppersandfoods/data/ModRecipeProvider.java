package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends VanillaRecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        HolderLookup.RegistryLookup<Item> items = this.registries.lookupOrThrow(Registries.ITEM);
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        //* Plants *//

        // Seeds
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.CHILI_SEEDS)
                .group(getItemId(ModItems.CHILI_SEEDS))
                .requires(ModItems.CURVED_CHILI)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        // Drying Curved Chili Peppers
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.CURVED_CHILI_STRING)
                .group(getItemId(ModItems.CURVED_CHILI_STRING))
                .pattern("ccc")
                .pattern("ccc")
                .pattern("ccc")
                .define('c', ModItems.CURVED_CHILI)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.CURVED_CHILI, 9)
                .group(getItemId(ModItems.CURVED_CHILI))
                .requires(ModItems.CURVED_CHILI_STRING)
                .unlockedBy("has_curved_chili_string", has(ModItems.CURVED_CHILI_STRING))
                .save(this.output, getItemId(ModItems.CURVED_CHILI) + "_from_string");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.MISC,
                        CookingBookCategory.FOOD, ModItems.DRIED_CURVED_CHILI, 0.1F, 200)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.FOOD,
                        ModItems.DRIED_CURVED_CHILI, 0.1F, 100)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.CURVED_CHILI), RecipeCategory.FOOD,
                        ModItems.DRIED_CURVED_CHILI, 0.1F, 600)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_campfire_cooking");

        // Storage items
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.CURVED_CHILI_SACK)
                .group(getItemId(ModItems.CURVED_CHILI_SACK))
                .pattern("ccc")
                .pattern("ccc")
                .pattern("ccc")
                .define('c', ModItems.DRIED_CURVED_CHILI)
                .unlockedBy("has_dried_curved_chili", has(ModItems.DRIED_CURVED_CHILI))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.DRIED_CURVED_CHILI, 9)
                .group(getItemId(ModItems.DRIED_CURVED_CHILI))
                .requires(ModItems.CURVED_CHILI_SACK)
                .unlockedBy("has_curved_chili_sack", has(ModItems.CURVED_CHILI_SACK))
                .save(this.output, getItemId(ModItems.DRIED_CURVED_CHILI) + "_from_sack");

        //* Fuel *//

        // Chili Plant Biofuel
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.CHILI_BIOFUEL)
                .group(getItemId(ModItems.CHILI_BIOFUEL))
                .pattern("cc")
                .pattern("cc")
                .define('c', ModItemTags.CHILI_BIOMASS)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        //* Foods *//

        // Hot sauce
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.HOT_SAUCE, 3)
                .group(getItemId(ModItems.HOT_SAUCE))
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ggg")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItemTags.FOODS_RED_CHILI_PEPPER)
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.HOT_SAUCE, 8)
                .group(getItemId(ModItems.HOT_SAUCE))
                .pattern("ggg")
                .pattern("g#g")
                .pattern("ggg")
                .define('g', Items.GLASS_BOTTLE)
                .define('#', ModItems.HOT_SAUCE_BARREL)
                .unlockedBy("has_hot_sauce", has(ModItems.HOT_SAUCE))
                .save(this.output, getItemId(ModItems.HOT_SAUCE) + "_from_barrel");

        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.HOT_SAUCE_BARREL)
                .group(getItemId(ModItems.HOT_SAUCE_BARREL))
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ccc")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItemTags.FOODS_RED_CHILI_PEPPER)
                .unlockedBy("has_hot_sauce", has(ModItems.HOT_SAUCE))
                .save(this.output);

        // Green chili sauce
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.GREEN_HOT_SAUCE, 3)
                .group(getItemId(ModItems.GREEN_HOT_SAUCE))
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ggg")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItems.CURVED_GREEN_CHILI)
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_GREEN_CHILI))
                .save(this.output);

        // Picked green chili pepper
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.PICKLED_GREEN_CHILI, 6)
                .group(getItemId(ModItems.PICKLED_GREEN_CHILI))
                .pattern(" w ")
                .pattern("ccc")
                .pattern("ccc")
                .define('w', Items.WATER_BUCKET)
                .define('c', ModItems.CURVED_GREEN_CHILI)
                .unlockedBy("has_hot_sauce", has(ModItems.CURVED_GREEN_CHILI))
                .save(this.output);

        // Sandwiches
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_CHICKEN_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_CHICKEN_SANDWICH))
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(Items.COOKED_CHICKEN)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_FISH_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_FISH_SANDWICH))
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(ModItemTags.FOODS_COOKED_FISH)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_MEAT_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_MEAT_SANDWICH))
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(ModItemTags.FOODS_COOKED_MEAT)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_POTATO_SANDWICH, 2)
                .group(getItemId(ModItems.CHILI_POTATO_SANDWICH))
                .requires(ModItemTags.FOODS_CHILI_SEASONING)
                .requires(Items.BAKED_POTATO)
                .requires(Items.BREAD)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        // Half-sized sandwiches
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.HALF_CHILI_CHICKEN_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_CHICKEN_SANDWICH))
                .requires(ModItems.CHILI_CHICKEN_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_CHICKEN_SANDWICH))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.HALF_CHILI_FISH_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_FISH_SANDWICH))
                .requires(ModItems.CHILI_FISH_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_FISH_SANDWICH))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.HALF_CHILI_MEAT_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_MEAT_SANDWICH))
                .requires(ModItems.CHILI_MEAT_SANDWICH)
                .unlockedBy("has_full_sandwich", has(ModItems.CHILI_MEAT_SANDWICH))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.HALF_CHILI_POTATO_SANDWICH, 2)
                .group(getItemId(ModItems.HALF_CHILI_POTATO_SANDWICH))
                .requires(ModItems.CHILI_POTATO_SANDWICH)
                .unlockedBy("has_curved_chili", has(ModItems.CHILI_POTATO_SANDWICH))
                .save(this.output);

        // Pasta
        ShapedRecipeBuilder.shaped(items, RecipeCategory.FOOD, ModItems.PASTA_OIL_AND_CHILI)
                .group(getItemId(ModItems.PASTA_OIL_AND_CHILI))
                .pattern(" c ")
                .pattern("www")
                .pattern(" b ")
                .define('c', ModItemTags.FOODS_CHILI_PEPPERS)
                .define('w', Tags.Items.CROPS_WHEAT)
                .define('b', Items.BOWL)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        // Fried chili pepper
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.FRIED_CHILI_PEPPER, 3)
                .group(getItemId(ModItems.FRIED_CHILI_PEPPER))
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(ModItemTags.FOODS_CHILI_PEPPERS)
                .requires(Items.WHEAT)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        // Chili Chocolate
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_CHOCOLATE, 3)
                .group(getItemId(ModItems.CHILI_CHOCOLATE))
                .requires(ModItems.DRIED_CURVED_CHILI)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .requires(Items.COCOA_BEANS)
                .unlockedBy("has_curved_chili", has(ModItems.CURVED_CHILI))
                .save(this.output);

        // Chicken with Chili Chocolate Sauce
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.FOOD, ModItems.CHILI_CHOCOLATE_CHICKEN)
                .group(getItemId(ModItems.CHILI_CHOCOLATE_CHICKEN))
                .requires(Items.COOKED_CHICKEN)
                .requires(ModItems.CHILI_CHOCOLATE)
                .unlockedBy("has_chili_chocolate", has(ModItems.CHILI_CHOCOLATE))
                .save(this.output);

        //* Materials *//

        // Capsicum Crystal
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.CAPSICUM_CRYSTAL)
                .group(getItemId(ModItems.CAPSICUM_CRYSTAL))
                .requires(ModItems.HOT_SAUCE_BARREL)
                .requires(Items.NETHER_WART)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy("has_hot_sauce_barrel", has(ModItems.HOT_SAUCE_BARREL))
                .save(this.output);

        // Convert capsaicin powder to capsicum crystal
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.CAPSICUM_CRYSTAL)
                .group(getItemId(ModItems.CAPSICUM_CRYSTAL))
                .requires(ModItems.CAPSAICIN_POWDER)
                .unlockedBy("has_capsaicin_powder", has(ModItems.CAPSAICIN_POWDER))
                .save(this.output, getItemId(ModItems.CAPSICUM_CRYSTAL) + "_from_capsaicin_powder");

        // Fe-Cap Nugget
        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_NUGGET, 9)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_NUGGET))
                .requires(ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT))
                .pattern("nnn")
                .pattern("nnn")
                .pattern("nnn")
                .define('n', ModItems.FERROCAPSICUMIUM_NUGGET)
                .unlockedBy("has_ferrocapsicumium_nugget", has(ModItems.FERROCAPSICUMIUM_NUGGET))
                .save(this.output, getItemId(ModItems.FERROCAPSICUMIUM_INGOT) + "_from_nuggets");

        // Fe-Cap Nugget from smelting Fe-Cap items
        var ingredientsForNugget = Ingredient.of(
                ModItems.FERROCAPSICUMIUM_SHOVEL,
                ModItems.FERROCAPSICUMIUM_AXE,
                ModItems.FERROCAPSICUMIUM_HOE);
        SimpleCookingRecipeBuilder.smelting(ingredientsForNugget, RecipeCategory.MISC, CookingBookCategory.MISC,
                        ModItems.FERROCAPSICUMIUM_NUGGET, 0.1F, 200)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output, getItemId(ModItems.FERROCAPSICUMIUM_NUGGET) + "_from_smelting");
        SimpleCookingRecipeBuilder.blasting(ingredientsForNugget, RecipeCategory.MISC, CookingBookCategory.MISC,
                        ModItems.FERROCAPSICUMIUM_NUGGET, 0.1F, 100)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output, getItemId(ModItems.FERROCAPSICUMIUM_NUGGET) + "_from_blasting");

        // Fe-Cap Ingot
        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT, 4)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT))
                .pattern("iir")
                .pattern("igc")
                .pattern("rcc")
                .define('i', Tags.Items.INGOTS_IRON)
                .define('r', Tags.Items.DUSTS_REDSTONE)
                .define('g', Tags.Items.INGOTS_GOLD)
                .define('c', ModItems.CAPSICUM_CRYSTAL)
                .unlockedBy("has_capsaicin_powder", has(ModItems.CAPSICUM_CRYSTAL))
                .save(this.output);

        // Iron Ingot from Fe-Cap Ingot
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.FERROCAPSICUMIUM_INGOT), RecipeCategory.MISC, CookingBookCategory.MISC, Items.IRON_INGOT, 0.1F, 200)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output, Constants.CBW_MOD_ID + ":iron_ingot_from_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.FERROCAPSICUMIUM_INGOT), RecipeCategory.MISC, CookingBookCategory.MISC, Items.IRON_INGOT, 0.1F, 100)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output, Constants.CBW_MOD_ID + ":iron_ingot_from_blasting");

        // Block of Fe-Cap
        ShapedRecipeBuilder.shaped(items, RecipeCategory.BUILDING_BLOCKS, ModItems.FERROCAPSICUMIUM_BLOCK)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_BLOCK))
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, ModItems.FERROCAPSICUMIUM_INGOT, 9)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_INGOT))
                .requires(ModItems.FERROCAPSICUMIUM_BLOCK)
                .unlockedBy("has_ferrocapsicumium_block", has(ModItems.FERROCAPSICUMIUM_BLOCK))
                .save(this.output, getItemId(ModItems.FERROCAPSICUMIUM_INGOT) + "_from_block");

        //* Tools *//

        // Fe-Cap Shovel
        ItemStackTemplate feCapShovel = EnchantedItemStackTemplateBuilder.builder()
                // Add enchantments to shovel
                .enchant(enchantments.getOrThrow(Enchantments.EFFICIENCY), 1)
                .enchant(enchantments.getOrThrow(Enchantments.UNBREAKING), 1)
                .build(ModItems.FERROCAPSICUMIUM_SHOVEL);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, feCapShovel)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_SHOVEL))
                .pattern("i")
                .pattern("s")
                .pattern("s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);

        // Fe-Cap Axe
        ItemStackTemplate feCapAxe = EnchantedItemStackTemplateBuilder.builder()
                // Add enchantments to axe
                .enchant(enchantments.getOrThrow(Enchantments.EFFICIENCY), 1)
                .enchant(enchantments.getOrThrow(Enchantments.UNBREAKING), 1)
                .build(ModItems.FERROCAPSICUMIUM_AXE);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, feCapAxe)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_AXE))
                .pattern("ii")
                .pattern("is")
                .pattern(" s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);

        // Fe-Cap Hoe
        ItemStackTemplate feCapHoe = EnchantedItemStackTemplateBuilder.builder()
                // Add enchantments to axe
                .enchant(enchantments.getOrThrow(Enchantments.FORTUNE), 1)
                .enchant(enchantments.getOrThrow(Enchantments.UNBREAKING), 1)
                .build(ModItems.FERROCAPSICUMIUM_HOE);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, feCapHoe)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_HOE))
                .pattern("ii")
                .pattern(" s")
                .pattern(" s")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);

        // Fe-Cap Shears
        ItemStackTemplate feCapShears = EnchantedItemStackTemplateBuilder.builder()
                // Add enchantments to shears
                .enchant(enchantments.getOrThrow(Enchantments.UNBREAKING), 1)
                .build(ModItems.FERROCAPSICUMIUM_SHEARS);
        ShapedRecipeBuilder.shaped(items, RecipeCategory.TOOLS, feCapShears)
                .group(getItemId(ModItems.FERROCAPSICUMIUM_SHEARS))
                .pattern(" i")
                .pattern("i ")
                .define('i', ModItems.FERROCAPSICUMIUM_INGOT)
                .unlockedBy("has_ferrocapsicumium_ingot", has(ModItems.FERROCAPSICUMIUM_INGOT))
                .save(this.output);
    }

    private String getItemId(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString();
    }

    public static class EnchantedItemStackTemplateBuilder {
        private final Object2IntOpenHashMap<Holder<Enchantment>> enchantments = new Object2IntOpenHashMap<>();

        public static EnchantedItemStackTemplateBuilder builder() {
            return new EnchantedItemStackTemplateBuilder();
        }

        public EnchantedItemStackTemplateBuilder enchant(Holder<Enchantment> enchantment, int level) {
            enchantments.put(enchantment, level);
            return this;
        }

        public ItemStackTemplate build(Item item) {
            var itemEnchantments = new ItemEnchantments.Mutable(ItemEnchantments.EMPTY);
            enchantments.forEach(itemEnchantments::set);
            var dataComponentPatch = DataComponentPatch.builder()
                    .set(DataComponents.ENCHANTMENTS, itemEnchantments.toImmutable())
                    .build();
            return new ItemStackTemplate(item, dataComponentPatch);
        }
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput output) {
            return new ModRecipeProvider(registryLookup, output);
        }

        @Override
        public String getName() {
            return "Recipes";
        }
    }
}
