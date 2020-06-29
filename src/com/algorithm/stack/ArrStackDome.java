package com.algorithm.stack;

import javax.management.RuntimeErrorException;

public class ArrStackDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrStack stack = new ArrStack(3);
		stack.push(0);
		stack.push(1);
		
		stack.pop();
		stack.push(2);
		
		stack.list();
	}

}

class ArrStack{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ��ջ
	private int top = -1;//top ��ʾջ������ʼ��Ϊ-1
	
	public ArrStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ-push
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ�������޷���������");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ����������
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		return stack[top--];
		
	}
	
	//����ʱ����Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		
		for (int i = top; i >=0; i--) {
			System.out.println(stack[i]);
		}
	}
	
	
	
}