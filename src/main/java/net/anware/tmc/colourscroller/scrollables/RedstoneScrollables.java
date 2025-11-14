package net.anware.tmc.colourscroller.scrollables;

import net.minecraft.block.Blocks;

import static net.anware.tmc.colourscroller.ScrollableHelper.addSet;

public class RedstoneScrollables {
    public static void init() {
        addSet("piston", Blocks.PISTON, Blocks.STICKY_PISTON);

        addSet("slimehoney", Blocks.HONEY_BLOCK, Blocks.SLIME_BLOCK);

        addSet("dispenserdropper", Blocks.DISPENSER, Blocks.DROPPER);

        addSet("rails", Blocks.RAIL, Blocks.ACTIVATOR_RAIL, Blocks.DETECTOR_RAIL, Blocks.POWERED_RAIL);

        addSet("input", Blocks.RAIL, Blocks.ACTIVATOR_RAIL, Blocks.DETECTOR_RAIL, Blocks.POWERED_RAIL);
    }
}
