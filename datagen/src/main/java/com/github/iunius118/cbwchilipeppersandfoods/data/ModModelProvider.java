package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelProvider extends ModelProvider {

	public ModModelProvider(PackOutput output) {
		super(output, Constants.CBW_MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		generateBlockModels(blockModels);
		generateItemModels(itemModels);
	}

	private void generateBlockModels(BlockModelGenerators blockModels) {
		var output = blockModels.blockStateOutput;

		blockModels.createCropBlock(ModBlocks.CHILI_PEPPER, BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
		blockModels.createTrivialBlock(ModBlocks.HOT_SAUCE_BARREL, TexturedModel.CUBE_TOP_BOTTOM);
		blockModels.createCrossBlock(ModBlocks.CURVED_CHILI_STRING, BlockModelGenerators.PlantType.NOT_TINTED);
		blockModels.createTrivialCube(ModBlocks.FERROCAPSICUMIUM_BLOCK);
	}

	private void generateItemModels(ItemModelGenerators itemModels) {
		var output = itemModels.itemModelOutput;

		// Plants
		// Item model of chili seeds is generated during block model generation
		itemModels.generateFlatItem(ModItems.CURVED_GREEN_CHILI, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CURVED_CHILI, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CURVED_CHILI_STRING, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.DRIED_CURVED_CHILI, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CURVED_CHILI_SACK, ModelTemplates.FLAT_ITEM);

		// Fuel
		itemModels.generateFlatItem(ModItems.CHILI_BIOFUEL, ModelTemplates.FLAT_ITEM);

		// Foods
		itemModels.generateFlatItem(ModItems.HOT_SAUCE, ModelTemplates.FLAT_ITEM);
		// Item model of hot sauce barrel is generated during block model generation
		itemModels.generateFlatItem(ModItems.GREEN_HOT_SAUCE, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.PICKLED_GREEN_CHILI, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_CHICKEN_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_FISH_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_MEAT_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_POTATO_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.HALF_CHILI_CHICKEN_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.HALF_CHILI_FISH_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.HALF_CHILI_MEAT_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.HALF_CHILI_POTATO_SANDWICH, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.PASTA_OIL_AND_CHILI, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.FRIED_CHILI_PEPPER, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_CHOCOLATE, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CHILI_CHOCOLATE_CHICKEN, ModelTemplates.FLAT_ITEM);

		// Materials
		itemModels.generateFlatItem(ModItems.CAPSICUM_CRYSTAL, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.CAPSICUM_CRYSTAL_BOTTLE, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_NUGGET, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_INGOT, ModelTemplates.FLAT_ITEM);
		addBlockItemModel(output, ModItems.FERROCAPSICUMIUM_BLOCK, "");

		// Tools
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModels.generateFlatItem(ModItems.FERROCAPSICUMIUM_SHEARS, ModelTemplates.FLAT_ITEM);

		// Misc.
		itemModels.generateFlatItem(ModItems.CAPSAICIN_POWDER, ModelTemplates.FLAT_ITEM);

		// Creative mode tab
		itemModels.generateFlatItem(ModItems.ICON_MAIN, ModelTemplates.FLAT_ITEM);
	}

	private void addBlockItemModel(ItemModelOutput output, Item item, String suffix) {
		if (item instanceof BlockItem blockItem) {
			var model = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(blockItem.getBlock(), suffix));
			output.accept(item, model);
		}
	}
}
