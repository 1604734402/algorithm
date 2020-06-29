package com.algorithm.stack;

public class LinkStackDome {
	public static void main(String[] args) {
		LinkStack linkStack = new LinkStack(3);
		linkStack.push(1);
		linkStack.push(2);
		linkStack.push(3);
		
		linkStack.pop();
		linkStack.pop();
		
		linkStack.push(3);
		
		linkStack.list();
	}
}

class LinkStack{
	private StackNode head;
	private int maxSize;
	
	
	public LinkStack(int maxSize) {
		head = new StackNode(-1);
		this.maxSize = maxSize;
	}
	
	public boolean isEmpty() {
		return head.getNext() == null;
	}
	
	public boolean isFull() {
		StackNode temp = head;
		int size = 0;
		while(true) {
			if (temp.getNext() == null) {
				break;
			}
			size++;
			temp = temp.getNext();
		}
		
		return size == maxSize;
	}
	
	public void push(int value) {
		StackNode  node = new StackNode(value);
		if (isFull()) {
			System.out.println("ջ��");
			return;
		};
		node.setNext(head.getNext());
		
		head.setNext(node);
	}
	
	public void pop() {
		if (isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		head.setNext(head.getNext().getNext());
	}
	
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		StackNode cur = head.getNext();
		while (true) {
			if (cur.getNext() == null) {
				break;
			}
			System.out.println(cur.getValue());
			cur = cur.getNext();
		}
		System.out.println(cur.getValue());
	}
	
}

class StackNode{
	private int value;
	private StackNode next;
	public StackNode(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public StackNode getNext() {
		return next;
	}
	public void setNext(StackNode next) {
		this.next = next;
	}
	
	
}