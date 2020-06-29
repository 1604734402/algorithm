package com.algorithm.tree;

import java.util.function.IntPredicate;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrder(0);
		System.out.println("---------------");
		arrBinaryTree.infixOrder(0);
		System.out.println("---------------");
		arrBinaryTree.postOrder(0);
	}
}

//��дһArrayBinaryTree��ʵ��˳��洢����������
class ArrBinaryTree {
	private int[] arr;// ˳��洢�ڵ������

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}

	// ˳��洢��������ǰ�����
	public void preOrder(int index) {
		// �������Ϊ�գ�����arr.length = 0;
		if (arr == null && arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}
		// �����ǰԪ��
		System.out.println(arr[index]);
		// ��ֹ�±�Խ�磬����ݹ�
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}

		// ��ֹ�±�Խ�磬���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
	}

	// ˳��洢���������������
	public void infixOrder(int index) {
		// �������Ϊ�գ�����arr.length = 0;
		if (arr == null && arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}

		// ��ֹ�±�Խ�磬����ݹ�
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		// �����ǰԪ��
		System.out.println(arr[index]);

		// ��ֹ�±�Խ�磬���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}
	}

	// ˳��洢�������ĺ������
	public void postOrder(int index) {
		// �������Ϊ�գ�����arr.length = 0;
		if (arr == null && arr.length == 0) {
			System.out.println("����Ϊ��");
			return;
		}

		// ��ֹ�±�Խ�磬����ݹ�
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}

		// ��ֹ�±�Խ�磬���ҵݹ�
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}

		// �����ǰԪ��
		System.out.println(arr[index]);
	}
}
