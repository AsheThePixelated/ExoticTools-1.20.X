package net.ashethepixel.exotictools.item;

import net.ashethepixel.exotictools.ExoticToolsMod;
import net.ashethepixel.exotictools.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExoticToolsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXOTIC_TOOLS = CREATIVE_MODE_TABS.register("exotic_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MOISSANITE.get()))
                    .title(Component.translatable("creativetab.exotic_tools_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.MOISSANITE.get());
                        output.accept(ModItems.RAW_MOISSANITE.get());

                        output.accept(ModBlocks.MOISSANITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_MOISSANITE_BLOCK.get());
                        output.accept(ModBlocks.MOISSANITE_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
