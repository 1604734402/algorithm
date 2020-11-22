package com.data_structure.linkedlist;

/**
 * 双向链表
 * 1、遍历方式和单链表一样，可以向前，也可以向后
 * 2、查找时候，先找到最后一个，让最后一个的next指向新节点，新节点的pre指向最后一个
 * 3、修改的思路和单链表一样
 * 4、删除时，可以自我删除
 */
public class DoubleLinkedList {

    private DoubleNode head = new DoubleNode(0,"","");

    public DoubleNode getHead() {
        return head;
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(DoubleNode node){
        //因为head节点永远指向第一个,所以需要一个辅助指针来进行遍历
        DoubleNode temp = head;
        //遍历链表,直到找到最后一个
        while (temp.next != null) {
            //如果不是最后,则temp后移
            temp = temp.next;
        }
        //形成双向链表，新节点的后一个要指向前一个
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 根据顺序添加
     */
    public void addByOrder(DoubleNode node){

        DoubleNode temp = head;
        while (true) {
            //如果循环到了最后一个，则证明新加入的节点比所有节点都要大
            if (temp.next == null) {
                if (temp.no!=node.no){
                    temp.next = node;
                    node.pre = temp;
                }else {
                    System.out.println("此位置有人了！" + node.no);
                    break;
                }
                break;
            }
            //如果节点值相同，则冲突，给出提示
            if (node.no == temp.no) {
                System.out.println("此位置有人了！" + node.no);
                break;
            }
            //如果节点值刚好比这一个小，比前一个大，则就是当前位置，直接插入
            if (node.no > temp.no && node.no < temp.next.no) {
                temp.next.pre = node;
                node.next = temp.next;
                node.pre = temp;
                temp.next = node;

                break;
            }
            //temp指向下一个节点
            temp = temp.next;
        }
    }

    /**
     * 更新节点
     * 根据新节点no来更新对应no节点
     * @param node
     */
    public void update(DoubleNode node){
        DoubleNode temp = head;

        while (temp!=null){
            if (temp.no == node.no){
                temp.name = node.name;
                temp.nickName = node.nickName;
                break;
            }
            if (temp.next == null){
                System.out.println("没有对应的数据");
                return;
            }
            temp = temp.next;
        }
    }


    /**
     * 删除节点
     * @param no
     */
    public void delete(int no){

        DoubleNode temp = head.next;

        while (temp != null){
            if (temp.no == no){
                temp.pre.next = temp.next;
                if (temp.next !=null){
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 遍历链表
     * @param head
     */
    public void list(DoubleNode head){
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头结点不能动，因此需要一个辅助遍历来遍历
        DoubleNode temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }


}
