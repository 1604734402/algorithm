package com.data_structure.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList {

    //初始化头结点，不存放具体数据，用于管理此链表
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单项链表
     * <p>
     * 不考虑编号顺序时
     * 1、找到当前链表的最后节点
     * 2、将最后这个节点的Next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {

        //因为head节点永远指向第一个,所以需要一个辅助指针来进行遍历
        HeroNode temp = head;
        //遍历链表,直到找到最后一个
        while (temp.next != null) {
            //如果不是最后,则temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 根据Node的no属性来进行顺序插入
     * 1、首先找到要新提那家节点的位置,通过辅助变量
     * 2、新的节点的next等于辅助节点的next域
     * 3、将辅助节点的next域指向新加入节点
     * 因为头结点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
     * 由于是单链表，而我们找的temp是位于添加位置的前一个节点，否则插入不了
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {

        HeroNode temp = head;
        plan1:{
            while (true) {
                //如果循环到了最后一个，则证明新加入的节点比所有节点都要大
                if (temp.next == null) {
                    temp.next = heroNode;
                    break;
                }
                //如果节点值相同，则冲突，给出提示
                if (heroNode.no == temp.no) {
                    System.out.println("此位置有人了！" + heroNode.no);
                    break;
                }
                //如果节点值刚好比这一个小，比前一个大，则就是当前位置，直接插入
                if (heroNode.no > temp.no && heroNode.no < temp.next.no) {
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    break;
                }
                //temp指向下一个节点
                temp = temp.next;
            }
        }

//        plan2:{
//            //判断所添加的编号是否存在
//            boolean flag = false;
//            //如果循环到列表最后，则退出
//            while (temp.next != null){
//                //找到位置，应在temp.next之前，temp之后
//                if (temp.next.no > heroNode.no){
//                    break ;
//                }
//                //如果相等，则说明冲突
//                if (temp.next.no == heroNode.no){
//                    flag = true;
//                    break ;
//                }
//                temp = temp.next;
//            }
//            //如果有值冲突，则直接返回并给出提示
//            if (flag) {
//                System.out.println("此位置有人了！" + heroNode.no);
//                return;
//            }else {
//                //插入链表中
//                heroNode.next = temp.next;
//                temp.next = heroNode;
//            }
//
//        }

    }

    /**
     * 根据新节点的no来进行重新赋值
     * @param newNode
     */
    public void update(HeroNode newNode){

        HeroNode temp = head;

        while (temp!=null){
            if (temp.no == newNode.no){
                temp.name = newNode.name;
                temp.nickName = newNode.nickName;
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
     * 由于链表的next域指向下一个，所以删除一个节点直接node.next.next
     * 中间的node则由JVM回收
     * @param no
     */
    public void delete(Integer no){

        HeroNode temp = head;

        while (temp.next != null){
            if (temp.next.no == no){
                temp.next = temp.next.next;
            }
            if (temp.next == null){
                System.out.println("未查到此节点");
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 显示链表所有值
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为头结点不能动，因此需要一个辅助遍历来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /**
     * 翻转单链表
     * @param head
     * @return
     */
    public HeroNode reverLinkedList(HeroNode head){
        if (head == null || head.next == null){
            return null;
        }
        //新建临时存储翻链表
        HeroNode reverNode = new HeroNode(0,null,null);
        HeroNode temp = head.next;
        HeroNode cur = new HeroNode(111,"111","111");


        while (temp!=null){
            cur = temp.next;
            temp.next =reverNode.next;
            //经过上一步后，temp.next就已经等于Null了
            reverNode.next = temp;
            //但cur相当于是一个新的节点，为了避免链表断开
            temp = cur;

        }
        head.next = reverNode.next;
        return head;
    }


}
