package com.algorithm.Linklist;

public class DoubleLinkListDemo {

	public static void main(String[] args) {
		
		HeroNode2 node1 = new HeroNode2(1, "��", "�޼���ʥ");
		HeroNode2 node2 = new HeroNode2(2, "��", "Ӱ��֮��");
		HeroNode2 node3 = new HeroNode2(3, "����", "ʱ��̿�");
		HeroNode2 node4 = new HeroNode2(4, "��ϣ", "��������");
		
		DoubleLinkList doubleLinkList = new DoubleLinkList();
		doubleLinkList.addByOrder(node2);
		doubleLinkList.addByOrder(node1);
		doubleLinkList.addByOrder(node4);
		
		doubleLinkList.addByOrder(node3);
		
		doubleLinkList.list();
		System.out.println("---------------------------");
//		HeroNode2 node5 = new HeroNode2(3, "��ʯ", "����������");
//		doubleLinkList.update(node5);
////		doubleLinkList.list();
//		
//		doubleLinkList.delete(4);
//		doubleLinkList.list();
		
	}

}

class DoubleLinkList {
	private HeroNode2 head;

	public DoubleLinkList() {
		head = new HeroNode2(0, "", "");
	}
	public HeroNode2 getHead() {
		return head;
	}

	// ��ӵ�β��
	public void add(HeroNode2 heroNode) {
		// head�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode2 temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ���������
			if (temp.next == null) {
				break;
			}
			// ���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		// ��while�˳�ѭ��ʱ��temp��ָ������������
		// ���������ڵ��next ָ�� �µĽڵ�
		temp.next = heroNode;
		// ��Ϊ��˫�����������¼���Ľڵ��ͷָ��Ҫָ��ԭ���������һ��node
		heroNode.pre = temp;
	}
	public void addByOrder(HeroNode2 heroNode) {
		//��Ϊͷ�ڵ㲻�ܶ�����Ȼͨ��һ������ָ���������ҵ���ӵ�λ��
		//��Ϊ�ǵ��������������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode2 temp = head;
		Boolean flag = false;
		while (true) {
			//���Ϊ�վͷ���
			if (temp.next == null) {
				break;
			}
			if (temp.no > heroNode.no) {//λ���ҵ�������temp�ĺ������
				break;
			}else if(temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if (flag) {
			System.out.println(heroNode.no+"�Žڵ��ظ�");
		}else {
			if (temp.pre==null || temp.no<heroNode.no) {
				temp.next = heroNode;
				heroNode.pre = temp;
			}else {
				temp.pre.next = heroNode;
				heroNode.pre = temp.pre;
				temp.pre = heroNode;
				heroNode.next = temp;
			}
			
		}
		
	}

	public void update(HeroNode2 heroNode) {
		// �����ж������Ƿ�Ϊ�գ����Ϊ�գ�ֱ�ӷ���
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ���帨���ڵ�
		HeroNode2 temp = head.next;
		// �����Ƿ��ҵ�����ڵ�
		Boolean flag = false;
		while (true) {
			// ��������
			if (temp.next == null) {
				break;
			}
			// �ҵ�����ڵ�
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;

		}
		// ����flag �ж��Ƿ��ҵ�Ҫ��ĵĽڵ�
		if (flag) {
			temp.name = heroNode.name;
			temp.nickname = heroNode.nickname;
		} else { // û���ҵ�����ڵ�
			System.out.println("û���ҵ�" + heroNode.no + "����ڵ�");
		}
	}

	// ɾ���ڵ�
	// ����˫���������ǿ���ֱ���ҵ�Ҫɾ��������ڵ�
	// �ҵ��Ժ��������ɾ��
	public void delete(int no) {
		// ����Ϊ�գ�ֱ�ӷ�����ʾ
		if (head.next == null) {
			System.out.println("�������Ϊ��");
			return;
		}
		// �����ڵ�
		HeroNode2 temp = head;
		// ��ʾ�Ƿ���ָ������ɾ���Ľڵ�
		boolean flag = false;

		while (true) {
			//�Ѿ��ҵ��������ڵ��next��
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			//�������� temp.next = temp.next.next;
			temp.pre.next = temp.next;
			//��������һ���ڵ㣬�Ͳ���Ҫִ��������仰
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		} else {
			System.out.println("û���ҵ�ָ���Ľڵ�");
		}
	}

	// ��ʾ����
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ͷ��㲻�۶��������Ҫһ����������������
		HeroNode2 temp = head.next;
		while (true) {
			// �ж��Ƿ����������
			if (temp == null) {
				break;
			}
			// ����ڵ���Ϣ
			System.out.println(temp.toString());
			// ��temp
			temp = temp.next;
		}
	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;// ����ָ����һ���ڵ㣬Ĭ��Ϊnull
	public HeroNode2 pre;// ָ��ǰһ���ڵ㣬Ĭ��Ϊnull

	// ������
	public HeroNode2(int hNo, String name, String nickname) {
		this.no = hNo;
		this.name = name;
		this.nickname = nickname;
	}

	// ��дtoString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}