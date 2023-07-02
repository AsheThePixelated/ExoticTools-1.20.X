package net.ashethepixel.exotictools.block;

import net.ashethepixel.exotictools.ExoticToolsMod;
import net.ashethepixel.exotictools.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExoticToolsMod.MOD_ID);


    public static final RegistryObject<Block> MOISSANITE_BLOCK = registerBlock("moissanite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BIT)
                    .requiresCorrectToolForDrops().strength(5.0f, 8.0f)));

    public static final RegistryObject<Block> RAW_MOISSANITE_BLOCK = registerBlock("raw_moissanite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BIT)
                    .requiresCorrectToolForDrops().strength(4.0f, 6.0f)));

    public static final RegistryObject<Block> MOISSANITE_ORE = registerBlock("moissanite_ore",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.NETHERRACK).mapColor(MapColor.COLOR_GRAY).instrument(NoteBlockInstrument.BIT)
                    .requiresCorrectToolForDrops().strength(4.5f, 5.0f)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
