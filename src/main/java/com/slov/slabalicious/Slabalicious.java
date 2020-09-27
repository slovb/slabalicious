package com.slov.slabalicious;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Slabalicious.MODID)
public class Slabalicious
{
	public static final String MODID = "slabalicious";
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public Slabalicious() {

    }
}
