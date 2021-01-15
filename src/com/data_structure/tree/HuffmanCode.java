package com.data_structure.tree;


import java.util.*;

/**
 * @auther liuyiming
 * @date 2021/1/15 17:33
 * @description
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //得到数组
        byte[] contentBytes = content.getBytes();
//        System.out.println(contentBytes.length);

        //数组转为Nodes列表
        List<HuffmanNode> nodes = getNodes(contentBytes);
//        System.out.println(nodes);

        //创建哈夫曼树
        HuffmanNode huffmanTree = createHuffmanTree(nodes);
//        System.out.println(huffmanTree);

        //前序遍历
        HuffmanCode.preOrder(huffmanTree);
    }


    /**
     * 接收字节数组，返回构建好的List节点
     *
     * @param bytes
     * @return
     */
    private static List<HuffmanNode> getNodes(byte[] bytes) {

        //1、创建一个ArrayList
        ArrayList<HuffmanNode> nodes = new ArrayList<>();

        //2、遍历bytes,统计每一个byte出现的次数，利用map存储
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, ++count);
            }
        }

        //把每一个键值对转成一个Node对象，并加入到nodes集合
        //遍历Map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {

        while (nodes.size() > 1) {

            //先排序
            Collections.sort(nodes);
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);

            HuffmanNode node = new HuffmanNode(null,left.getWeight() + right.getWeight());
            node.setLeft(left);
            node.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(node);
        }


        return nodes.get(0);
    }

    public static void preOrder(HuffmanNode node){
        if (node != null){
            node.preOrder(node);
        }
    }


}
