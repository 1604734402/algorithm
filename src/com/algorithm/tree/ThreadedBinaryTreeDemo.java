package com.algorithm.tree;

import javax.swing.event.TreeExpansionEvent;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "�޼���ʥ");
		HeroNode node2 = new HeroNode(3, "���˷�ʦ");
		HeroNode node3 = new HeroNode(6, "���罣��");
		HeroNode node4 = new HeroNode(8, "Ӱ��֮��");
		HeroNode node5 = new HeroNode(10, "���Ů��");
		HeroNode node6 = new HeroNode(14, "���Ӱ");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setRight(node6);
		
		ThreadBinaryTree tree = new ThreadBinaryTree();
		tree.setRoot(root);
		tree.threadedNodes();
		
		HeroNode temp = node4;
		
//		System.out.println(temp.getLeft()+"--"+temp.getRight());
//		while(true) {
//			if (temp == null) {
//				return;
//			}
//			System.out.println(temp.getNo()+"-----"+temp.getName());
//			temp = temp.getRight();
		
//		}
		tree.threeadedList();
	}
	
	

}
//������������
class ThreadBinaryTree {
	private HeroNode root;
	
	//Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ�ڵ��ǰ���ڵ��ָ��
	//�ڵݹ����������ʱ��ppre ���Ǳ���ǰһ���ڵ�
	private HeroNode pre= null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	
	public void threeadedList() {
		//����һ�������洢��ǰ�����Ľڵ㣬��root��ʼ
		HeroNode node = root;
		while(node != null) {
			//ѭ���ҵ�leftType == 1�Ľڵ㣬��һ���ҵ�����8�ڵ�
			//�������ű������仯����Ϊ��leftType ==1 ʱ��˵�ýڵ��ǰ���������
			//��������Ч�ڵ�
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			//��ӡ��ǰ����ڵ�
			System.out.println(node);
			//�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬��һֱ���
			while(node.getRightType() ==1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	//��д�Զ��������������������ķ�ʽ
	public void threadedNodes(HeroNode node) {
		
		//�����ǰ�ڵ�գ�ֱ���˳�
		if (node == null) {
			return;
		}
		
		//1. ������������
		threadedNodes(node.getLeft());
		//2. ��������ǰ�ڵ�
		if (node.getLeft() == null) {
			//�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.setLeft(pre);
			//�޸ĵ�ǰ�ڵ����ָ������ͣ�ָ��ǰ���ڵ�
			node.setLeftType(1);
		}
		//�������ڵ�
		if (pre!=null && pre.getRight() == null) {
			//ǿǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.setRight(node);
			//�޸�ǰ���ڵ����ָ������
			pre.setRightType(1);
		}
		pre = node;
		
		//3. ������������
		threadedNodes(node.getRight());
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

