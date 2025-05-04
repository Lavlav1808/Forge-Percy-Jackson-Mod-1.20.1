package net.lavlav.percyjacksonmod.util;

import net.lavlav.percyjacksonmod.PercyJacksonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_GODDESS_BRONZE_TOOL = tag("needs_goddess_bronze_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PercyJacksonMod.MOD_ID, name));
        }
    }

    public static class Items {

    }
}
