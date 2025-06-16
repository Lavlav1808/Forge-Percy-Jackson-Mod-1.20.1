package net.lavlav.percyjacksonmod.datagen;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.block.ModBlocks;
import net.lavlav.percyjacksonmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> GODDESS_BRONZE_SMELTABLES = List.of(ModItems.RAW_GODDESS_BRONZE.get(),
            ModBlocks.GODDESS_BRONZE_ORE.get(), ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, GODDESS_BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.GODDESS_BRONZE_INGOT.get(), 0.25F, 200, "goddess_bronze");
        oreBlasting(pWriter, GODDESS_BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.GODDESS_BRONZE_INGOT.get(), 0.25F, 100, "goddess_bronze");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GODDESS_BRONZE_BLOCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .pattern("GGG")
                .define('G', ModItems.GODDESS_BRONZE_INGOT.get())
                .unlockedBy(getHasName(ModItems.GODDESS_BRONZE_INGOT.get()), has(ModItems.GODDESS_BRONZE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RAW_GODDESS_BRONZE.get())
                .unlockedBy(getHasName(ModItems.GODDESS_BRONZE_INGOT.get()), has(ModItems.RAW_GODDESS_BRONZE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GODDESS_BRONZE_INGOT.get(), 9)
                .requires(ModBlocks.GODDESS_BRONZE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.GODDESS_BRONZE_BLOCK.get()), has(ModBlocks.GODDESS_BRONZE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_GODDESS_BRONZE.get(), 9)
                .requires(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get()), has(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, PercyJacksonMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
