package com.data_structure.linkedlist;

import com.common.Node;

/**
 * 单向环形链表，用于解决约瑟夫问题
 * <p>
 * 构建思路
 * 1、创建一个first节点，让该节点指向自己，并形成环路
 * 2、每创建一个新节点，结巴该节点，加入到已有的环形链表中
 * <p>
 * 遍历思路
 * 1、让一个辅助指针cur节点,指向first节点
 * 2、通过一个while循环遍历该环形联播即可
 * 3、当cur.next等于first节点时，遍历结束
 */
public class CircleSingLinkedList {

    //创建一个节点，当前没有编号
    private Node first;

    /**
     * 添加节点
     * 构成一个环形链表
     *
     * @param nums
     */
    public void initLinkedList(int nums) {
        if (nums < 2) {
            System.out.println("编号有误！");
            return;
        }
        Node cur = null;//辅助指针，帮助构建环形链表
        //使用for循环来初始化单向环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建节点
            Node node = new Node(i);

            if (i == 1) {
                //初始化第一个节点
                first = node;
                //构成环状
                first.setNext(first);
                //给辅助指针赋值
                cur = first;
                continue;
            }
            //先将辅助节点的下一个指向新节点
            cur.setNext(node);
            //将新节点指向第一个节点
            node.setNext(first);
            cur = node;

        }

    }

    /**
     * 遍历环形链表
     */
    public void showList() {

        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        //辅助指针
        Node cur = first;

        //如果遍历到辅助指针等于第一个指针，那么就说明遍历完成
        do {
            System.out.println(cur.getNo());
            cur = cur.getNext();
        } while (cur != first);
    }

    /**
     * 需要先创建一个辅助指针，应指向环形链表的最后一个指针
     * 当遍历时，让first和Helper指针同时移动m-1次
     * 这时就可以将first指向的节点出列
     *
     * @param startNo  表示从第几个节点开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个节点
     */
    public void checkOut(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误");
            return;
        }
        //让第一个指针先移动到要开始遍历的节点
        for (int i = 0; i < startNo-1 ; i++) {
            first = first.getNext();
        }

        //创建辅助指针
        Node pre = first;
        //将辅助指针指向环形链表最后一个节点
        while (pre.getNext() != first){
            pre = pre.getNext();
        }

        //当队列只有一个节点时，退出
        while (pre != first){
            //让first节点和pre节点同时移动 countNum-1 次
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                pre = pre.getNext();
            }
            //出队
            System.out.println("节点编号："+first.getNo());
            first = first.getNext();
            pre.setNext(first);
        }
        System.out.println("最后一个节点:"+first.getNo());
    }

}
