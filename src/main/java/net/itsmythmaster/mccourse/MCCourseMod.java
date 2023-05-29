package net.itsmythmaster.mccourse;

import net.itsmythmaster.mccourse.block.ModBlocks;
import net.itsmythmaster.mccourse.block.ModWoodTypes;
import net.itsmythmaster.mccourse.block.entity.ModBlockEntities;
import net.itsmythmaster.mccourse.config.MCCourseClientConfigs;
import net.itsmythmaster.mccourse.config.MCCourseCommonConfigs;
import net.itsmythmaster.mccourse.enchantment.ModEnchantments;
import net.itsmythmaster.mccourse.fluid.ModFluids;
import net.itsmythmaster.mccourse.item.ModItems;
import net.itsmythmaster.mccourse.item.ModTiers;
import net.itsmythmaster.mccourse.painting.ModPaintings;
import net.itsmythmaster.mccourse.recipe.ModRecipes;
import net.itsmythmaster.mccourse.screen.CobaltBlasterScreen;
import net.itsmythmaster.mccourse.screen.ModMenuTypes;
import net.itsmythmaster.mccourse.sound.ModSounds;
import net.itsmythmaster.mccourse.util.ModItemProperties;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    public static final String MOD_ID = "mccourse";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // Very important comment
    public MCCourseMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEnchantments.register(eventBus);
        ModSounds.register(eventBus);
        ModPaintings.register(eventBus);
        ModFluids.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetUp);


        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MCCourseClientConfigs.SPEC, "mccourse-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MCCourseCommonConfigs.SPEC, "mccourse-common.toml");


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetUp(final FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COBALT_DOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TURNIP_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COBALT_BLASTER.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HONEY_FLOWING.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_BLOSSOM_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WINTER_WINDOW.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRAME_GLASS.get(), RenderType.translucent());


        ModItemProperties.addCustomitemProperties();

        MenuScreens.register(ModMenuTypes.COBALT_BLASTER_MENU.get(), CobaltBlasterScreen::new);

        WoodType.register(ModWoodTypes.CHERRY_BLOSSOM);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP_SEEDS.get(), 0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.TURNIP.get(), 0.65f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

            BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
            Sheets.addWoodType(ModWoodTypes.CHERRY_BLOSSOM);
        });
    }

}
