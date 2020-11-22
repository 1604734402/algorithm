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

//        //SingleLinkedList CRUD
//        singleLinkedList();
//        //ReverSingleLinkedList
//        reverSingleLinkedList();
        doubleLinkedList();
    }

    static void singleLinkedList(){
        //创建节点
        SingleNode hero1 = new SingleNode(1,"安妮","黑暗之女");
        SingleNode hero2 = new SingleNode(2,"奥拉夫","狂战士");
        SingleNode hero3 = new SingleNode(3,"加里奥","正义巨像");
        SingleNode hero4 = new SingleNode(4,"崔斯特","卡牌大师");
        SingleNode hero5 = new SingleNode(5,"赵信","德邦总管");
        SingleNode hero6 = new SingleNode(2,"易","无极剑圣");

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

    static void reverSingleLinkedList(){
        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(new SingleNode(1,"1","1"));
        linkedList.add(new SingleNode(2,"2","2"));
        linkedList.add(new SingleNode(3,"3","3"));

        linkedList.list();
        System.out.println("---");
        SingleNode head = linkedList.getHead();
        SingleNode node = linkedList.reverLinkedList(head);

        SingleNode temp = node.next;
        while (temp!=null){
            System.out.println(temp.toString());

            temp = temp.next;
        }
    }

    static void doubleLinkedList(){

        DoubleLinkedList linkedList = new DoubleLinkedList();
        DoubleNode node1 = new DoubleNode(1,"1","1");
        DoubleNode node2 = new DoubleNode(2,"2","2");
        DoubleNode node3 = new DoubleNode(3,"3","3");
        DoubleNode node4 = new DoubleNode(4,"4","4");
        DoubleNode node5 = new DoubleNode(5,"5","5");
        DoubleNode node6 = new DoubleNode(2,"5","5");

//        linkedList.add(node1);
//        linkedList.add(node2);
//        linkedList.add(node3);
//        linkedList.add(node4);
//        linkedList.add(node5);

        linkedList.addByOrder(node5);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node2);
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node3);

        linkedList.list(linkedList.getHead());

//        linkedList.delete(5);
//        linkedList.update(node6);

        System.out.println("----");
        linkedList.list(linkedList.getHead());
    }


}
