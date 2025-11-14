package net.anware.tmc.colourscroller.scrollables;

import net.minecraft.block.Blocks;

import static net.anware.tmc.colourscroller.ScrollableHelper.addSet;

public class OreScrollables {
    public static void init() {
        addSet("ore", Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.COPPER_ORE, Blocks.COAL_ORE, Blocks.DIAMOND_ORE,
                Blocks.EMERALD_ORE, Blocks.LAPIS_ORE, Blocks.REDSTONE_ORE, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE, Blocks.GILDED_BLACKSTONE);

        addSet("ore", Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_COAL_ORE,
                Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.NETHER_GOLD_ORE, Blocks.NETHER_QUARTZ_ORE, Blocks.GILDED_BLACKSTONE);
    }
}
