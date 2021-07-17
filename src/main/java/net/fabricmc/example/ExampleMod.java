package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.items.Horn;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {

	// Sound Instances
	public static final Identifier HORN_ID = new Identifier("modid:horn");
	public static SoundEvent HORN_EVENT = new SoundEvent(HORN_ID);

	// Creative Tabs
	public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));
	public static final ItemGroup CUSTOM_TAB = FabricItemGroupBuilder.build(new Identifier("modid", "custom_tab"), () -> new ItemStack(FABRIC_ITEM));

	// Item Instances
	public static final Item HORN = new Horn(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB).maxCount(1));
	public static final Item SUS_ITEM = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));
	public static final Item TIN_INGOT = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));
	public static final Item RAW_TIN = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));
	public static final Item STEEL_INGOT = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));
	public static final Item IRON_TIN_ALLOY = new Item(new FabricItemSettings().group(ExampleMod.CUSTOM_TAB));

	// Block Instances
	public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f)); //TO-DO: Tweak hardness and resistance values

	@Override
	public void onInitialize() {
		// Item Registers
		Registry.register(Registry.ITEM, new Identifier("modid", "fabric_item"), FABRIC_ITEM);
		Registry.register(Registry.ITEM, new Identifier("modid", "horn"), HORN);
		Registry.register(Registry.ITEM, new Identifier("modid", "sus_item"), SUS_ITEM);
		Registry.register(Registry.ITEM, new Identifier("modid", "tin_ingot"), TIN_INGOT);
		Registry.register(Registry.ITEM, new Identifier("modid", "raw_tin"), RAW_TIN);
		Registry.register(Registry.ITEM, new Identifier("modid", "steel_ingot"), STEEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("modid", "iron_tin_alloy"), IRON_TIN_ALLOY);

		// Sound Registers
		Registry.register(Registry.SOUND_EVENT, HORN_ID, HORN_EVENT);

		// Block Registers
		Registry.register(Registry.BLOCK, new Identifier("modid", "tin_ore"), TIN_ORE);
		Registry.register(Registry.ITEM, new Identifier("modid", "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings().group(ExampleMod.CUSTOM_TAB)));

	}
}
