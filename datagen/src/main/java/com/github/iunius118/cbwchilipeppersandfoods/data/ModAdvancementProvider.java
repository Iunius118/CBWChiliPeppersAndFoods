package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.HarvestedChiliPepperWithShearsTrigger;
import com.github.iunius118.cbwchilipeppersandfoods.advancements.ThrewHotSauceTrigger;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
            // Main root
            AdvancementHolder root = Advancement.Builder.recipeAdvancement()
                    .display(getItem(Constants.Items.ICON_MAIN),
                            Component.translatable("advancements.%s.main.root.title".formatted(Constants.CBW_MOD_ID)),
                            Component.translatable("advancements.%s.main.root.description".formatted(Constants.CBW_MOD_ID)),
                            ResourceLocation.withDefaultNamespace("textures/block/orange_concrete_powder.png"),
                            AdvancementType.TASK, false, false, false)
                    .addCriterion("has_curved_chili", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CURVED_CHILI))
                    .save(consumer, "%s:main/root".formatted(Constants.CBW_MOD_ID));

            // 1. Hot Topic
            AdvancementHolder curvedChili = addItemAdvancement(root, ModItems.CURVED_CHILI, AdvancementType.TASK,
                    new Item[]{ModItems.CURVED_CHILI}, "main", consumer);

            // 1-1. Be Gentle
            String harvestedChiliPepperWithShearsName = "harvested_chili_pepper_with_shears";
            AdvancementHolder harvestedChiliPepperWithShears = Advancement.Builder.recipeAdvancement()
                    .parent(curvedChili)
                    .display(Items.SHEARS,
                            Component.translatable("advancements.%s.%s.%s.title".formatted(Constants.CBW_MOD_ID, "main", harvestedChiliPepperWithShearsName)),
                            Component.translatable("advancements.%s.%s.%s.description".formatted(Constants.CBW_MOD_ID, "main", harvestedChiliPepperWithShearsName)),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion(harvestedChiliPepperWithShearsName, HarvestedChiliPepperWithShearsTrigger.TriggerInstance.harvestedChiliPepperWithShears())
                    .save(consumer, "%s:%s/%s".formatted(Constants.CBW_MOD_ID, "main", harvestedChiliPepperWithShearsName));

            // 1-2. Let's Go Halves
            Item[] halfSandwiches = {
                    ModItems.HALF_CHILI_CHICKEN_SANDWICH,
                    ModItems.HALF_CHILI_FISH_SANDWICH,
                    ModItems.HALF_CHILI_MEAT_SANDWICH,
                    ModItems.HALF_CHILI_POTATO_SANDWICH};
            AdvancementHolder halfSandwich = addItemAdvancement(curvedChili, ModItems.HALF_CHILI_POTATO_SANDWICH, AdvancementType.TASK,
                    "half_sandwich", halfSandwiches, "main", consumer);

            // 1-3. Non-Lethal?
            String threwHotSauceName = "threw_hot_sauce";
            AdvancementHolder threwHotSauce = Advancement.Builder.recipeAdvancement()
                    .parent(curvedChili)
                    .display(ModItems.HOT_SAUCE,
                            Component.translatable("advancements.%s.%s.%s.title".formatted(Constants.CBW_MOD_ID, "main", threwHotSauceName)),
                            Component.translatable("advancements.%s.%s.%s.description".formatted(Constants.CBW_MOD_ID, "main", threwHotSauceName)),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("threw_hot_sauce", ThrewHotSauceTrigger.TriggerInstance.threwHotSauce(ModItems.HOT_SAUCE))
                    .addCriterion("threw_green_hot_sauce", ThrewHotSauceTrigger.TriggerInstance.threwHotSauce(ModItems.GREEN_HOT_SAUCE))
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .save(consumer, "%s:%s/%s".formatted(Constants.CBW_MOD_ID, "main", threwHotSauceName));

            // 1-4. Corrosive, Toxic, Irritant
            AdvancementHolder capsicumCrystal = addItemAdvancement(curvedChili, ModItems.CAPSICUM_CRYSTAL, AdvancementType.TASK,
                    new Item[]{ModItems.CAPSICUM_CRYSTAL}, "main", consumer);

            // 1-4-1. Fer-Ro-Cap-Sic ... What?
            AdvancementHolder ferrocapsicumiumIngot = addItemAdvancement(capsicumCrystal, ModItems.FERROCAPSICUMIUM_INGOT, AdvancementType.TASK,
                    new Item[]{ModItems.FERROCAPSICUMIUM_INGOT}, "main", consumer);
        }

        private AdvancementHolder addItemAdvancement(AdvancementHolder parent, Item icon, AdvancementType advancementType, String name,
                                                     Item[] requirements, String tab, Consumer<AdvancementHolder> consumer) {
            Advancement.Builder builder = Advancement.Builder.recipeAdvancement()
                    .parent(parent)
                    .display(icon,
                            Component.translatable("advancements.%s.%s.%s.title".formatted(Constants.CBW_MOD_ID, tab, name)),
                            Component.translatable("advancements.%s.%s.%s.description".formatted(Constants.CBW_MOD_ID, tab, name)),
                            null,
                            advancementType, true, true, false)
                    .requirements(AdvancementRequirements.Strategy.OR);

            for (Item item : requirements) {
                String itemName = getItemId(item).getPath();
                builder.addCriterion("has_" + itemName,  InventoryChangeTrigger.TriggerInstance.hasItems(item));
            }

            return builder.save(consumer, "%s:%s/%s".formatted(Constants.CBW_MOD_ID, tab, name));
        }

        private AdvancementHolder addItemAdvancement(AdvancementHolder parent, Item icon, AdvancementType advancementType,
                                                     Item[] requirements, String tab, Consumer<AdvancementHolder> consumer) {
            return addItemAdvancement(parent, icon, advancementType, getItemId(requirements[0]).getPath(), requirements, tab, consumer);
        }

        private Item getItem(ResourceLocation id) {
            return BuiltInRegistries.ITEM.get(id);
        }

        private ResourceLocation getItemId(Item item) {
            return BuiltInRegistries.ITEM.getKey(item);
        }
    }
}
