package net.lavlav.percyjacksonmod.datagen;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PercyJacksonMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GODDESS_BRONZE_BLOCK);
        blockWithItem(ModBlocks.RAW_GODDESS_BRONZE_BLOCK);

        blockWithItem(ModBlocks.GODDESS_BRONZE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
