package com.slov.slabalicious.init;

import com.slov.slabalicious.Slabalicious;
import com.slov.slabalicious.objects.blocks.CoarseDirtSlab;
import com.slov.slabalicious.objects.blocks.DirtSlab;
import com.slov.slabalicious.objects.blocks.GrassSlab;
import com.slov.slabalicious.objects.blocks.GravelSlab;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Slabalicious.MODID);
	
	public static final RegistryObject<Block> COARSE_DIRT_SLAB = BLOCKS.register("coarse_dirt_slab", CoarseDirtSlab::new);
	public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", DirtSlab::new);
	public static final RegistryObject<Block> GRASS_SLAB = BLOCKS.register("grass_slab", GrassSlab::new);
	public static final RegistryObject<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab", GravelSlab::new);
}
