package net.phantom.SkitlMod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.phantom.SkitlMod.SkitlMod;
import net.phantom.SkitlMod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkitlMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SKITL_TAB = CREATIVE_MODE_TABS.register("skitl_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CLOUD.get()))
                    .title(Component.translatable("creativetab.skitl_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Add ITEMS to mod tab
                        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            pOutput.accept(item.get());
                        }
                        // Add BLOCK to mod tab
                        for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                            pOutput.accept(block.get());
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
