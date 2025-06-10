package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.block.ChiliPepperCrop;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Set.of(), VanillaLootTableProvider.create(packOutput, lookupProvider).getTables(), lookupProvider);
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return ImmutableList.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        );
    }

    private static class ModBlockLootTables extends BlockLootSubProvider {

        public ModBlockLootTables(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            add(ModBlocks.CHILI_PEPPER, createChiliPepperCropDrops());
            add(ModBlocks.CURVED_CHILI_STRING, this.createSingleItemTableWithSilkTouch(ModBlocks.CURVED_CHILI_STRING, ModItems.DRIED_CURVED_CHILI, ConstantValue.exactly(9.0F)));
            add(ModBlocks.HOT_SAUCE_BARREL, this.createSingleItemTable(ModBlocks.HOT_SAUCE_BARREL));
            add(ModBlocks.FERROCAPSICUMIUM_BLOCK, this.createSingleItemTable(ModBlocks.FERROCAPSICUMIUM_BLOCK));
        }

        private LootTable.Builder createChiliPepperCropDrops() {
            // Hack to use RangedMatcher to specify block state of ChiliPepperCrop.AGE
            var chiliSeedCondition = new LootItemBlockStatePropertyCondition.Builder(ModBlocks.CHILI_PEPPER) {
                @Override
                public LootItemCondition build() {
                    var key = ResourceKey.create(Registries.BLOCK, BuiltInRegistries.BLOCK.getKey(ModBlocks.CHILI_PEPPER));
                    var blockHolder = BuiltInRegistries.BLOCK.getHolderOrThrow(key);
                    return new LootItemBlockStatePropertyCondition(blockHolder, getChiliPepperOutOfHarvestAgePredicate());
                }
            };
            var greenChiliCondition = new LootItemBlockStatePropertyCondition.Builder(ModBlocks.CHILI_PEPPER)
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliPepperCrop.AGE, ChiliPepperCrop.GREEN_CHILI_AGE));
            var curvedChiliCondition = new LootItemBlockStatePropertyCondition.Builder(ModBlocks.CHILI_PEPPER)
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliPepperCrop.AGE, ChiliPepperCrop.MAX_AGE));

            Holder.Reference<Enchantment> fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);

            // Add drops for each age of chili pepper crop
            var lootTableBuilder = LootTable.lootTable()
                    .withPool(LootPool.lootPool().when(chiliSeedCondition).add(LootItem.lootTableItem(ModItems.CHILI_SEEDS)))
                    .withPool(LootPool.lootPool().when(greenChiliCondition).add(LootItem.lootTableItem(ModItems.CURVED_GREEN_CHILI)))
                    .withPool(LootPool.lootPool().when(curvedChiliCondition).add(LootItem.lootTableItem(ModItems.CURVED_CHILI)))
                    // Add bonus for fortune enchantment
                    .withPool(LootPool.lootPool().when(greenChiliCondition).add(LootItem.lootTableItem(ModItems.CURVED_GREEN_CHILI)
                            .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 0.5714286F, 2))))
                    .withPool(LootPool.lootPool().when(curvedChiliCondition).add(LootItem.lootTableItem(ModItems.CURVED_CHILI)
                            .apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 0.5714286F, 2))));
            return this.applyExplosionDecay(ModBlocks.CHILI_PEPPER, lootTableBuilder);
        }

        private Optional<StatePropertiesPredicate> getChiliPepperOutOfHarvestAgePredicate() {
            RegistryOps<JsonElement> serializationContext = registries.createSerializationContext(JsonOps.INSTANCE);

            var rangeJson = new JsonObject();
            rangeJson.addProperty("min", "0");
            rangeJson.addProperty("max", String.valueOf(ChiliPepperCrop.GREEN_CHILI_AGE - 1));

            var ageJson = new JsonObject();
            ageJson.add(ChiliPepperCrop.AGE.getName(), rangeJson);

            return StatePropertiesPredicate.CODEC.parse(serializationContext, ageJson).result();
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return List.of(
                    ModBlocks.CHILI_PEPPER,
                    ModBlocks.CURVED_CHILI_STRING,
                    ModBlocks.HOT_SAUCE_BARREL,
                    ModBlocks.FERROCAPSICUMIUM_BLOCK
            );
        }
    }
}
