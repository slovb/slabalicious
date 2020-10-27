package com.slov.slabalicious.objects.items;

import com.slov.slabalicious.init.ModBlocks;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GravelSlabItem extends BlockItem {

	public GravelSlabItem() {
		super(ModBlocks.GRAVEL_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	}
}
