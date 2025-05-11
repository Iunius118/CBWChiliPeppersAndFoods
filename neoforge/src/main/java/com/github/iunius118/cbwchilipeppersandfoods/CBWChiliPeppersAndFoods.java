package com.github.iunius118.cbwchilipeppersandfoods;

import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.loot.ModLootTables;
import com.github.iunius118.cbwchilipeppersandfoods.registry.ModRegistries;
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
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;

@Mod(Constants.MOD_ID)
public class CBWChiliPeppersAndFoods {

    public CBWChiliPeppersAndFoods(IEventBus modEventBus, ModContainer modContainer) {
        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

        // Register mod event listeners
        ModRegistries.registerGameObjects(modEventBus);
        modEventBus.addListener(this::onCommonSetup);

        // Register NeoForge event listeners
        NeoForge.EVENT_BUS.addListener(this::onLootTableLoad);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // Register compostable items
        CommonClass.registerCompostableItems();
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
}
