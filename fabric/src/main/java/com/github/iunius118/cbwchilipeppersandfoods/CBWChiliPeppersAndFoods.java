package com.github.iunius118.cbwchilipeppersandfoods;

import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.loot.ModLootTables;
import com.github.iunius118.cbwchilipeppersandfoods.registry.FabricModRegistries;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class CBWChiliPeppersAndFoods implements ModInitializer {

    @Override
    public void onInitialize() {
        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        // Register mod game objects
        FabricModRegistries.registerGameObjects();
        // Register compostable items
        ComposterBlock.COMPOSTABLES.putAll(ModItems.COMPOSTABLES);
        // Register loot table event
        LootTableEvents.MODIFY.register(this::onLootTableLoad);
    }

    private void onLootTableLoad(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (source.isBuiltin() && ModLootTables.VANILLA_SHORT_GRASS_BLOCK.equals(key)) {
            // Add chili pepper loot pool to short grass
            Holder.Reference<Enchantment> fortune = VanillaRegistries.createLookup()
                    .lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
            var lootPool = LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.CURVED_CHILI)
                            .when(LootItemRandomChanceCondition.randomChance(0.125F))
                            .apply(ApplyBonusCount.addUniformBonusCount(fortune, 1)))
                    .build();
            tableBuilder.pool(lootPool);
        }
    }
}
