package com.github.iunius118.cbwchilipeppersandfoods;

import net.fabricmc.api.ModInitializer;

public class CBWChiliPeppersAndFoods implements ModInitializer {

    @Override
    public void onInitialize() {
        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
    }
}
