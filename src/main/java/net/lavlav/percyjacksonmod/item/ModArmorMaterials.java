package net.lavlav.percyjacksonmod.item;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    GODDESS_BRONZE("goddess_bronze",
            26, new int[]{ 4, 8, 5, 4},
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            1F,
            0.2F,
            () -> Ingredient.of(ModItems.GODDESS_BRONZE_INGOT.get())
            );

    private final String name;
    private final int durabilityMultiplayer;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toghness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplayer, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toghness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplayer = durabilityMultiplayer;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toghness = toghness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplayer;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return PercyJacksonMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return toghness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
