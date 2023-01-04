package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class IronBlock extends Block {
    public IronBlock(){
        super(Properties.of(Material.STONE).harvestLevel(5));
    }
}
