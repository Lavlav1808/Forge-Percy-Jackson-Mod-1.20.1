package net.lavlav.percyjacksonmod.item;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier GODDESS_BRONZE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1846, 8.7F, 3.7F, 17,
                    ModTags.Blocks.NEEDS_GODDESS_BRONZE_TOOL, () -> Ingredient.of(ModItems.GODDESS_BRONZE_INGOT.get())),
            new ResourceLocation(PercyJacksonMod.MOD_ID, "goddess_bronze"), List.of(Tiers.DIAMOND), List.of());
}
