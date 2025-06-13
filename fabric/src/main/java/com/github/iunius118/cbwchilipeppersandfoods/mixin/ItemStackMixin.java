package com.github.iunius118.cbwchilipeppersandfoods.mixin;

import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    public abstract Item getItem();

    @Inject(method = "is(Lnet/minecraft/world/item/Item;)Z", at = @At("HEAD"), cancellable = true)
    private void onIs(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item == Items.SHEARS && getItem() == ModItems.FERROCAPSICUMIUM_SHEARS) {
            cir.setReturnValue(true);
        }
    }
}
