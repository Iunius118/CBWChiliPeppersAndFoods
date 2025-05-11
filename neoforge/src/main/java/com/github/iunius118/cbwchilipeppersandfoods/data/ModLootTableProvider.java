package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
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
        }

        private LootTable.Builder createChiliPepperCropDrops() {
            Block block = ModBlocks.CHILI_PEPPER;
            Item curvedChili = ModItems.CURVED_CHILI;
            Item chiliSeeds = ModItems.CHILI_SEEDS;
            Holder.Reference<Enchantment> fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
            LootItemCondition.Builder conditionBuilder = LootItemBlockStatePropertyCondition
                    .hasBlockStateProperties(ModBlocks.CHILI_PEPPER)
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
            LootTable.Builder lootTableBuilder = LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(curvedChili).when(conditionBuilder).otherwise(LootItem.lootTableItem(chiliSeeds))))
                    .withPool(LootPool.lootPool().when(conditionBuilder).add(LootItem.lootTableItem(curvedChili).apply(ApplyBonusCount.addBonusBinomialDistributionCount(fortune, 0.5714286F, 2))));
            return this.applyExplosionDecay(block, lootTableBuilder);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return List.of(ModBlocks.CHILI_PEPPER, ModBlocks.CURVED_CHILI_STRING, ModBlocks.HOT_SAUCE_BARREL);
        }
    }
}
