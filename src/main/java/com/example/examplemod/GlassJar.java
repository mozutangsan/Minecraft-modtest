package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GlassJar extends Block {
    public GlassJar(){
        super(Properties.of(Material.STONE).harvestLevel(5).noOcclusion());
    }
}
