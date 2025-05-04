package net.lavlav.percyjacksonmod.datagen;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.block.ModBlocks;
import net.lavlav.percyjacksonmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PercyJacksonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.NEEDS_GODDESS_BRONZE_TOOL)
                .add(Blocks.OBSIDIAN);


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GODDESS_BRONZE_BLOCK.get())
                .add(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get())
                .add(ModBlocks.GODDESS_BRONZE_ORE.get())
                .add(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GODDESS_BRONZE_BLOCK.get())
                .add(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get())
                .add(ModBlocks.GODDESS_BRONZE_ORE.get())
                .add(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get());
    }
}
