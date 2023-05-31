package net.itsmythmaster.mccourse.potion;

import net.itsmythmaster.mccourse.MCCourseMod;
import net.itsmythmaster.mccourse.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, MCCourseMod.MOD_ID);

    public static RegistryObject<Potion> FREEZING_POTION = POTIONS.register("freezing_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
