package com.example.examplemod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.UUID;

public class ObsidianHelloTileEntity extends TileEntity implements ITickableTileEntity {
    private static final int MAX_TIME = 5 * 20;
    private int timer = 0;

    public ObsidianHelloTileEntity(){
        super(TileEntityTypeRegistry.obsidianHelloTileEntity.get());
    }
    @Override
    public void tick() {
        if (level != null && !level.isClientSide) {
            if (timer == MAX_TIME) {
                PlayerEntity player = level.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 10, false);
                TranslationTextComponent translationTextComponent = new TranslationTextComponent("message.hello_block.hello");
                if (player != null) {
                    player.sendMessage(translationTextComponent,null);
                }
                timer = 0;
            }
            timer++;
        }
    }
}
