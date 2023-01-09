package com.example.examplemod;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class NetworkNode {
    //为每个结点分配一个id
    private int id;
    //结点所在的网络
    private Network network;
    //获取结点id
    public int getId() {
        return id;
    }
    //获取结点所在的网络
    public Network getNetwork() {
        return network;
    }
    //设置结点所在的网络
    public void setNetwork(Network network) {
        this.network = network;
    }
    //存储结点所在的BlockEntity
    private BaseBlockEntity blockEntity;
    //构造函数
    public NetworkNode(int id, BaseBlockEntity blockEntity) {
        this.id = id;
        this.blockEntity = blockEntity;
        this.network = null;
    }
    //获取结点所在位置
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
