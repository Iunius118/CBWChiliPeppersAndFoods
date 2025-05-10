package com.github.iunius118.cbwchilipeppersandfoods;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class CBWChiliPeppersAndFoods {

    public CBWChiliPeppersAndFoods(FMLJavaModLoadingContext context) {
        final IEventBus modEventBus = context.getModEventBus();

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();

    }
}
