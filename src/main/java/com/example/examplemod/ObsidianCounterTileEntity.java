package com.example.examplemod;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import org.jetbrains.annotations.NotNull;

import static com.example.examplemod.TileEntityTypeRegistry.obsidianCounterTileEntity;

public class ObsidianCounterTileEntity extends TileEntity {
    private int counter = 0;

    public ObsidianCounterTileEntity() {
        super(obsidianCounterTileEntity.get());
    }


    public int increase() {
        counter++;
        setChanged();
        return counter;
    }
    @Override
    public void load(BlockState p_230337_1_,CompoundNBT p_230337_2_){
        counter = p_230337_2_.getInt("counter");
        super.load(p_230337_1_,p_230337_2_);
    }
    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.putInt("counter", counter);
        return super.save(compound);
    }
}
