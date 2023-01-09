package com.example.examplemod;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class NetworkNode {
    //为每个结点分配一个id
    private int id;
    private Network network;
    public int getId() {
        return id;
    }
    public Network getNetwork() {
        return network;
    }
    public void setNetwork(Network network) {
        this.network = network;
    }
    private BaseBlockEntity blockEntity;
    //构造函数
    public NetworkNode(int id, BaseBlockEntity blockEntity) {
        this.id = id;
        this.blockEntity = blockEntity;
        this.network = null;
    }
    public BlockPos getPos() {
        return blockEntity.getBlockPos();
    }
    public BaseBlockEntity getBlockEntity() {
        return blockEntity;
    }
    public List<Direction> getPossibleConnection() {
        return blockEntity.getPossibleConnection();
    }
}
