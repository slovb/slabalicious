package com.slov.slabalicious;

import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.slov.slabalicious.init.ModBlocks;
import com.slov.slabalicious.init.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Slabalicious.MODID)
public class Slabalicious {
	
	public static final String MODID = "slabalicious";
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Slabalicious() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	MinecraftForge.EVENT_BUS.register(this);
    	
    	ModBlocks.BLOCKS.register(bus);
    	ModItems.ITEMS.register(bus);
    }
    
    @EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD)
    public static class ModEventSubscriber {

    	@OnlyIn(Dist.CLIENT)
    	@SubscribeEvent
    	public static void onRegisterBlockColors(ColorHandlerEvent.Block event) {
    		event.getBlockColors().register((blockState, enviromentalBlockReader, blockPos, i) -> {
             return enviromentalBlockReader != null && blockPos != null ? BiomeColors.getGrassColor(enviromentalBlockReader, blockPos) : GrassColors.get(0.5D, 1.0D);
          }, ModBlocks.GRASS_SLAB.get());
    	}

    	@OnlyIn(Dist.CLIENT)
    	@SubscribeEvent
    	public static void onRegisterItemColors(ColorHandlerEvent.Item event) {
    		event.getItemColors().register((itemStack, i) -> {
    	         return GrassColors.get(0.5D, 1.0D);
    	      }, ModBlocks.GRASS_SLAB.get());
    	}
    }
}
