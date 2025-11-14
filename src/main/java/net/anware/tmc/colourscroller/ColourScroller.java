package net.anware.tmc.colourscroller;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ColourScroller implements ClientModInitializer {

    public static final String ID = "colourscroller";

    @Override
    public void onInitializeClient() {
        Settings.register();
    }

    public static ItemStack getNextScrollable(ScrollableItem indexScrollable, ItemStack currentItemStack, int shift) {
        ScrollableItem oldScrollable = (ScrollableItem) currentItemStack.getItem();

        List<ScrollableHelper.ColouredEntry> list = ScrollableHelper.SCROLLABLE_SETS.get(oldScrollable.getListIndex());
        if (list == null || list.isEmpty()) return ItemStack.EMPTY;

        int size = list.size();
        int nextIndex = Math.floorMod(indexScrollable.getIndex() + shift, size);

        ScrollableHelper.ColouredEntry entry = list.get(nextIndex);

        if(entry.item() == null) return ItemStack.EMPTY;

        return createStack(entry.item().get(), currentItemStack);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static ItemStack createStack(Item item, ItemStack stack) {
        ItemStack newStack = new ItemStack(item, stack.getCount());

        stack.getComponents().forEach((component) -> {
            ComponentType<?> type = component.type();
            if (type == DataComponentTypes.BLOCK_STATE) return;
            if (type == DataComponentTypes.MAP_ID) return;
            if (type == DataComponentTypes.ITEM_NAME) return;
            if (type == DataComponentTypes.BREAK_SOUND) return;
            if (type == DataComponentTypes.ITEM_MODEL) return;
            if (type == DataComponentTypes.TOOLTIP_DISPLAY) return;

            newStack.set((ComponentType) type, component.value());  // unchecked cast is safe here
        });

        return newStack;
    }
}