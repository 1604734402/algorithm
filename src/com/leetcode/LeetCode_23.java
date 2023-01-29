package com.leetcode;

import com.common.ListNode;

import java.util.List;

/**
 * @auther liuyiming
 * @date 2021/4/24 11:24
 * @description
 */
public class LeetCode_23 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(new int[]{1,2,3,4,5});

        System.out.println(listNode.toString());

//        ListNode list1 = new ListNode(1);
//        ListNode list4 = new ListNode(3);
//        ListNode list3 = new ListNode(4);
//        ListNode list2 = new ListNode(2);
//        ListNode list5 = new ListNode(5);
//        ListNode list6 = new ListNode(6);
//        list1.next = list4;
//        list4.next = list3;
//
//        list2.next = list5;
//        list5.next = list6;


//        System.out.println(list1);
//        System.out.println(list2);

//        ListNode marge = marge(list1, list2);



    }

    public static ListNode marge(ListNode list1,ListNode list2){
        ListNode head = new ListNode();
        ListNode temp = head;

         while(list1!=null && list2!=null){
             if(list1.val>list2.val){
                 temp.next = list2;
                 temp = temp.next;
                 list2 = list2.next;
             }else{
                 temp.next = list1;
                 temp = temp.next;
                 list1 = list1.next;
             }
         }

        temp.next = list1 == null?list2:list1;

        return head;
    }
}
