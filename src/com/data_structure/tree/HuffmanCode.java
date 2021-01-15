package com.data_structure.tree;


import java.util.*;

/**
 * @auther liuyiming
 * @date 2021/1/15 17:33
 * @description
 */
public class HuffmanCode {

    //存放哈夫曼表
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //用于拼接路径
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //得到数组
        byte[] contentBytes = content.getBytes();
        System.out.println("压缩前："+Arrays.toString(contentBytes));

        byte[] bytes = huffmanZip(contentBytes);
        System.out.println("压缩后："+Arrays.toString(bytes));

    }

    /**
     * 哈夫曼压缩
     *
     * @param contentBytes 原始字符串对应的bytes数组
     * @return 经过哈夫曼编码出来后的字节数组
     */
    public static byte[] huffmanZip(byte[] contentBytes) {

        //数组转为Nodes列表
        List<HuffmanNode> nodes = getNodes(contentBytes);

        //创建哈夫曼树
        HuffmanNode root = createHuffmanTree(nodes);

        //递归生成哈夫曼编码
        getCodes(root, "", stringBuilder);

        //根据哈夫曼编码来对原始数组进行压缩
        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);

        return huffmanCodeBytes;

    }


    /**
     * 根据字符创建哈夫曼节点列表，都是子节点
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

    /**
     * 根据子节点列表来创建哈夫曼树
     *
     * @param nodes
     * @return
     */
    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {

        while (nodes.size() > 1) {
            //先排序
            Collections.sort(nodes);
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            HuffmanNode node = new HuffmanNode(null, left.getWeight() + right.getWeight());
            node.setLeft(left);
            node.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(node);
        }
        return nodes.get(0);
    }

    /**
     * 将传入的node节点的所有叶子节点的哈夫曼编码得到，并放入到hunffmanCodes结合
     *
     * @param node          传入节点，父节点
     * @param code          生成的路径，如果是左子树则为0，如果是右子树则为1
     * @param stringBuilder 用于拼接路径
     */
    public static void getCodes(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code 加入到stringBuilder2
        stringBuilder1.append(code);
        //如果node为空，则说明遍历完毕
        if (node != null) {
            if (node.getData() == null) { //非叶子结点
                //左递归
                getCodes(node.getLeft(), "0", stringBuilder1);
                getCodes(node.getRight(), "1", stringBuilder1);
            } else { //叶子结点
                //表示找到了某个叶子结点的最后
                huffmanCodes.put(node.getData(), stringBuilder1.toString());
            }
        }
    }

    /**
     * 重载
     *
     * @param root
     * @return
     */
    public static Map<Byte, String> getCodes(HuffmanNode root) {

        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.getLeft(), "0", stringBuilder);
        //处理右子树
        getCodes(root.getRight(), "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 字符串对应的byte[]数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码压缩后的Byte
     *
     * @param bytes        原始的字符串
     * @param huffmanCodes 生成的哈夫曼编码map
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1、利用huffmanCodes 将 bytes 转成 哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组，根据字典进行编码
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //2、统计返回的 byte[] huffmanCodeBytes 长度
        //int len = (stringBuilder.length() + 7)/8
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩后的byte数组
        byte[] buffmanCodeBytes = new byte[len];
        int index = 0;//记录第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//每8位对应一个Byte，所以步长+8
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成一个Byte，放入到by
            buffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return buffmanCodeBytes;

    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public static void preOrder(HuffmanNode node) {
        if (node != null) {
            node.preOrder(node);
        }
    }


}
