package net.lavlav.percyjacksonmod.datagen;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.lavlav.percyjacksonmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class ModItemModelProvider extends ItemModelProvider {

    private static final Map<ResourceKey<TrimMaterial>, Float> TRIM_MATERIALS = Map.of(
            TrimMaterials.QUARTZ, 0.1f,
            TrimMaterials.IRON, 0.2f,
            TrimMaterials.NETHERITE, 0.3f,
            TrimMaterials.REDSTONE, 0.4f,
            TrimMaterials.COPPER, 0.5f,
            TrimMaterials.GOLD, 0.6f,
            TrimMaterials.EMERALD, 0.7f,
            TrimMaterials.DIAMOND, 0.8f,
            TrimMaterials.LAPIS, 0.9f,
            TrimMaterials.AMETHYST, 1.0f
    );

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PercyJacksonMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.GODDESS_BRONZE_INGOT);
        simpleItem(ModItems.RAW_GODDESS_BRONZE);
        simpleItem(ModItems.BOTTLE_OF_NECTAR);
        simpleItem(ModItems.BOWL_WITH_AMBROSIA);

        handheldItem(ModItems.GODDESS_BRONZE_SWORD);
        handheldItem(ModItems.GODDESS_BRONZE_PICKAXE);
        handheldItem(ModItems.GODDESS_BRONZE_AXE);
        handheldItem(ModItems.GODDESS_BRONZE_SHOVEL);
        handheldItem(ModItems.GODDESS_BRONZE_HOE);

        trimmedArmorItem(ModItems.GODDESS_BRONZE_HELMET, TRIM_MATERIALS);
        trimmedArmorItem(ModItems.GODDESS_BRONZE_CHESTPLATE, TRIM_MATERIALS);
        trimmedArmorItem(ModItems.GODDESS_BRONZE_LEGGINGS, TRIM_MATERIALS);
        trimmedArmorItem(ModItems.GODDESS_BRONZE_BOOTS, TRIM_MATERIALS);

        simpleItem(ModItems.OLYMPIAN_UPGRADE);
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject, Map<ResourceKey<TrimMaterial>, Float> trimMaterials) {
        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            String armorType = switch (armorItem.getEquipmentSlot()) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "";
            };

            for (Map.Entry<ResourceKey<TrimMaterial>, Float> entry : trimMaterials.entrySet()) {
                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(
                        PercyJacksonMod.MOD_ID, "item/" + itemRegistryObject.getId().getPath());
                ResourceLocation trimResLoc = ResourceLocation.fromNamespaceAndPath(
                        "minecraft", "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath());
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(
                        PercyJacksonMod.MOD_ID, "item/" + itemRegistryObject.getId().getPath() + "_" + trimMaterial.location().getPath() + "_trim");

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(trimNameResLoc.getPath())
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue)
                        .end()
                        .texture("layer0", armorItemResLoc);
            }
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", new ResourceLocation(PercyJacksonMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), mcLoc("item/handheld"))
                .texture("layer0", new ResourceLocation(PercyJacksonMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
