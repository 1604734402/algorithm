package com.algorithm.Linklist;

import java.awt.Frame;

public class Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
		linkedList.addBoy(5);
//		linkedList.showBoy();

		linkedList.countBoy(1, 2, 5);
	}

}

class CircleSingleLinkedList {
	// ����һ��first�ڵ㣬��ǰû�б��
	private Boy first = new Boy(0);

	// ���С���ڵ㣬������һ�����ε�����
	public void addBoy(int nums) {
		// ����У��
		if (nums < 1) {
			System.out.println("�����ֵ����ȷ");
			return;
		}
		Boy curBoy = null;// ����ָ�룬����������������
		// ʹ��for���������ǵĻ�������
		for (int i = 1; i <= nums; i++) {
			// ���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			// ����ǵ�һ��С��
			if (i == 1) {
				first = boy;
				first.setNext(first);// ���ɻ�
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}

	}

	public void showBoy() {

		if (first == null) {
			System.out.println("û���κ�С��");
		}

		Boy curBoy = first;
		while (true) {
			System.out.println("���Ϊ��" + curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// �����û������룬�����С����Ȧ��˳��
	/**
	 * 
	 * @param startNo  ��ʾ�ӵڼ���С����ʼ����
	 * @param countNum ��ʾÿ��������
	 * @param nums     ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		// �ȶ����ݽ���У��
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("��������������������");
			return;
		}
		// ����Ҫ������ָ�룬�������С����Ȧ
		Boy helper = first;
		// ���󴴽�һ����������ָ��(helper),����Ӧָ�����������������ڵ�
		while (true) {
			if (helper.getNext() == first) {// ˵��Helperָ�����С���ڵ�
				break;
			}
			helper = helper.getNext();
		}

		// С������ǰ������first ��helper �ƶ�K-1��
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		// ��С������ʱ����first��helperָ��ͬʱ���ƶ�M-1�Σ�Ȼ���Ȧ
		// ������һ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
		while (true) {
			if (helper == first) {// ˵��Ȩ��ֻ��һ���ڵ�
				break;
			}
			// ��first��helperָ��ͬʱ���ƶ�countNum-1
			for (int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			// ����firstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
			System.out.println(first.getNo() + "Ҫ��Ȧ");
			// ��ʱ��firstָ���С���ڵ��Ȧ
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("�������Ȧ��С�������" + first.getNo());
	}
}

//����һ��Boy�࣬��ʾһ���ڵ�
class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}