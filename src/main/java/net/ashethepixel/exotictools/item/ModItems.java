package net.ashethepixel.exotictools.item;

import net.ashethepixel.exotictools.ExoticToolsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExoticToolsMod.MOD_ID);

    public static final RegistryObject<Item> MOISSANITE = ITEMS.register("moissanite",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RAW_MOISSANITE = ITEMS.register("raw_moissanite",
            () -> new Item(new Item.Properties().fireResistant()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
