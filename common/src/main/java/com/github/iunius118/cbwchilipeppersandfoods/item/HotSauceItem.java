package com.github.iunius118.cbwchilipeppersandfoods.item;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public class HotSauceItem extends Item implements ProjectileItem {
    // Duration of the effects in ticks (2 seconds)
    public static final int HOT_SAUCE_DURATION = 40;
    // Duration of the effects in ticks (10 seconds)
    public static final int CAPSICUM_CRYSTAL_DURATION = 200;
    // Splash potion colors
    public static final int RED_HOT_SAUCE_COLOR = 0xFFCF0408;
    public static final int GREEN_HOT_SAUCE_COLOR = 0xFFAAC60E;
    public static final int CAPSICUM_CRYSTAL_COLOR = 0xFFFFF0F0;

    public final int color;
    public final int effectDuration;

    public HotSauceItem(Properties properties, int effectDuration, int color) {
        super(properties);
        this.color = color;
        this.effectDuration = effectDuration;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        if (!level.isClientSide) {
            // On server side
            // Create and throw a splash potion with effects
            var thrownPotion = new ThrownPotion(level, player);
            thrownPotion.setItem(getSplashPotion());
            thrownPotion.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.5F, 1.0F);
            level.addFreshEntity(thrownPotion);

            // Play sound effect
            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.SPLASH_POTION_THROW, SoundSource.PLAYERS,
                    0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        }

        stack.consume(1, player);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    public ItemStack getSplashPotion() {
        // Create a splash potion item with effects
        ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
        var potionContents = new PotionContents(Optional.empty(), Optional.of(color), getMobEffects());
        splashPotion.set(DataComponents.POTION_CONTENTS, potionContents);
        return splashPotion;
    }

    public List<MobEffectInstance> getMobEffects() {
        // Add Slowdown IV and Blindness effects
        return List.of(
                new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectDuration, 3),
                new MobEffectInstance(MobEffects.BLINDNESS, effectDuration, 0)
        );
    }

    /* ProjectileItem */

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        ThrownPotion thrownpotion = new ThrownPotion(level, pos.x(), pos.y(), pos.z());
        thrownpotion.setItem(getSplashPotion());
        return thrownpotion;
    }

    @Override
    public ProjectileItem.DispenseConfig createDispenseConfig() {
        return ProjectileItem.DispenseConfig.builder()
                .uncertainty(ProjectileItem.DispenseConfig.DEFAULT.uncertainty() * 0.5F)
                .power(ProjectileItem.DispenseConfig.DEFAULT.power() * 1.25F)
                .build();
    }
}
