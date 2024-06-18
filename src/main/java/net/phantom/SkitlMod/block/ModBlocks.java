package net.phantom.SkitlMod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.phantom.SkitlMod.SkitlMod;
import net.phantom.SkitlMod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SkitlMod.MOD_ID);

    // cloud block
    public static final RegistryObject<Block> CLOUD_BLOCK = registryObject("cloud_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POWDER_SNOW).noCollission().replaceable().instabreak()));

    private static <T extends Block> RegistryObject<T> registryObject(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
