package com.github.iunius118.cbwchilipeppersandfoods.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {
    public static final Block CHILI_PEPPER = new ChiliPepperCrop(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .randomTicks()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY));
    public static final Block CURVED_CHILI_STRING = new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT)
            .noCollission()
            .instabreak()
            .sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY));
    public static final Block HOT_SAUCE_BARREL = new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.5F)
            .sound(SoundType.WOOD)
            .ignitedByLava());
    public static final Block FERROCAPSICUMIUM_BLOCK = new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.METAL)
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops()
            .strength(5.0F, 6.0F)
            .sound(SoundType.METAL));
}
