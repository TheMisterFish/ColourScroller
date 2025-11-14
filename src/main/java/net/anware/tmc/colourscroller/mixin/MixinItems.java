package net.anware.tmc.colourscroller.mixin;

import net.anware.tmc.colourscroller.ScrollableItem;
import net.anware.tmc.colourscroller.ScrollableHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Items.class)
public abstract class MixinItems {
    @Inject(
            method = "register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;",
            at = @At("TAIL")
    )
    private static void onRegister(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings, CallbackInfoReturnable<Item> cir) {
        Item item = cir.getReturnValue();
        String idPath = key.getValue().getPath();

        ScrollableHelper.ScrollInfo info = ScrollableHelper.SCROLLABLE_LOOKUP.get(idPath);

        if (info != null) {
            ScrollableItem c = (ScrollableItem) item;
            c.setScrollable(true);
            c.setListIndex(info.listIndex());
            c.setIndex(info.index());
            c.setType(info.type());
        }
    }
}