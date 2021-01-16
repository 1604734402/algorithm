package com.data_structure.tree;


import java.io.*;
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

        byte[] contentBytes = content.getBytes();
//        System.out.println("压缩前："+Arrays.toString(contentBytes));

        byte[] bytes = huffmanZip(contentBytes);
//        System.out.println("压缩后："+Arrays.toString(bytes));

        byte[] decode = decode(huffmanCodes, bytes);
//        System.out.println(new String(decode)+"");

        zipFile("F:\\电影\\进击的巨人第三季\\进击的巨人 第三季 第二集（39）.mp4", "F:\\电影\\进击的巨人第三季\\进击的巨人 第三季 第二集（39）.zip");
        unZipFile("F:\\电影\\进击的巨人第三季\\进击的巨人 第三季 第二集（39）.zip","F:\\电影\\进击的巨人第三季\\解压后.zip");


    }

    /*===================================↓文件压缩↓=======================================*/

    /**
     * 文件压缩
     * @param srcFile 需压缩文件路径
     * @param dstFile 压缩后文件放入目录
     */
    public static void zipFile(String srcFile,String dstFile){

        FileInputStream is = null;
        OutputStream os = null;
        ObjectOutputStream oos = null;

        try {
            //创建输入输出流
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(dstFile);
            //为了写入哈夫曼编码
            oos = new ObjectOutputStream(os);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //哈夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //以对象流的方式写入哈夫曼编码，是为了以后恢复源文件时使用
            oos.writeObject(huffmanCodes);

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            try {
                //关闭输入流
                is.close();
                os.close();
                oos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件解压
     * @param zipFile 准备解压文件
     * @param dstFile 解压文件路径
     */
    public static void unZipFile(String zipFile,String dstFile){

        //定义文件输入流
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            os = new FileOutputStream(dstFile);

            //读取byte数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取哈夫曼编码表
            Map<Byte,String> codes = (Map<Byte,String>)ois.readObject();
            //解码
            byte[] bytes = decode(codes, huffmanBytes);
            //写数据到文件
            os.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /*===================================↑文件压缩↑=======================================*/

    /*===================================↓压缩↓=======================================*/

    /**
     * 哈夫曼压缩
     * 整理压缩过程
     * 1、byte数组转Nodes列表
     * 2、根据Nodes列表创建哈夫曼树
     * 3、根据哈夫曼树生成哈夫曼表
     * 4、根据哈夫曼表和原始数组进行压缩
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
     * 生成节点列表
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
     * 创建哈夫曼树
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
     * 生成编码表
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
     * 压缩
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
            stringBuilder. append(huffmanCodes.get(b));
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



    /*===================================↑压缩↑=======================================*/


    /*===================================↓解压↓=======================================*/

    /**
     * 将byte转二进制字符串
     * @param flag 标志是否需要补高位 如果是最后一个字节就无需补高位
     * @param b
     * @return 按b 对应二进制的字符串(按补码返回)
     */
    public static String byteToBitString(boolean flag,byte b){
        //使用变量保存b
        int temp = b;
        if (flag){
            temp |= 256; //按位与
        }
        //这里返回的是二进制补码
        String str = Integer.toBinaryString(temp);
        if (flag||temp<0){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }

    /**
     * 解码
     * 根据传入编码表与数组进行还原byte
     * 此处仍有问题
     * https://www.bilibili.com/video/BV1E4411H73v?p=123
     * @param huffmanCodes
     * @param huffmanBytes
     * @return
     */
    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){


        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组抓成二进制的字符
        for (int i = 0; i < huffmanBytes.length; i++) {
                boolean flag = (i == huffmanBytes.length-1);
                stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }

        //将哈夫曼编码表调换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
//        System.out.println(map);
/*
        //创建集合存放
        List<Byte> list = new ArrayList<>();
        int byteIndex = 0;
        int byteLength = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            Byte b = null;

            String key = stringBuilder.substring(byteIndex,i);
            b = map.get(key);
//            if (b == null){//说明没有匹配到
////                byteLength++;
////            }else {
////                byteIndex = i;
////                byteLength++;
////                list.add(b);
////            }

            if (b !=null){
                list.add(b);
                byteIndex = i;
            }


 */
        //创建集合存放
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key;
                if (i+count <=stringBuilder.length()){
                    key = stringBuilder.substring(i,i+count);
                }else {
                    key = stringBuilder.substring(i);
                }
                b = map.get(key);

                if (b ==null){
                    count++;
                }else {
                    flag = false;
                }
            }

            list.add(b);
            i += count;

        }

        //当for循环结束后，就存放了所有字符
        //吧list 中的数据放入到byte[] 并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i <b.length ; i++) {
            b[i] = list.get(i);
        }

        return b;

    }

    /*===================================↑解压↑=======================================*/

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
