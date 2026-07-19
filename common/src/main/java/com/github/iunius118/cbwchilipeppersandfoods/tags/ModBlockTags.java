package com.github.iunius118.cbwchilipeppersandfoods.tags;

import com.github.iunius118.cbwchilipeppersandfoods.CommonClass;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> C_STORAGE_BLOCKS_CHILI = makeCTag("storage_blocks/chili");

    public static final TagKey<Block> STORAGE_BLOCKS_FERROCAPSICUMIUM = makeCBWTag("storage_blocks/ferrocapsicumium");

    private static TagKey<Block> makeCBWTag(String id) {
        return TagKey.create(Registries.BLOCK, CommonClass.modCBWLocation(id));
    }

    private static TagKey<Block> makeCTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
