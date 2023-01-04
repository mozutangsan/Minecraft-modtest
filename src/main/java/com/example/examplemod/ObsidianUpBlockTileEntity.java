package com.example.examplemod;


import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.LazyOptional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObsidianUpBlockTileEntity extends TileEntity implements ITickableTileEntity {

    public ObsidianUpBlockTileEntity() {
        super(TileEntityTypeRegistry.obsidianUpBlockTileEntity.get());
    }

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void tick() {
        if (level != null && !level.isClientSide) {
            BlockPos pos = this.worldPosition.below();
            TileEntity tileEntity = level.getBlockEntity(pos);
            if (tileEntity != null) {
                LazyOptional<ISimpleCapability> simpleCapabilityLazyOptional = tileEntity.getCapability(ModCapability.SIMPLE_CAPABILITY);
                simpleCapabilityLazyOptional.ifPresent((s) -> {
                    String context = s.getString(this.worldPosition);
                    logger.info(context);
                });
            }
        }

    }
}

