package com.github.iunius118.cbwchilipeppersandfoods.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class HotSauceItem extends Item {

    public HotSauceItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        var level = player.level();

        if (!level.isClientSide && target.isAffectedByPotions()) {
            // On server side
            // Add mob effects to the target entity
            addMobEffects(player, target);
            // Play sound effect
            level.playSound(null, target.blockPosition(), SoundEvents.PLAYER_ATTACK_NODAMAGE, player.getSoundSource());

            if (!player.getAbilities().instabuild) {
                // In survival mode, consume the hot sauce item
                stack.shrink(1);

                ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);
                // Return an empty glass bottle to the player
                if (!player.getInventory().add(glassBottle)) {
                    // If the player inventory is full, drop the glass bottle on the ground
                    player.drop(glassBottle, false);
                }
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public void addMobEffects(Player player, LivingEntity target) {
        // Add Slowdown IV and Blindness effects (duration: 2 seconds) to the target entity
        int duration = 40;
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 3), player);
        target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration, 0), player);
    }
}
