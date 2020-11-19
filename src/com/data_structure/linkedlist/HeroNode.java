package com.data_structure.linkedlist;

/**
 * 定义一个HeroNode,每个HeroNode对象就是一个节点
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickName
     */
    public HeroNode(int no, String name, String nickName) {
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
