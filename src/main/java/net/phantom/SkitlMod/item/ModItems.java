package net.phantom.SkitlMod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phantom.SkitlMod.SkitlMod;
import net.phantom.SkitlMod.item.custom.IslandFinderItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SkitlMod.MOD_ID);

    public static final RegistryObject<Item> CLOUD = ITEMS.register("cloud",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ISLAND_FINDER = ITEMS.register("island_finder",
            () -> new IslandFinderItem(new Item.Properties().durability(50)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
