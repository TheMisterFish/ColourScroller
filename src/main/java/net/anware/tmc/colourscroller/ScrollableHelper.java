package net.anware.tmc.colourscroller;


import net.anware.tmc.colourscroller.scrollables.ColourScrollables;
import net.anware.tmc.colourscroller.scrollables.DirtScrollables;
import net.anware.tmc.colourscroller.scrollables.OreScrollables;
import net.anware.tmc.colourscroller.scrollables.RedstoneScrollables;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ScrollableHelper {

    public record ColouredEntry(String type, String id, Supplier<Item> item) {
    }

    public record ScrollInfo(String type, int listIndex, int index) {
    }


    public static final List<List<ColouredEntry>> SCROLLABLE_SETS = new ArrayList<>();
    public static final Map<String, ScrollInfo> SCROLLABLE_LOOKUP = new HashMap<>();


    static {
        ColourScrollables.init();
        DirtScrollables.init();
        OreScrollables.init();
        RedstoneScrollables.init();

        for (int listIndex = 0; listIndex < SCROLLABLE_SETS.size(); listIndex++) {
            List<ColouredEntry> list = SCROLLABLE_SETS.get(listIndex);
            for (int index = 0; index < list.size(); index++) {
                SCROLLABLE_LOOKUP.put(list.get(index).id(), new ScrollInfo(list.get(index).type, listIndex, index));
            }
        }
    }

    public static void addSet(String type, Block... blocks) {
        List<ColouredEntry> set = new ArrayList<>();

        for (Block block : blocks) {
            String id = Registries.BLOCK.getId(block).getPath(); // use actual registry path
            set.add(new ColouredEntry(type, id, block::asItem));
        }

        SCROLLABLE_SETS.add(set);
    }
}
