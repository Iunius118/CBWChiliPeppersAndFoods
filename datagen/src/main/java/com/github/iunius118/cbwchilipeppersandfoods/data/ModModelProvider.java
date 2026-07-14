package com.github.iunius118.cbwchilipeppersandfoods.data;

import com.github.iunius118.cbwchilipeppersandfoods.CommonClass;
import com.github.iunius118.cbwchilipeppersandfoods.Constants;
import com.github.iunius118.cbwchilipeppersandfoods.block.ModBlocks;
import com.github.iunius118.cbwchilipeppersandfoods.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

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

		Identifier chiliPepperPotModel = generateChiliPepperPotModel(blockModels);
		createPottedChiliPepperModel(blockModels, ModBlocks.POTTED_CHILI_PEPPER_FLOWERING, chiliPepperPotModel);
		createPottedChiliPepperModel(blockModels, ModBlocks.POTTED_CHILI_PEPPER_GREEN, chiliPepperPotModel);
		createPottedChiliPepperModel(blockModels, ModBlocks.POTTED_CHILI_PEPPER_RED, chiliPepperPotModel);
	}

	private Identifier generateChiliPepperPotModel(BlockModelGenerators blockModels) {
		Identifier modelLocation = CommonClass.modCBWLocation("block/chili_pepper_pot");
		TextureSlot pot = TextureSlot.create("pot");
		TextureSlot dirt = TextureSlot.create("dirt");
		TextureSlot plant = TextureSlot.create("plant");
		var textureMapping = new TextureMapping()
				.put(TextureSlot.PARTICLE, new Material(modelLocation))
				.put(pot, new Material(modelLocation))
				.put(dirt, new Material(ModelLocationUtils.getModelLocation(Blocks.DIRT)));
		Identifier model = ExtendedModelTemplateBuilder.builder()
				.ambientOcclusion(false)
				.requiredTextureSlot(TextureSlot.PARTICLE)
				.requiredTextureSlot(pot)
				.requiredTextureSlot(dirt)
				.element(builder -> builder
						.from(4, 3, 4)
						.to(5, 6, 12)
						.face(Direction.DOWN,  f -> f.texture(pot).uvs( 4,  3,  5, 11))
						.face(Direction.UP,    f -> f.texture(pot).uvs( 4,  3,  5, 11))
						.face(Direction.NORTH, f -> f.texture(pot).uvs(11, 10, 12, 13))
						.face(Direction.SOUTH, f -> f.texture(pot).uvs( 4, 10,  5, 13))
						.face(Direction.WEST,  f -> f.texture(pot).uvs( 4, 10, 12, 13))
						.face(Direction.EAST,  f -> f.texture(pot).uvs( 4, 10, 12, 13))
				)
				.element(builder -> builder
						.from(11, 3, 4)
						.to(12, 6, 12)
						.face(Direction.DOWN,  f -> f.texture(pot).uvs(11,  3, 12, 11))
						.face(Direction.UP,    f -> f.texture(pot).uvs(11,  3, 12, 11))
						.face(Direction.NORTH, f -> f.texture(pot).uvs( 4, 10,  5, 13))
						.face(Direction.SOUTH, f -> f.texture(pot).uvs(11, 10, 12, 13))
						.face(Direction.WEST,  f -> f.texture(pot).uvs( 4, 10, 12, 13))
						.face(Direction.EAST,  f -> f.texture(pot).uvs( 4, 10, 12, 13))
				)
				.element(builder -> builder
						.from(5, 3, 4)
						.to(11, 6, 5)
						.face(Direction.DOWN,  f -> f.texture(pot).uvs( 5, 10, 11, 11))
						.face(Direction.UP,    f -> f.texture(pot).uvs( 5,  3, 11,  4))
						.face(Direction.NORTH, f -> f.texture(pot).uvs( 5, 10, 11, 13))
						.face(Direction.SOUTH, f -> f.texture(pot).uvs( 5, 10, 11, 13))
				)
				.element(builder -> builder
						.from(5, 3, 11)
						.to(11, 6, 12)
						.face(Direction.DOWN,  f -> f.texture(pot).uvs( 5,  3, 11,  4))
						.face(Direction.UP,    f -> f.texture(pot).uvs( 5, 10, 11, 11))
						.face(Direction.NORTH, f -> f.texture(pot).uvs( 5, 10, 11, 13))
						.face(Direction.SOUTH, f -> f.texture(pot).uvs( 5, 10, 11, 13))
				)
				.element(builder -> builder
						.from(5, 0, 5)
						.to(11, 4, 11)
						.face(Direction.DOWN,  f -> f.texture(pot ).uvs( 5, 10, 11, 16).cullface(Direction.DOWN))
						.face(Direction.UP,    f -> f.texture(dirt).uvs( 5,  5, 11, 11))
						.face(Direction.NORTH, f -> f.texture(pot ).uvs( 5, 12, 11, 16))
						.face(Direction.SOUTH, f -> f.texture(pot ).uvs( 5, 12, 11, 16))
						.face(Direction.WEST,  f -> f.texture(pot ).uvs( 5, 12, 11, 16))
						.face(Direction.EAST,  f -> f.texture(pot ).uvs( 5, 12, 11, 16))
				)
				.element(builder -> builder
						.from(2.6f, 4, 8)
						.to(13.4f, 16, 8)
						.rotation(r -> r.origin(8, 8, 8).singleAxis(Direction.Axis.Y, 45).rescale(true))
						.shade(false)
						.face(Direction.NORTH, f -> f.texture(plant).uvs(0, 0, 16, 16))
						.face(Direction.SOUTH, f -> f.texture(plant).uvs(0, 0, 16, 16))
				)
				.element(builder -> builder
						.from(8, 4, 2.6f)
						.to(8, 16, 13.4f)
						.rotation(r -> r.origin(8, 8, 8).singleAxis(Direction.Axis.Y, 45).rescale(true))
						.shade(false)
						.face(Direction.WEST, f -> f.texture(plant).uvs(0, 0, 16, 16))
						.face(Direction.EAST, f -> f.texture(plant).uvs(0, 0, 16, 16))
				)
				.build().create(modelLocation, textureMapping, blockModels.modelOutput);
		return model;
	}

	private void createPottedChiliPepperModel(BlockModelGenerators blockModels, Block block, Identifier potModel) {
		Identifier modelLocation = ModelLocationUtils.getModelLocation(block);
		TextureSlot plant = TextureSlot.create("plant");
		var textureMapping = new TextureMapping().put(plant, new Material(modelLocation));
		Identifier model = ExtendedModelTemplateBuilder.builder()
				.parent(potModel)
				.requiredTextureSlot(plant)
				.build().create(modelLocation, textureMapping, blockModels.modelOutput);
		var multiVariant = BlockModelGenerators.plainVariant(model);
		blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, multiVariant));
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
		itemModels.generateFlatItem(ModItems.POTTED_CHILI_PEPPER_FLOWERING, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.POTTED_CHILI_PEPPER_GREEN, ModelTemplates.FLAT_ITEM);
		itemModels.generateFlatItem(ModItems.POTTED_CHILI_PEPPER_RED, ModelTemplates.FLAT_ITEM);

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
