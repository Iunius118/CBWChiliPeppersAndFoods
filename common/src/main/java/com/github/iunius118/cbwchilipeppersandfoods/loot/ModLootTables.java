package com.github.iunius118.cbwchilipeppersandfoods.loot;

import com.github.iunius118.cbwchilipeppersandfoods.CommonClass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static final ResourceKey<LootTable> CBW_CHILI_PEPPER_BLOCK
            = ResourceKey.create(Registries.LOOT_TABLE, CommonClass.modCBWLocation("blocks/chili_pepper"));

    public static final ResourceKey<LootTable> VANILLA_SHORT_GRASS_BLOCK
            = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("blocks/short_grass"));
}
