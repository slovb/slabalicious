package com.slov.slabalicious;

import com.slov.slabalicious.init.ModBlocks;
import com.slov.slabalicious.objects.blocks.CoarseDirtSlab;
import com.slov.slabalicious.objects.blocks.DirtSlab;
import com.slov.slabalicious.objects.blocks.GrassSlab;
import com.slov.slabalicious.objects.blocks.GravelSlab;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = Slabalicious.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				setup(new BlockItem(ModBlocks.COARSE_DIRT_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)),
						"coarse_dirt_slab"),
				setup(new BlockItem(ModBlocks.DIRT_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)),
						"dirt_slab"),
				setup(new BlockItem(ModBlocks.GRASS_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)),
						"grass_slab"),
				setup(new BlockItem(ModBlocks.GRAVEL_SLAB, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)),
						"gravel_slab"));
	}

	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				setup(new CoarseDirtSlab(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)
						.hardnessAndResistance(0.5F).sound(SoundType.GROUND)), "coarse_dirt_slab"),
				setup(new DirtSlab(Block.Properties.create(Material.EARTH, MaterialColor.DIRT)
						.hardnessAndResistance(0.5F).sound(SoundType.GROUND)), "dirt_slab"),
				setup(new GrassSlab(Block.Properties.create(Material.ORGANIC)
						.hardnessAndResistance(0.6F).sound(SoundType.PLANT)), "grass_slab"),
				setup(new GravelSlab(Block.Properties.create(Material.SAND, MaterialColor.STONE)
						.hardnessAndResistance(0.6F).sound(SoundType.GROUND)), "gravel_slab"));
	}
	
	@SubscribeEvent
	public static void onRegisterBlockColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((blockState, enviromentalBlockReader, blockPos, i) -> {
         return enviromentalBlockReader != null && blockPos != null ? BiomeColors.getGrassColor(enviromentalBlockReader, blockPos) : GrassColors.get(0.5D, 1.0D);
      }, ModBlocks.GRASS_SLAB);
	}

	@SubscribeEvent
	public static void onRegisterItemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().register((itemStack, i) -> {
	         return GrassColors.get(0.5D, 1.0D);
	      }, ModBlocks.GRASS_SLAB);
	}
	
	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(Slabalicious.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
}
