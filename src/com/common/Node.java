package com.common;

public class Node {

    private Integer no;
    private Node next;

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
}
