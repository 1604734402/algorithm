package com.common;

public class Node {

    public Integer no;
    public Node next;

    public Node() {
    }

    public Node(int no){
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
