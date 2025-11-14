package net.anware.tmc.colourscroller.scrollables;

import net.minecraft.block.Blocks;

import static net.anware.tmc.colourscroller.ScrollableHelper.addSet;

public class DirtScrollables {
    public static void init() {
        addSet("dirt", Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.ROOTED_DIRT, Blocks.DIRT_PATH, Blocks.FARMLAND,
                Blocks.MYCELIUM, Blocks.WARPED_NYLIUM, Blocks.CRIMSON_NYLIUM, Blocks.NETHERRACK, Blocks.END_STONE);
    }
}
