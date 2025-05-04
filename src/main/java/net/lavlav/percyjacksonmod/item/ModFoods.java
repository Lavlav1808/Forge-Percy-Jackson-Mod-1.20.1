package net.lavlav.percyjacksonmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties BOTTLE_OF_NECTAR = new FoodProperties.Builder()
            .fast()
            .nutrition(5)
            .saturationMod(5.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0), 1.0F)
            .build();

    public static final FoodProperties BOWL_WITH_AMBROSIA = new FoodProperties.Builder()
            .fast()
            .nutrition(5)
            .saturationMod(5.0F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0), 1.0F)
            .build();
}
