package net.itsmythmaster.mccourse.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.itsmythmaster.mccourse.util.ModTags;

public class ModTiers {

    public static final ForgeTier COBALT = new ForgeTier(5, 2800, 12f,
            5f, 20, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.COBALT_INGOT.get()));

}
