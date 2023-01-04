package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS;

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "examplemod");
    }

    public static RegistryObject<IronBlock> ironBlock=BLOCKS.register("iron_block",IronBlock::new);
    public static RegistryObject<IronRubikCube> ironRubikCube=BLOCKS.register("iron_rubik_cube",IronRubikCube::new);
    public static RegistryObject<IronFrame> ironFrame=BLOCKS.register("iron_frame",IronFrame::new);
    public static RegistryObject<GlassJar> glassJar=BLOCKS.register("glass_jar",GlassJar::new);
    public static RegistryObject<ObsidianCounter> obsidianCounter=BLOCKS.register("obsidian_counter",ObsidianCounter::new);
    public static RegistryObject<ObsidianHelloBlock> obsidianHelloBlock=BLOCKS.register("obsidian_hello_block", ObsidianHelloBlock::new);
    public static RegistryObject<ObsidianZombieBlock> obsidianZombieBlock=BLOCKS.register("obsidian_zombie_block",ObsidianZombieBlock::new);
    public static RegistryObject<ObsidianUpBlock> obsidianUpBlock=BLOCKS.register("obsidian_up_block",ObsidianUpBlock::new);
    public static RegistryObject<ObsidianDownBlock> obsidianDownBlock=BLOCKS.register("obsidian_down_block",ObsidianDownBlock::new);
    public static RegistryObject<ObsidianTrash> obsidianTrash=BLOCKS.register("obsidian_trash",ObsidianTrash::new);
    public static RegistryObject<BaseBlock> BaseBlock=BLOCKS.register("base_block",BaseBlock::new);
}
