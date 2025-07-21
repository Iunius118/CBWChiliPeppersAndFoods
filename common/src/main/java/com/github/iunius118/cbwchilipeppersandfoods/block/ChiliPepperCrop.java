package com.github.iunius118.cbwchilipeppersandfoods.block;

import com.github.iunius118.cbwchilipeppersandfoods.advancements.ModCriteriaTriggers;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import com.github.iunius118.cbwchilipeppersandfoods.loot.ModLootTables;
import com.github.iunius118.cbwchilipeppersandfoods.sounds.ModSoundEvents;
import com.github.iunius118.cbwchilipeppersandfoods.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class ChiliPepperCrop extends CropBlock {
    public static final int REPRODUCTION_AGE = 3;
    public static final int GREEN_CHILI_AGE = ChiliPepperCrop.MAX_AGE - 1;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    protected ChiliPepperCrop(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[this.getAge(state)];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CHILI_SEEDS;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        boolean isHarvestable = (state.getValue(AGE) >= ChiliPepperCrop.GREEN_CHILI_AGE);

        if (isHarvestable && stack.is(ModItemTags.C_TOOLS_SHEAR)) {
            // Use shears on harvestable crop
            if (level.isClientSide) {
                // Return success on client side
                return ItemInteractionResult.sidedSuccess(true);
            }

            // On server side
            ServerLevel serverLevel = (ServerLevel) level;

            if (player instanceof ServerPlayer serverplayer) {
                // Trigger advancement
                ModCriteriaTriggers.HARVESTED_CHILI_PEPPER_WITH_SHEARS.trigger(serverplayer);
            }

            // Harvest
            List<ItemStack> dropItems = getRandomItemsFromLootTable(stack, state, serverLevel, pos);

            for(ItemStack dropItem : dropItems) {
                // Drop harvested items
                Block.popResource(level, pos, dropItem);
            }

            level.playSound(null, pos, ModSoundEvents.CHILI_PEPPER_PICK_CHILI_PEPPERS, SoundSource.BLOCKS, 0.8F, 1.0F);

            // Update block
            if (stack.is(ModItems.FERROCAPSICUMIUM_SHEARS)) {
                // Reset crop block to age 0 when using Ferro-Capsicumium Shears
                level.setBlockAndUpdate(pos, this.getStateForAge(0));
            } else {
                // Remove crop block
                level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            }

            level.gameEvent(player, GameEvent.SHEAR, pos);
            player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));

            if (!player.getAbilities().instabuild) {
                // Wear out shears when player is not creative mode
                stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            }

            return ItemInteractionResult.sidedSuccess(false);
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    private List<ItemStack> getRandomItemsFromLootTable(ItemStack stack, BlockState state, ServerLevel serverLevel, BlockPos pos) {
        var server = serverLevel.getServer();
        var lootTable = server.reloadableRegistries().getLootTable(ModLootTables.CBW_CHILI_PEPPER_BLOCK);
        var lootParams = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, pos.getCenter())
                .withParameter(LootContextParams.TOOL, stack)
                .withParameter(LootContextParams.BLOCK_STATE, state)
                .create(LootContextParamSets.BLOCK);
        return lootTable.getRandomItems(lootParams);
    }
}
