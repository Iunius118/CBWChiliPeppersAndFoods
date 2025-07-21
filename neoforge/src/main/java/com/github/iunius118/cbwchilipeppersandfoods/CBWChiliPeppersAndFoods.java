package com.github.iunius118.cbwchilipeppersandfoods;

import com.github.iunius118.cbwchilipeppersandfoods.data.*;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.loot.ModLootTables;
import com.github.iunius118.cbwchilipeppersandfoods.registry.NeoForgeModRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@Mod(Constants.MOD_ID)
public class CBWChiliPeppersAndFoods {

    public CBWChiliPeppersAndFoods(IEventBus modEventBus, ModContainer modContainer) {
        // Use NeoForge to bootstrap the Common mod.
        //Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        // Register mod event listeners
        NeoForgeModRegistries.registerGameObjects(modEventBus);
        modEventBus.addListener(this::gatherData);

        // Register NeoForge event listeners
        NeoForge.EVENT_BUS.addListener(this::onLootTableLoad);
    }

    private void onLootTableLoad(final LootTableLoadEvent event) {
        // Add chili pepper loot pool to short grass
        if (ModLootTables.VANILLA_SHORT_GRASS_BLOCK.location().equals(event.getName())) {
            Holder.Reference<Enchantment> fortune = VanillaRegistries.createLookup()
                    .lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
            LootPool pool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.CURVED_CHILI)
                            .when(LootItemRandomChanceCondition.randomChance(0.125F))
                            .apply(ApplyBonusCount.addUniformBonusCount(fortune, 1)))
                    .build();
            event.getTable().addPool(pool);
        }
    }

    private void gatherData(final GatherDataEvent event) {
        var dataGenerator = event.getGenerator();
        var packOutput = dataGenerator.getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();
        var blockTagsProvider = new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);

        // Server
        final boolean includesServer = event.includeServer();
        dataGenerator.addProvider(includesServer, blockTagsProvider);
        dataGenerator.addProvider(includesServer, new ModItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        dataGenerator.addProvider(includesServer, new ModLootTableProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(includesServer, new ModRecipeProvider(packOutput, lookupProvider));
        dataGenerator.addProvider(includesServer, new ModAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        dataGenerator.addProvider(includesServer, new ModDataMapProvider(packOutput, lookupProvider));

        // Client
        final boolean includesClient = event.includeClient();
        dataGenerator.addProvider(includesClient, new ModLanguageProvider(packOutput));
        dataGenerator.addProvider(includesClient, new ModBlockStateProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(includesClient, new ModItemModelProvider(packOutput, existingFileHelper));
    }
}
