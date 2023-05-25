package net.itsmythmaster.mccourse.util;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.itsmythmaster.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.commands.arguments.item.ItemParser;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {

    public static void addCustomitemProperties()
    {
        ItemProperties.register(ModItems.DATA_TABLET.get(), new ResourceLocation(MCCourseMod.MOD_ID, "on"),
                ((pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f));
    }

}
