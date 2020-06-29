package com.algorithm.tree;

public class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	
	private int leftType;
	private int rightType;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	
	

	public int getLeftType() {
		return leftType;
	}



	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}



	public int getRightType() {
		return rightType;
	}



	public void setRightType(int rightType) {
		this.rightType = rightType;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	// ǰ�����
	public void preOrder() {
		// ��������ڵ�
		System.out.println(this.toString());
		// �ݹ���������ǰ�����
		if (this.left != null) {
			this.left.preOrder();
		}
		// �ݹ���������ǰ�����
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void infixOrder() {
		// �ݹ��������������
		if (this.left != null) {
			this.left.infixOrder();
		}
		// �����ǰ�ڵ�
		System.out.println(this.toString());
		// �ݹ��������������
		if (this.right != null) {
			this.right.infixOrder();

		}
	}

	// �������
	public void postOrder() {
		// �ݹ��������������
		if (this.left != null) {
			this.left.postOrder();
		}
		// �ݹ��������������
		if (this.right != null) {
			this.right.postOrder();
		}
		// ������ڵ�
		System.out.println(this.toString());
	}

	// ǰ���������
	/**
	 * 
	 * @param id ����id ����
	 * @return
	 */
	public HeroNode preOrdersearch(int id) {
		System.out.println(this.no);
		HeroNode resNode = null;
		// �Ƚϵ�ǰ�ڵ��ǲ���
		if (this.no == id) {
			return this;
		}

		// �жϵ��׽ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		if (this.left != null) {
			resNode = this.left.preOrdersearch(id);
		}
		// ��ݹ�����������ҵ��ˣ���ֱ�ӷ��أ�����������Ҳ���
		if (resNode != null) {
			return resNode;
		}

		// �����ݹ�û���ҵ�����ô�ͽ����ҵݹ����
		if (this.right != null) {
			resNode = this.right.preOrdersearch(id);
		}

		// ��ʱ���ҵݹ鶼������ϣ����û�ҵ����򷵻�Null
		return resNode;
	}

	// �������
	public HeroNode infixOrdersearch(int id) {

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrdersearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println(this.no);
		if (this.no == id) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrdersearch(id);
		}
		return resNode;
	}

	// �������
	public HeroNode postOrdersearch(int id) {

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrdersearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrdersearch(id);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println(this.no);
		return this.no == id ? this : null;
	}

	// �ݹ�ɾ���ڵ�
	public void delNode(int id) {
		
		if (this.left != null && this.left.no == id) {
			this.left = null;
			System.out.println("ɾ���ɹ�");
			return;
		}
		
		if (this.right != null && this.right.no == id) {
				this.right = null;
				System.out.println("ɾ���ɹ�");
				return;
		}
		
		if (this.left!=null) {
			this.left.delNode(id);
		}
		
		if (this.right!=null) {
			this.right.delNode(id);
		}
		
		System.out.println("û�д�"+id+"�ڵ�");
	}
	
	public void delNode1(int id) {
		if (this.left != null && this.left.no == id) {
			if (this.left.left!=null && this.left.right == null) {
				this.left = this.left.right;
				System.out.println("ɾ���ɹ�");
				return;
			}else if (this.left.left==null && this.left.right != null) {
				this.left = this.left.left;
				System.out.println("ɾ���ɹ�");
				return;
			}else if (this.left.left!=null && this.left.right!=null) {
				this.left.left.right = this.left.right;
				this.left = this.left.left;
				System.out.println("ɾ���ɹ�------");
				return;
			}
		}
		
		if (this.right != null && this.right.no == id) {
			if (this.right.left!=null && this.right.right == null) {
				this.right = this.right.right;
				System.out.println("ɾ���ɹ�");
				return;
			}else if (this.right.left==null && this.right.right != null) {
				this.right = this.right.left;
				System.out.println("ɾ���ɹ�");
				return;
			}else if (this.right.left!=null && this.right.right!=null) {
				this.right.left.right = this.right.right;
				this.right = this.right.left;
				System.out.println("ɾ���ɹ�------");
				return;
			}
			return;
		}
		
		if (this.left!=null) {
			this.left.delNode(id);
		}
		
		if (this.right!=null) {
			this.right.delNode(id);
		}
		
		System.out.println("û�д�"+id+"�ڵ�");
	}
	

	
	
}
