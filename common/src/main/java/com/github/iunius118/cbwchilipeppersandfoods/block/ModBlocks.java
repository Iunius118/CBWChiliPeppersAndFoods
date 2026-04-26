package com.github.iunius118.cbwchilipeppersandfoods.block;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block CHILI_PEPPER = new ChiliPepperCrop(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, Constants.Blocks.CHILI_PEPPER))
            .mapColor(MapColor.PLANT)
            .noCollision()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY));
    public static final Block CURVED_CHILI_STRING = new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, Constants.Blocks.CURVED_CHILI_STRING))
            .mapColor(MapColor.PLANT)
            .noCollision()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY));
    public static final Block HOT_SAUCE_BARREL = new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, Constants.Blocks.HOT_SAUCE_BARREL))
            .mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD)
            .ignitedByLava());
    public static final Block FERROCAPSICUMIUM_BLOCK = new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, Constants.Blocks.FERROCAPSICUMIUM_BLOCK))
            .mapColor(MapColor.METAL)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.METAL));
}
