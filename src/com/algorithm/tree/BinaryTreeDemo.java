package com.algorithm.tree;

import java.time.chrono.ThaiBuddhistEra;

import org.omg.CORBA.IdentifierHelper;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		HeroNode root = new HeroNode(1, "�޼���ʥ");
		HeroNode node1 = new HeroNode(2, "���ὣħ");
		HeroNode node2 = new HeroNode(3, "ʱ��̿�");
		HeroNode node3 = new HeroNode(4, "��������");
		HeroNode node4 = new HeroNode(5, "ʥǹ����");

		// �ֶ�����������
		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node4);
		node2.setRight(node3);
		tree.setRoot(root);

//		System.out.println("ǰ�������1��2��3��5��4");
//		tree.preOrder();
//		System.out.println("���������2��1��5��3��4");
//		tree.infixOrder();
//		System.out.println("���������2��5��4��3��1");
//		tree.postOrder();
//		System.out.println("-----ǰ�����-----");
//		System.out.println(root.preOrdersearch(5).toString());

//		System.out.println("-----�������-----");
//		System.out.println(root.infixOrdersearch(5).toString());

//		System.out.println("-----�������-----");
//		System.out.println(root.postOrdersearch(5).toString());
		
		tree.delNode(3);
		System.out.println("-----ǰ�����-----");
		tree.preOrder();

	}
}

//����BinaryTree ������
class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	public HeroNode preOrdersearch(int id) {
		return root == null ? root.preOrdersearch(id) : null;
	}

	public HeroNode infixOrdersearch(int id) {
		return root == null ? root.infixOrdersearch(id) : null;
	}

	public HeroNode postOrdersearch(int id) {
		return root == null ? root.postOrdersearch(id) : null;
	}
	
	public void delNode(int id) {
		if (root == null) {
			System.out.println("��Ϊ��");
			return;
		}
		if (root.getNo() == id) {
			root = null;
			System.out.println("ɾ���ɹ�");
			return;
		}
		root.delNode1(id);
	}

}
