package net.lavlav.percyjacksonmod.datagen;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, PercyJacksonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GODDESS_BRONZE_HELMET.get())
                .add(ModItems.GODDESS_BRONZE_CHESTPLATE.get())
                .add(ModItems.GODDESS_BRONZE_LEGGINGS.get())
                .add(ModItems.GODDESS_BRONZE_BOOTS.get());
    }
}
