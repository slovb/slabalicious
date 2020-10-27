package com.slov.slabalicious.init;

import com.slov.slabalicious.Slabalicious;
import com.slov.slabalicious.objects.items.CoarseDirtSlabItem;
import com.slov.slabalicious.objects.items.DirtSlabItem;
import com.slov.slabalicious.objects.items.GrassSlabItem;
import com.slov.slabalicious.objects.items.GravelSlabItem;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Slabalicious.MODID);

	public static final RegistryObject<Item> COARSE_DIRT_SLAB = ITEMS.register("coarse_dirt_slab", CoarseDirtSlabItem::new);
	public static final RegistryObject<Item> DIRT_SLAB = ITEMS.register("dirt_slab", DirtSlabItem::new);
	public static final RegistryObject<Item> GRASS_SLAB = ITEMS.register("grass_slab", GrassSlabItem::new);
	public static final RegistryObject<Item> GRAVEL_SLAB = ITEMS.register("gravel_slab", GravelSlabItem::new);
}
