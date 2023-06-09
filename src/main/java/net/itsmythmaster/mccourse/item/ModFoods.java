package net.itsmythmaster.mccourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties TURNIP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 5), 0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 5), 0.25f).alwaysEat().build();
}
