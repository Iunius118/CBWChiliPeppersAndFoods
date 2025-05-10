package com.github.iunius118.cbwchilipeppersandfoods;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CBWChiliPeppersAndFoods {

    public CBWChiliPeppersAndFoods(IEventBus modEventBus, ModContainer modContainer) {
        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
    }
}
