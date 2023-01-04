package com.example.examplemod;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PathService {
    //日志
    private static final Logger logger = LogManager.getLogger();
    //创建一个静态实例
    public static final PathService INSTANCE = new PathService();
    public static Queue<NetworkNode> queue;
    //服务端启动时，初始化
    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) throws InterruptedException {
        queue = new ArrayDeque<>();
    }
    //服务端TICK结束时
    @SubscribeEvent
    public static void onServerEndTick(FMLServerStoppingEvent event) {
        boolean flag = false;
        while (!queue.isEmpty()) {
            flag = true;
            NetworkNode cur = queue.remove();
            World world = cur.getBlockEntity().getLevel();
            //如果未加载则直接跳过
            if (!world.hasChunk(cur.getPos().getX(), cur.getPos().getZ())) continue;
            if (cur.getNetwork() == null) {
                //如果没有所属网络则创建一个
                Network network = NetworkService.INSTANCE.createNetwork();
                NetworkService.INSTANCE.addNodeToNetwork(cur, network);
            }
            Network curNetwork = cur.getNetwork();
            for (Direction direction : cur.getPossibleConnection()) {
                BlockPos pos = cur.getPos().offset(direction.getNormal());
                BaseBlockEntity BE=new BaseBlockEntity();
                if (world.hasChunk(pos.getX(), pos.getZ()) && (world.getBlockEntity(pos) == BE)) {
                    NetworkNode next = BE.getNetworkNode();
                    Network nextNetwork = next.getNetwork();
                    if (nextNetwork == null) {
                        //将结点加入到网络中
                        NetworkService.INSTANCE.addNodeToNetwork(next, curNetwork);
                        queue.add(next);
                    } else if (curNetwork != nextNetwork) {
                        //合并网络
                        NetworkService.INSTANCE.mergeNetwork(curNetwork, nextNetwork);
                        //记得更新正在处理的所属网络！
                        curNetwork = cur.getNetwork();
                    }
                }
            }
        }
        //打印调试信息
        if (flag) {
            logger.info("Path finding finish");
            for (Network network : NetworkService.INSTANCE.getNetworks()) {
                logger.info("Network#{}:", network.getId());
                for (NetworkNode node : network.getNodes()) {
                    BlockPos pos = node.getPos();
                    logger.info("Node#{}: {}, {}, {}", node.getId(), pos.getX(), pos.getY(), pos.getZ());
                }
            }
        }
    }
}
