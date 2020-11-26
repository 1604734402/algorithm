package com.data_structure.stack;

import com.common.Node;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import sun.awt.windows.ThemeReader;

/**
 * 链表模拟栈
 */
public class LinkedListStack {

    private Node head;

    public LinkedListStack(){
        head = new Node();
    }


    public void push(int no){

        Node val = new Node(no);
        Node cur = head;

        while (cur.getNext() != null){
            cur = cur.getNext();
        }

        cur.setNext(val);
    }

    public int pop(){

        Node cur = head;

        if (!isEmpty()){

            while (cur.getNext().getNext() != null){
                cur = cur.getNext();
            }
            int i = cur.getNext().getNo();
            cur.setNext(null);
            return i;
        }else {
            throw new RuntimeException("栈空");
        }


    }

    public void show(){
        Node cur = head.getNext();
        if (!isEmpty()){
            while (cur !=null){
                System.out.println(cur.getNo());
                cur = cur.getNext();
            }
        }else {
            throw new RuntimeException("栈空");
        }

    }

    public void top(){
        Node cur = head;

        if (!isEmpty()){

            while (cur.getNext() != null){
                cur = cur.getNext();
            }
            System.out.println("栈顶为："+cur.getNext().getNo());
        }else {
            throw new RuntimeException("栈空");
        }
    }

    public boolean isEmpty(){
        return head.getNext() == null;
    }
}
