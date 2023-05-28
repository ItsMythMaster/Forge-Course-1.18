package net.itsmythmaster.mccourse.world;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.itsmythmaster.mccourse.world.gen.ModFlowerGeneration;
import net.itsmythmaster.mccourse.world.gen.ModOreGeneration;
import net.itsmythmaster.mccourse.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event)
    {
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);

//        RAW_GENERATION
//        LAKES
//        LOCAL_MODIFICATIONS
//        UNDERGROUND_STRUCTURES
//        SURFACE_STRUCTURES
//        STRONGHOLDS
//        UNDERGROUND_ORES
//        UNDERGROUND_DECORATION
//        FLUID_SPRINGS
//        VEGETAL_DECORATION
//        TOP_LAYER_MODIFICATION
    }
}