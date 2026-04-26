package com.github.iunius118.cbwchilipeppersandfoods.mixin;

import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.TypedInstance;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TypedInstance.class)
public interface TypedInstanceMixin<T> {
	@Shadow
	Holder<T> typeHolder();

	@Inject(method = "is(Ljava/lang/Object;)Z", at = @At("HEAD"), cancellable = true)
	private void onIs(T rawType, CallbackInfoReturnable<Boolean> cir) {
		// Intercept item comparison logic so that Fe-Cap shears function as vanilla shears
		if (rawType == Items.SHEARS && typeHolder().value() == ModItems.FERROCAPSICUMIUM_SHEARS) {
			cir.setReturnValue(true);
		}
	}
}
