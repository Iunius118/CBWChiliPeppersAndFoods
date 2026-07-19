package com.github.iunius118.cbwchilipeppersandfoods;

import com.github.iunius118.cbwchilipeppersandfoods.data.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(Constants.MOD_ID)
public class CBWChiliPeppersAndFoods {
    public static IEventBus modEventBus;

    public CBWChiliPeppersAndFoods(IEventBus modEventBus, ModContainer modContainer) {
        CBWChiliPeppersAndFoods.modEventBus = modEventBus;

        // Use NeoForge to bootstrap the Common mod.
        //Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        // Register mod event listeners
        modEventBus.addListener(this::gatherData);
    }

    private void gatherData(final GatherDataEvent event) {
        var dataGenerator = event.getGenerator();
        var packOutput = dataGenerator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();

        // Server
        final boolean includesServer = event.includeServer();
        var blockTagsProvider = new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        dataGenerator.addProvider(includesServer, blockTagsProvider);
        dataGenerator.addProvider(includesServer,
                new ModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(),
                        existingFileHelper));
        dataGenerator.addProvider(includesServer, new ModLootTableProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(includesServer, new ModRecipeProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(includesServer,
                new ModAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        dataGenerator.addProvider(includesServer, new ModDataMapProvider(packOutput, lookupProvider));

        // Client
        final boolean includesClient = event.includeClient();
        dataGenerator.addProvider(includesClient, new ModLanguageProvider(packOutput));
        dataGenerator.addProvider(includesClient, new ModBlockStateProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(includesClient, new ModItemModelProvider(packOutput, existingFileHelper));
    }
}
