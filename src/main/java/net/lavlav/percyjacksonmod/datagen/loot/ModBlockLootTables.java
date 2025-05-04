package net.lavlav.percyjacksonmod.datagen.loot;

import net.lavlav.percyjacksonmod.block.ModBlocks;
import net.lavlav.percyjacksonmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.GODDESS_BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get());

        this.add(ModBlocks.GODDESS_BRONZE_ORE.get(),
                block -> createOreDrop(ModBlocks.GODDESS_BRONZE_ORE.get(), ModItems.RAW_GODDESS_BRONZE.get()));
        this.add(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get(), ModItems.RAW_GODDESS_BRONZE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
