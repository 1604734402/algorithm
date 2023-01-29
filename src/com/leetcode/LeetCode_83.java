package com.leetcode;

import com.common.Node;
import com.common.Util;
import com.data_structure.linkedlist.SingleNode;

/**
 * @auther liuyiming
 * @date 2021/3/26 10:26
 * @description
 */
public class LeetCode_83 {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        Node node4 = deleteDuplicates(node);

        System.out.println(node4.toString());
    }

    public static Node deleteDuplicates(Node head) {
        Node _head = head;
        Node temp = _head;

        while(temp.next != null){

            if(temp.no == temp.next.no){
                Node next = temp.next;
                while(next.no != temp.no && next.next != null){
                    if (next == null){
                        break;
                    }
                    next = next.next;
                }
                temp.next = next;
            }
            temp = temp.next;
        }

        return _head;
    }
}
