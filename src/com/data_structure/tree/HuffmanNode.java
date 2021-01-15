package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/15 17:34
 * @description
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private Byte data; // 存放数据(字符)本身
    private int weight;//权值，表示字符出现的次数

    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(HuffmanNode node){
        if (node.getData() != null){
            System.out.println(node.toString());
        }

        if (node.getLeft()!=null){
            node.preOrder(node.getLeft());
        }

        if (node.getRight()!=null){
            node.preOrder(node.getRight());
        }
    }

    @Override
    public String toString() {
        return "[Data="+this.data+",Weight:"+this.weight+"]";
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight - o.weight;
    }


}
