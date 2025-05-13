package com.github.iunius118.cbwchilipeppersandfoods.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoods {
    public static final FoodProperties PICKLED_GREEN_CHILI = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.6F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 600), 1.0F)
            .alwaysEdible().fast().build();
    public static final FoodProperties CHILI_CHICKEN_SANDWICH = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.8F).build();
    public static final FoodProperties CHILI_FISH_SANDWICH = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.8F).build();
    public static final FoodProperties CHILI_MEAT_SANDWICH = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.8F).build();
    public static final FoodProperties CHILI_POTATO_SANDWICH = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties HALF_CHILI_CHICKEN_SANDWICH = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.8F).build();
    public static final FoodProperties HALF_CHILI_FISH_SANDWICH = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.8F).build();
    public static final FoodProperties HALF_CHILI_MEAT_SANDWICH = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.8F).build();
    public static final FoodProperties HALF_CHILI_POTATO_SANDWICH = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.6F).build();
    public static final FoodProperties PASTA_OIL_AND_CHILI = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6F)
            .usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties FRIED_CHILI_PEPPER = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.6F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600), 1.0F)
            .alwaysEdible().fast().build();
    public static final FoodProperties CHILI_CHOCOLATE = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.6F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 600), 1.0F)
            .alwaysEdible().fast().build();
    public static final FoodProperties CHILI_CHOCOLATE_CHICKEN = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.8F).build();
}
