package com.algorithm.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArray queue = new CircleArray(4);
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
				int sc = 0;
				try {
					sc = scanner.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("��������");
					break;
				}
				
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
					System.out.println("ͷ����"+queue.headQueue());;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case "l":
				try {
					System.out.println("��������"+queue.lastqueue());
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case "gf":
				System.out.println("ͷָ�룺"+queue.getFront());
				break;
			case "gr":
				System.out.println("βָ�룺"+queue.getRear());
				break;
			case "exit":
				flag = false;
				break;
			default:
				break;
			}
			
		}
	}
}
class CircleArray{
	//������������
	private int maxSize;
	//����ͷ front��ָ����еĵ�һ��Ԫ�أ�Ҳ����˵arr[front]���Ƕ��еĵ�һ��Ԫ��
	private int front = 0;
	//����β rearָ����е����һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�һ���ռ���ΪԼ��
	private int rear = 0;
	//���������ڴ�����ݣ�ģ�����
	private int arr[];
	
	//��ʼ����������������ж����ȡģ�㷨�£�ʵ�ʿ������鳤��ΪarrMaxSzie-2
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}
	
	//�ж��Ƿ����
	public boolean isFull() {
		//�����ڳ�һ��Լ���ռ�
		return (rear + 1) % maxSize == front;
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
		//ֱ�ӽ����ݼ����β�������Ƚ�����������������β
		arr[rear] = n;
		//��rear��β���ƣ�������뿼��ȡģ��
		//rearָ�����һ��Ԫ�صĺ�һλ������ֱ�Ӳ���
		//����������������һȡģ�����¸�ֵ���൱���ִӶ���ͷ��ʼ����
		rear = (rear+1)%maxSize;
	}
	
	//��ȡ���е�����(������)
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		// ������Ҫ������ front ��ָ����еĵ�һ��Ԫ��
		//1. �Ȱ� front ��Ӧ��ֵ���浽һ����ʱ������Ҫ�������ʱ��������
		int value = arr[front];
		//2.�� front ���ƣ���ʱ��һ��Ԫ���Ѿ����ӣ�ָ����ָ���һ��Ԫ��
		front = (front+1) % maxSize;
		//3.����ʱ����ı�������,����ǰָ���ָ��ָ���൱��ɾ����Ԫ�أ�Ҳ���ǳ���
		return value;
	}
	
	//��ʾ���е���������
	public void showQueue() {
		//��������
		if(isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return;
		}
		//˼·:��front��ʼ������������Ч����
		for (int i = 0; i < size(); i++) {
			System.out.printf("arr[%d]=%d\n",i % maxSize ,arr[i % maxSize]);
		}
	}
	
	//�����ǰ������Ч���ݵĸ���
	public int size() {
		//����
		// rear = 2;front = 1;maxSize = 3
		//rear��ȥfront�ĳ��Ⱦ��൱���м�����Ч�ֶ�
		//��������ѭ�����У��������б�ʾ���п�����С���±��ȥ����±꣬����Ȼ�ǲ����ʵ�
		//����ͷ��������
		//1��front<rear ��ֱ����������Ϊ������ֱ�ӷ���
		//2��front>rear ֱ�������ø�����������rear������󳤶�������������ֱ���������ô��һ��������Ƕ����maxSize�ĳ���
		//����rear��ָ��������һ��Ԫ�صĺ�һ��Ԫ�أ������ټ�����󳤶ȼ�ȥfront������󳤶�ȡģ��,�ó��Ǹ�����ȷ����
		return (rear + maxSize - front) % maxSize;
	}
	
	//��ʾ���е�ͷ���ݣ�����ȡ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		//����frontָ���һ�������ӵ�ֵ������ֱ�ӷ���
		return arr[front];
	}
	
	public int lastqueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[(rear+maxSize-1) %maxSize];
	}
	
	//��ȡ��ǰͷָ��
	public int getFront() {
		return front;
	}
	//��ȡ��ǰβָ��
	public int getRear() {
		return rear;
	}
	
}