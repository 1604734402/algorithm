package com.data_structure.linkedlist;

/**
 * 链表
 * 1、链表是以节点的方式来存储的,链式存储
 * 2、每个节点包含data域,next域，next域指向下一个节点
 * 3、链表的各个节点不一定是连续存储的
 * 4、链表分为带头结点的链表和没有头结点的链表，根据实际需求来确定
 */
public class LinkedListDemo {


    public static void main(String[] args) {
        singleLinkedList();
    }

    static void singleLinkedList(){
        //创建节点
        HeroNode hero1 = new HeroNode(1,"安妮","黑暗之女");
        HeroNode hero2 = new HeroNode(2,"奥拉夫","狂战士");
        HeroNode hero3 = new HeroNode(3,"加里奥","正义巨像");
        HeroNode hero4 = new HeroNode(4,"崔斯特","卡牌大师");
        HeroNode hero5 = new HeroNode(5,"赵信","德邦总管");
        HeroNode hero6 = new HeroNode(2,"易","无极剑圣");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero5);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero5);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();
        System.out.println("---更新后---");
//        singleLinkedList.update(hero6);
        singleLinkedList.delete(1);
        singleLinkedList.delete(5);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        singleLinkedList.list();
    }
}
