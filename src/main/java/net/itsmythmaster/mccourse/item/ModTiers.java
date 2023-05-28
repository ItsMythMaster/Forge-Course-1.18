package net.itsmythmaster.mccourse.item;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.ForgeTier;
import net.itsmythmaster.mccourse.util.ModTags;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ModTiers extends TierSortingRegistry{


//    public static final ForgeTier COBALT = new ForgeTier(5, 2800, 12f,
//            5f, 20, BlockTags.NEEDS_DIAMOND_TOOL,
//            () -> Ingredient.of(ModItems.COBALT_INGOT.get()));

    public static Tier COBALT = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 11.0f, 5.0f, 24,
                    ModTags.Blocks.NEEDS_COBALT_TOOL, () -> Ingredient.of(ModItems.COBALT_INGOT.get())),
            new ResourceLocation(MCCourseMod.MOD_ID, "cobalt"), List.of(Tiers.NETHERITE), List.of());

}
