package com.data_structure.linkedlist;

public class LinkedListQuery {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(new HeroNode(1,"1","1"));
        linkedList.add(new HeroNode(2,"2","2"));
        linkedList.add(new HeroNode(3,"3","3"));

        linkedList.list();
        System.out.println("---");
        HeroNode head = linkedList.getHead();
        HeroNode node = linkedList.reverLinkedList(head);

        HeroNode temp = node.next;
        while (temp!=null){
            System.out.println(temp.toString());

            temp = temp.next;
        }

    }
}
