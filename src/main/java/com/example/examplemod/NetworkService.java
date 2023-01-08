package com.example.examplemod;

import com.sun.org.apache.xml.internal.utils.Trie;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NetworkService extends Event {
    public static final Logger logger = LogManager.getLogger();
    private static Trie01 networkID, nodeID;
    private static Set<Network> networks;
    public static final NetworkService INSTANCE = new NetworkService();
    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {
        networkID = new Trie01();
        nodeID = new Trie01();
        networks = new HashSet<>();
        logger.info("Network service has started");

    }
    @SubscribeEvent
    public static void onServerStopped(FMLServerStoppingEvent event) {
        networkID.clear();
        nodeID.clear();
        networks.clear();
        logger.info("Network service has stopped");
    }
    public Network createNetwork() {
        Network network = new Network(networkID.mexAndInsert());
        networks.add(network);
        logger.info("Create network#{}", network.getId());
        return network;
    }
    public NetworkNode createNetworkNode(BaseBlockEntity blockEntity) {
        NetworkNode node = new NetworkNode(nodeID.mexAndInsert(), blockEntity);
        blockEntity.setNetworkNode(node);
        logger.info("Create network node#{}", node.getId());
        return node;
    }
    public void removeNetwork(Network network) {
        logger.info("Remove network#{}", network.getId());
        networkID.remove(network.getId());
        networks.remove(network);
        network.destroy();
    }
    public void removeNetworkNode(NetworkNode node) {
        logger.info("Remove network node#{}", node.getId());
        if (node.getNetwork() != null) removeNodeInNetwork(node, node.getNetwork());
        nodeID.remove(node.getId());
    }
    public void addNodeToNetwork(NetworkNode node, Network network) {
        network.addNode(node);
        node.setNetwork(network);
    }
    public void removeNodeInNetwork(NetworkNode node, Network network) {
        network.removeNode(node);
        node.setNetwork(null);
    }
    public Set<Network> getNetworks() {
        return networks;
    }
    public void mergeNetwork(Network n1, Network n2) {
        Network n3 = Network.merge(n1, n2);
        if (n3 == n1) removeNetwork(n2);
        else removeNetwork(n1);
    }
}
