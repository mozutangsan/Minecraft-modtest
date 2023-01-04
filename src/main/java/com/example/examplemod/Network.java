package com.example.examplemod;

import java.util.HashSet;
import java.util.Set;

public class Network {
    //为每个网络分配一个id
    private int id;
    //存储网络的各个结点
    private Set<NetworkNode> nodes;
    public Network(int id) {
        this.id = id;
        this.nodes = new HashSet<>();
    }
    //获取网络id
    public int getId() {
        return id;
    }
    //获取该网络的所有结点
    public Set<NetworkNode> getNodes() {
        return nodes;
    }
    //增加结点
    public void addNode(NetworkNode node) {
        nodes.add(node);
    }
    //移除结点
    public void removeNode(NetworkNode node) {
        nodes.remove(node);
    }
    //摧毁网络，将网络各结点“放生”
    public void destroy() {
        for (NetworkNode node : nodes) {
            node.setNetwork(null);
        }
        nodes.clear();
    }
    //调用时保证n1大小大于n2
    private static Network mergeInPrior(Network n1, Network n2) {
        //将n2的所有结点的所属网络设置为n1
        for (NetworkNode node : n2.nodes) {
            node.setNetwork(n1);
        }
        //将n2的所有节点加入到n1中
        n1.nodes.addAll(n2.nodes);
        //清空n2
        n2.nodes.clear();
        return n1;
    }
    //按照大小合并网络
    public static Network merge(Network n1, Network n2) {
        if (n1.nodes.size() >= n2.nodes.size()) return mergeInPrior(n1, n2);
        else return mergeInPrior(n2, n1);
    }
}
