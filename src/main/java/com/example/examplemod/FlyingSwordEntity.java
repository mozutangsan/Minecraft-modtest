package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlyingSwordEntity extends Entity {
    private static final DataParameter<Integer> COUNTER = EntityDataManager.defineId(FlyingSwordEntity.class, DataSerializers.INT);
    private Logger logger = LogManager.getLogger();
    public FlyingSwordEntity(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        this.entityData.set(COUNTER, compound.getInt("counter"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        compound.putInt("counter", this.entityData.get(COUNTER));
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
