package com.leetcode;

import com.common.ListNode;
import com.common.Node;

import java.util.List;

/**
 * @auther liuyiming
 * @date 2021/3/27 10:39
 * @description
 */
public class LeetCode_61 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = rotateRight(n1, 10);
        System.out.println(listNode);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        ListNode cur = head;


        //算出链表长度
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }




        int i = 0;
        while(i<length-(k%length)-1){
            cur = cur.next;
            i++;
        }

        if (k%length == length){
            return head;
        }

        //计算出旋转，也就是把末尾提前的头结点
        ListNode lastNode = getLastNode(head,length-(k%length));
        ListNode lastfalin = lastNode;
        ListNode lasttemp = lastNode;

        cur.next = null;

        while(lasttemp.next!=null){
            lasttemp = lasttemp.next;
        }
        lasttemp.next = head;

        return lastfalin;
    }

    public static ListNode getLastNode(ListNode head,int length){

        ListNode temp = head;
        int i = 0;
        while(i<length){
            temp = temp.next;
            i++;
        }
        return temp;

    }



}
