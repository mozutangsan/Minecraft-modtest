package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;

public class IronRubikCube extends Block {
    private static IntegerProperty STATE=IntegerProperty.create("face",0,1);
    public IronRubikCube(){
        super(Properties.of(Material.GLASS).harvestLevel(5));
        this.registerDefaultState(this.getStateDefinition().any().setValue(STATE,1));
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder){
        pBuilder.add(STATE);
        super.createBlockStateDefinition(pBuilder);
    }
}
