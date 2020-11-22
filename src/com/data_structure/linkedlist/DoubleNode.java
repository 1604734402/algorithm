package com.data_structure.linkedlist;

/**
 * 定义一个DoubleNode,每个DoubleNode对象就是一个节点
 */
public class DoubleNode {

    public int no;
    public String name;
    public String nickName;
    public DoubleNode next;
    public DoubleNode pre;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickName
     */
    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    /**
     * 方便查看
     * @return
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
