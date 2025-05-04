package net.lavlav.percyjacksonmod.item;

import net.lavlav.percyjacksonmod.PercyJacksonMod;

import net.lavlav.percyjacksonmod.item.custom.BowlWithAmbrosiaItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PercyJacksonMod.MOD_ID);

    public static final RegistryObject<Item> GODDESS_BRONZE_INGOT = ITEMS.register("goddess_bronze_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_GODDESS_BRONZE = ITEMS.register("raw_goddess_bronze",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BOTTLE_OF_NECTAR = ITEMS.register("bottle_of_nectar",
            () -> new net.lavlav.percyjacksonmod.item.BottleOfNectarItem(new Item.Properties()
                    .food(ModFoods.BOTTLE_OF_NECTAR)
                    .stacksTo(1)));
    public static final RegistryObject<Item> BOWL_WITH_AMBROSIA = ITEMS.register("bowl_with_ambrosia",
            () -> new BowlWithAmbrosiaItem(new Item.Properties()
                    .food(ModFoods.BOWL_WITH_AMBROSIA)
                    .stacksTo(1)));

    // Goddess Bronze Tools
    public static final RegistryObject<Item> GODDESS_BRONZE_SWORD = ITEMS.register("goddess_bronze_sword",
            () -> new SwordItem(ModToolTiers.GODDESS_BRONZE, 5, 2, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_PICKAXE = ITEMS.register("goddess_bronze_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GODDESS_BRONZE, 1, 4, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_AXE = ITEMS.register("goddess_bronze_axe",
            () -> new AxeItem(ModToolTiers.GODDESS_BRONZE, 7, 1, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_SHOVEL = ITEMS.register("goddess_bronze_shovel",
            () -> new ShovelItem(ModToolTiers.GODDESS_BRONZE, 2, 4, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_HOE = ITEMS.register("goddess_bronze_hoe",
            () -> new HoeItem(ModToolTiers.GODDESS_BRONZE, 0, 2, new Item.Properties()));

    // Goddess Bronze Armor (Incl. Horse Armor)
    public static final RegistryObject<Item> GODDESS_BRONZE_HELMET = ITEMS.register("goddess_bronze_helmet",
            () -> new ArmorItem(ModArmorMaterials.GODDESS_BRONZE, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_CHESTPLATE = ITEMS.register("goddess_bronze_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GODDESS_BRONZE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_LEGGINGS = ITEMS.register("goddess_bronze_leggings",
            () -> new ArmorItem(ModArmorMaterials.GODDESS_BRONZE, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> GODDESS_BRONZE_BOOTS = ITEMS.register("goddess_bronze_boots",
            () -> new ArmorItem(ModArmorMaterials.GODDESS_BRONZE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Olympian Upgrade
    public static final RegistryObject<Item> OLYMPIAN_UPGRADE = ITEMS.register("olympian_upgrade",
            () -> new Item(new Item.Properties()));

   public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
   }
}
