package com.example.examplemod;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER;

    static {
        TILE_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "neutrino");
    }

    public static RegistryObject<TileEntityType<ObsidianCounterTileEntity>> obsidianCounterTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_counter_tileentity",()->{
        return TileEntityType.Builder.of(()-> {
            return new ObsidianCounterTileEntity();
        }, BlockRegistry.obsidianCounter.get()).build(null);
    });
    public static RegistryObject<TileEntityType<ObsidianHelloTileEntity>> obsidianHelloTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_hello_tile_entity",()->{
        return TileEntityType.Builder.of(()-> {
            return new ObsidianHelloTileEntity();
        }, BlockRegistry.obsidianHelloBlock.get()).build(null);
    });
    public static RegistryObject<TileEntityType<ObsidianZombieTileEntity>> obsidianZombieTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_zombie_tile_entity",()->{
        return TileEntityType.Builder.of(()-> {
            return new ObsidianZombieTileEntity();
        }, BlockRegistry.obsidianZombieBlock.get()).build(null);
    });
    public static RegistryObject<TileEntityType<ObsidianUpBlockTileEntity>> obsidianUpBlockTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_up_block",()->{
        return TileEntityType.Builder.of(()-> {
            return new ObsidianUpBlockTileEntity();
        }, BlockRegistry.obsidianUpBlock.get()).build(null);
    });
    public static RegistryObject<TileEntityType<ObsidianDownBlockTileEntity>> obsidianDownTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_down_block",()->{
        return TileEntityType.Builder.of(()-> {
            return new ObsidianDownBlockTileEntity();
        }, BlockRegistry.obsidianDownBlock.get()).build(null);
    });
    public static RegistryObject<TileEntityType<ObsidianTrashTileEntity>> obsidianTrashTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("obsidian_trash",()->{
        return TileEntityType.Builder.of(()->{
            return new ObsidianTrashTileEntity();
        },BlockRegistry.obsidianTrash.get()).build(null);
    });
    public static RegistryObject<TileEntityType<BaseBlockEntity>> BaseBlockTileEntity=TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("base_block",()->{
        return TileEntityType.Builder.of(()->{
            return new BaseBlockEntity();
        },BlockRegistry.BaseBlock.get()).build(null);
    });
}