package net.itsmythmaster.mccourse.item;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.itsmythmaster.mccourse.item.custom.CoalSliverItem;
import net.itsmythmaster.mccourse.item.custom.DowsingRodItem;
import net.itsmythmaster.mccourse.item.custom.LevitationSwordItem;
import net.itsmythmaster.mccourse.item.custom.PaxelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).stacksTo(1).durability(16)));

    public static final RegistryObject<Item> COAL_SLIVER = ITEMS.register("coal_sliver",
            () -> new CoalSliverItem(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> TURNIP = ITEMS.register("turnip",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB).food(ModFoods.TURNIP)));

    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword",
            () -> new SwordItem(ModTiers.COBALT, 4, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe",
            () -> new PickaxeItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe",
            () -> new AxeItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_SHOVEL= ITEMS.register("cobalt_shovel",
            () -> new ShovelItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe",
            () -> new HoeItem(ModTiers.COBALT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_PAXEL = ITEMS.register("cobalt_paxel",
            () -> new PaxelItem(ModTiers.COBALT, 4f, 4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> LEVITATION_SWORD = ITEMS.register("levitation_sword",
            () -> new LevitationSwordItem(ModTiers.COBALT, 4, 4f,
                    new Item.Properties().tab(ModCreativeModeTab.COURSE_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
