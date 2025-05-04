package net.lavlav.percyjacksonmod.block;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PercyJacksonMod.MOD_ID);

    public static final RegistryObject<Block> GODDESS_BRONZE_BLOCK = registerBlock("goddess_bronze_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(6.8F, 7.8F)
                    .sound(SoundType.COPPER)
                    .mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> GODDESS_BRONZE_ORE = registerBlock("goddess_bronze_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .strength(4.8F, 4.8F)
                    .mapColor(MapColor.STONE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> DEEPSLATE_GODDESS_BRONZE_ORE = registerBlock("deepslate_goddess_bronze_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(ModBlocks.GODDESS_BRONZE_ORE.get())
                    .strength(6.3F, 4.8F)
                    .sound(SoundType.DEEPSLATE)
                    .mapColor(MapColor.DEEPSLATE)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> RAW_GODDESS_BRONZE_BLOCK = registerBlock("raw_goddess_bronze_block",
            () -> new Block(BlockBehaviour.Properties.copy(ModBlocks.GODDESS_BRONZE_BLOCK.get())));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
