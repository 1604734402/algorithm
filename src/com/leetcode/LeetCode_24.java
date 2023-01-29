package com.leetcode;

import com.common.Node;
import com.common.Util;

/**
 * @auther liuyiming
 * @date 2021/4/10 16:32
 * @description
 */
public class LeetCode_24 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Node node = swapPairs(n1);

        Util.printNode(node);
    }

    public static Node swapPairs(Node head) {

//        if (head == null || head.next == null){
//            return head;
//        }
//
//        Node cur = head;
//        Node last = cur;
//        int count = 0;
//        while (cur.next!=null){
//            if (count%2 == 0 || cur.next!=null){
//                Node temp = cur.next;
//                cur = cur.next;
//
//                temp = cur;
//                last = temp;
//            }
//
//        }
//        return last;

        //创建一个头结点前驱节点
        Node preHead = new Node();
        //将这个前驱节点指向需要操作链表的头结点
        preHead.next = head;
        //定义一个临时节点来操作前驱节点
        Node temp = preHead;
        //如果说下一个没有了，或者说只剩一个，那么就不用进行操作了
        while (temp.next != null && temp.next.next != null) {
            //左边节点
            Node left = temp.next;
            //右边节点
            Node right = temp.next.next;
            //先保存要转换的后一个
            temp.next = right;
            //将【前一个】指向【后一个】的下一个
            left.next = right.next;
            //将【后一个】指向【前一个】
            right.next = left;
            //将当前替换为前一个
            temp = left;
        }
        return preHead.next;



    }

}
