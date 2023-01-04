package com.example.examplemod;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

import java.util.Arrays;
import java.util.List;

import static com.example.examplemod.PathService.queue;

public class BaseBlockEntity extends TileEntity {
    public BaseBlockEntity(){
        super(TileEntityTypeRegistry.BaseBlockTileEntity.get());
    }
    //存储BlockEntity对应的结点
    private NetworkNode networkNode;
    //设置BlockEntity对应的结点
    public void setNetworkNode(NetworkNode networkNode) {
        this.networkNode = networkNode;
    }
    //获取BlockEntity对应的结点
    public NetworkNode getNetworkNode() {
        return networkNode;
    }
    public List<Direction> getPossibleConnection() {
        return Arrays.asList(Direction.values());
    }
    public boolean canConnect(Direction direction) {
        return getPossibleConnection().contains(direction);
    }
    @Override
    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        BaseBlockEntity BE=new BaseBlockEntity();
        NetworkNode node = NetworkService.INSTANCE.createNetworkNode(BE);
        //新建的网络结点放入处理队列中
        queue.add(node);
    }

    @Override
    public void onChunkUnloaded() {
        BaseBlockEntity BE=new BaseBlockEntity();
        Network network = BE.getNetworkNode().getNetwork();
        NetworkService.INSTANCE.removeNetworkNode(BE.getNetworkNode());
        if (network != null) {
            queue.addAll(network.getNodes());
            NetworkService.INSTANCE.removeNetwork(network);
        }
    }
}
