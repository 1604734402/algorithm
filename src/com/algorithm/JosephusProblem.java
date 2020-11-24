package com.algorithm;

import com.data_structure.linkedlist.CircleSingLinkedList;

/**
 * 约瑟夫问题
 *
 * 设编号为1,2,...n的n个人围坐一圈，
 * 约定编号为k(1<=k<=n)的人从1开始报数,
 * 数到m的那个人出列，它的下一位又从1开始报数，
 * 数到m的那个人又出列，依次类推，直到所有人出列位置
 * 求出列顺序编号
 */
public class JosephusProblem {

    public static void main(String[] args) {
        CircleSingLinkedList linkedList = new CircleSingLinkedList();
        //初始化环形链表内容
        linkedList.initLinkedList(5);
        //遍历环形链表
//        linkedList.showList();
        //输入参数进行计算
        linkedList.checkOut(1,2,5);


    }
}
