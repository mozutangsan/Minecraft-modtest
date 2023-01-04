package com.example.examplemod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS;
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");
    }
    public static RegistryObject<IronIngot> ironIngot = ITEMS.register("iron_ingot",IronIngot::new);
    public static RegistryObject<Item> ironApple=ITEMS.register("iron_apple",IronApple::new);
    public static RegistryObject<Item> ironSword=ITEMS.register("iron_sword",IronSword::new);
    public static RegistryObject<Item> ironPickaxe=ITEMS.register("iron_pickaxe",IronPickaxe::new);
    public static RegistryObject<Item> ironBlock=ITEMS.register("iron_block",()-> new BlockItem(BlockRegistry.ironBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> ironRubikCube=ITEMS.register("iron_rubik_cube",()-> new BlockItem(BlockRegistry.ironRubikCube.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> ironFrame=ITEMS.register("iron_frame",()-> new BlockItem(BlockRegistry.ironFrame.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> obsidianHelloBlock=ITEMS.register("obsidian_hello_block",()->new BlockItem(BlockRegistry.obsidianHelloBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> obsidianZombieBlock=ITEMS.register("obsidian_zombie_block",()->new BlockItem(BlockRegistry.obsidianZombieBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> obsidianUpBlock=ITEMS.register("obsidian_up_block",()->new BlockItem(BlockRegistry.obsidianUpBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> obsidianDownBlock=ITEMS.register("obsidian_down_block",()->new BlockItem(BlockRegistry.obsidianDownBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> obsidianTrash=ITEMS.register("obsidian_trash",()->new BlockItem(BlockRegistry.obsidianTrash.get(),new Item.Properties().tab(ModGroup.ironGroup)));
    public static RegistryObject<Item> baseBlock=ITEMS.register("base_block",()->new BlockItem(BlockRegistry.BaseBlock.get(),new Item.Properties().tab(ModGroup.ironGroup)));
}
