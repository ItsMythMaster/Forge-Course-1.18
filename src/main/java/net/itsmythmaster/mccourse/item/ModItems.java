package net.itsmythmaster.mccourse.item;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(5)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
