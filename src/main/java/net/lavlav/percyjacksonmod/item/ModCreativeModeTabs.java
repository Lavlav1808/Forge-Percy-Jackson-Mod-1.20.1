package net.lavlav.percyjacksonmod.item;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PercyJacksonMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PERCY_JACKSON_MOD = CREATIVE_MODE_TABS.register("percy_jackson_mod",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GODDESS_BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab.percyjacksonmod.parcy_jackson_mod"))
                    .displayItems((pParameters, pOutput) ->{

                        // Goddess Bronze

                            // Basic Items
                            pOutput.accept(ModItems.GODDESS_BRONZE_INGOT.get());
                            pOutput.accept(ModItems.RAW_GODDESS_BRONZE.get());

                            // Basic Blocks
                            pOutput.accept(ModBlocks.GODDESS_BRONZE_BLOCK.get());
                            pOutput.accept(ModBlocks.RAW_GODDESS_BRONZE_BLOCK.get());

                            // Tools
                            pOutput.accept(ModItems.GODDESS_BRONZE_SWORD.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_PICKAXE.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_AXE.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_SHOVEL.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_HOE.get());

                            // Armor (Incl. Horse Armor)
                            pOutput.accept(ModItems.GODDESS_BRONZE_HELMET.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_CHESTPLATE.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_LEGGINGS.get());
                            pOutput.accept(ModItems.GODDESS_BRONZE_BOOTS.get());

                            // Ore Blocks
                            pOutput.accept(ModBlocks.GODDESS_BRONZE_ORE.get());
                            pOutput.accept(ModBlocks.DEEPSLATE_GODDESS_BRONZE_ORE.get());

                        // Food Items
                            pOutput.accept(ModItems.BOTTLE_OF_NECTAR.get());
                            pOutput.accept(ModItems.BOWL_WITH_AMBROSIA.get());

                        // Olympian Upgrade
                        pOutput.accept(ModItems.OLYMPIAN_UPGRADE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
