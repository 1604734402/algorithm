package com.test;

import com.common.Node;

/**
 * @auther liuyiming
 * @date 2021/10/3 13:56
 * @description 两个有序链表翻转合并为逆序列表
 */
public class ReiverLinkNode {


    private static Node result = new Node();
    private static Node results = result;

    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        init(a, b);
        Node node = reverseNode(a, b);
        System.out.println(node);

    }

    static void init(Node a, Node b) {
        Node a1 = new Node();
        Node a5 = new Node();
        Node a3 = new Node();
        a1.no = 1;
        a1.next = a3;
        a3.no = 3;
        a3.next = a5;
        a5.no = 5;
        a5.next = null;
        a.next = a1;
        Node b2 = new Node();
        Node b4 = new Node();
        Node b6 = new Node();
        Node b7 = new Node();
        Node b8 = new Node();
        b2.no = 2;
        b2.next = b4;
        b4.no = 4;
        b4.next = b6;
        b6.no = 6;
        b6.next = b7;
        b7.no = 7;
        b7.next = b8;
        b8.no = 8;
        b.next = b2;
    }

    static Node reverseNode(Node A, Node B) {
        Node res = new Node();
        Node temp = res;
        Node a = A.next;
        Node b = B.next;

        if (a == null && b != null) {
            return b;
        }
        if (a != null && b == null) {
            return a;
        }

        while (a != null && b != null) {
            if (a.no < b.no) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        if (a == null) {
            temp.next = b;
        }
        if (b == null) {
            temp.next = a;
        }


        return reverLinkList(res.next);
    }

    static Node reverLinkList(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node node = reverLinkList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


}


