package com.algorithm.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String reString = scanner.next();
			
			switch (reString) {
			case "s":
				queue.showQueue();
				break;
			case "a":
				System.out.println("������һ����");
				int sc = scanner.nextInt();
				queue.addQueue(sc);
				break;
			case "g":
				try {
					int res = queue.getQueue();
					System.out.println("ȡ������Ϊ��"+res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "h":
				try {
					queue.headQueue();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case "exit":
				flag = false;
				break;
			default:
				break;
			}
			
			System.out.println("�����˳�");
		}
	}
	
	
}

class ArrayQueue{
	//������������
	private int maxSize;
	//����ͷ
	private int front;
	//����β
	private int rear;
	//���������ڴ�����ݣ�ģ�����
	private int arr[];
	
	//��ʼ����������������ж��
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		//ָ�����ͷǰһ��λ��
		front = -1;
		//ָ�����β����λ�ã����Ƕ������һ������
		rear = -1;
	}
	
	//�ж��Ƿ����
	public boolean isFull() {
		//��β�������һ����Ч�±�
		return rear == maxSize -1;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		//��ͷ���ڶ�β
		return front == rear;
	}
	
	//������ݵ�����(�����)
	public void addQueue(int n) {
		//�ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�����������ܼ�������");
			return;
		}
		//��β����
		rear++;
		//�������
		arr[rear] = n;
	}
	
	//��ȡ���е�����(������)
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		//����ͷ����һλ
		front++;
		//�������ݣ�����Ϊ��ͷ���ƣ����ڶ�ͷָ��ǰ����
		return arr[front];
	}
	
	//��ʾ���е���������
	public void showQueue() {
		//��������
		if(isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	//��ʾ���е�ͷ���ݣ�����ȡ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front+1];
	}
	
	
}





