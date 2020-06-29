package com.algorithm.Linklist;

import java.util.Stack;

import org.omg.CORBA.IdentifierHelper;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		HeroNode node1 = new HeroNode(1, "��", "�޼���ʥ");
		HeroNode node2 = new HeroNode(2, "��", "Ӱ��֮��");
		HeroNode node3 = new HeroNode(3, "����", "ʱ��̿�");
		HeroNode node4 = new HeroNode(4, "��ϣ", "��������");
		HeroNode node5 = new HeroNode(5, "¬����", "ʥǹ����");
//		
		singleLinkedList.addByOrder(node1);
		singleLinkedList.addByOrder(node2);
		singleLinkedList.addByOrder(node3);
		singleLinkedList.addByOrder(node4);
//		
		
		
//		singleLinkedList.addByOrder(node2);
//		singleLinkedList.addByOrder(node3);
//		singleLinkedList.addByOrder(node4);
//		singleLinkedList.addByOrder(node1);
		singleLinkedList.list();
		System.out.println("-----------------------");
//		singleLinkedList.delete(3);
//		singleLinkedList.list();
//		long startTime1 = System.currentTimeMillis(); //��ȡ��ʼʱ��
//		for (int i = 0; i < 200000; i++) {
//			HeroNode node12 = new HeroNode(i, "��", "�޼���ʥ");
//			singleLinkedList.addByOrder(node12);
//		}
//		long endTime1 = System.currentTimeMillis(); //��ȡ����ʱ��
//		System.out.println("����ʱ�䣺" + (endTime1 - startTime1) + "ms"); //�����������ʱ��
//		
		
		
//		long startTime = System.currentTimeMillis(); //��ȡ��ʼʱ��
//		System.out.println(singleLinkedList.size());
//		System.out.println(getLength(singleLinkedList.getHead()));
//		long endTime = System.currentTimeMillis(); //��ȡ����ʱ��
//		System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms"); //�����������ʱ��
//		HeroNode node = findLastIndexNode(singleLinkedList.getHead(),1);
//		System.out.println(node==null?"��":node.toString());
//		HeroNode heroNode = new HeroNode(2, "aaa", "bbb");
//		singleLinkedList.deleteAtIndex(0);
//		System.out.println("get0"+singleLinkedList.get(0));
//		singleLinkedList.list();
//		reverseOutByNode(singleLinkedList.getHead());
	}
	
	private static void reverseOutByNode(HeroNode head) {
		// TODO Auto-generated method stub
		HeroNode temp = head.next;
		Stack<HeroNode> stack = new Stack<>();
		while(true) {
			stack.push(temp);
			if (temp.next == null) {
				break;
			}
			
			temp = temp.next;
		}
		System.out.println(stack.size());
		while(stack.size()>0) {
			System.out.println(stack.pop().toString());
		}
		
	}

	public static void reversetList(HeroNode head) {
		//�����ǰ����Ϊ�գ�����ֻ��һ�ڵ㣬���뷭ת��ֱ�ӷ���
		if (head.next ==null || head.next .next ==null) {
			return;
		}
		//����һ������ָ��(����)���������Ǳ���ԭ��������
		HeroNode cur = head.next;
		//ָ��ǰ�ڵ�[cur]����һ���ڵ�
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ������𣬲������µ�����reverseHead ����ǰ��
		while(cur != null) {
			//���浱ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʹ��
			next = cur.next;
			//��cur����һ���ڵ�ָ���µ��������ǰ��
			cur.next = reverseHead.next;
			//�����µĽڵ�˳�򱣴� ��cur ���ӵ��µ�������
			reverseHead.next = cur;
			//��cur����
			cur = next;
		}
		//��head.next ָ��reverseHead.next,ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
		
	}
	
	//ͨ������ͷ�����ѭ�����Ҹ���
	public static int getLength(HeroNode head) {
		if (head.next ==null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) {
			length ++;
			cur = cur.next;
		}
		return length;
	}

	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//����Ϊ�գ�ֱ�ӷ���Null
		if (head.next ==null) {
			return null;
		}
		//ѭ�������õ�����
		int size = getLength(head);
		//�������С�ڵ���0���ߴ��������ȣ���ֱ�ӷ���null
		if (index<=0 || index>size) {
			return null;
		}
		//�����������������forѭ����λ��������index
		HeroNode temp = head.next;
		for (int i = 0; i < size-index; i++) {
			temp = temp.next;
		}
		return temp;
	}

}

class SingleLinkedList{
	//��ʼ��ͷ��㣬ͷ���̶�
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}
	
	public int get(int index) {
		// TODO Auto-generated method stub
	        
	        HeroNode temp = head.next;
	        Boolean flag = true;
	        for(int i = 0;i<index;){
	            if(temp.next == null){
	                flag = false;
	                break;
	            }
	            temp = temp.next;
	            flag = true;
	            i++;
	        }
	        if(flag){
	            return temp.no;
	        }else{
	            return -1;
	        }
	        
	    
	}

	public void deleteAtIndex(int index) {
		// TODO Auto-generated method stub
		HeroNode temp1 = head.next;
        int size = 1;
        while(true){
            if(temp1.next == null ){
                break;
            }
            temp1 = temp1.next;
            size++ ;
        };
        System.out.println("size"+size);
        if(index >size || index <0){
            return;
        }
        HeroNode temp = head.next;
        Boolean flag = true;
        for(int i= 0;i<index-1;){
        	System.out.println("---------------");
            if(temp.next == null){
                flag = false;
                break;
            }
            temp = temp.next;
            flag = true;
            i++;
        }
        
        System.out.println("tempnext"+temp.next.no);
        if(flag){
        	System.out.println("````````````````````````````````````````````````");
        	if (index ==0) {
				head.next = temp.next;
			}
            temp = temp.next;
        }
        System.out.println("temp"+temp.no);
	}

	public void addofindex(int index, HeroNode heroNode) {
		// TODO Auto-generated method stub
        HeroNode temp = head.next;//�������е�0�����±�
        for(int i = 0;i<index-2;){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
            i++;
        }
        System.out.println(temp.no);
        if(temp.next == null){
        	
            temp.next = heroNode;
        }else{
        	System.out.println("----------------");
        	heroNode.next = temp.next.next;
            temp.next = heroNode;
        }  

	}

	//��ӽڵ㵽��������
	//˼·�������Ǳ��˳��ʱ
	//1���ҵ���ǰ��������ڵ�
	//2�����������ڵ��next ָ�� �µĽڵ�
	public void add(HeroNode heroNode) {
		 
		//head�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode temp  = head;
		//���������ҵ����
		while(true) {
			//�ҵ���������
			if (temp.next == null) {
				break;
			}
			//���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		//��while�˳�ѭ��ʱ��temp��ָ������������
		//���������ڵ��next ָ�� �µĽڵ�
		temp.next = heroNode;
	}
	
	public void addByOrder(HeroNode heroNode) {
		//��Ϊͷ�ڵ㲻�ܶ�����Ȼͨ��һ������ָ���������ҵ���ӵ�λ��
		//��Ϊ�ǵ��������������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode temp = head;
		Boolean flag = false;
		while (true) {
			//���Ϊ�վͷ���
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {//λ���ҵ�������temp�ĺ������
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if (flag) {
			System.out.println(heroNode.no+"�Žڵ��ظ�");
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	//�޸Ľڵ����Ϣ
	//���ݴ���ڵ��ID���޸�
	public void update(HeroNode heroNode) {
		//�����ж������Ƿ�Ϊ�գ����Ϊ�գ�ֱ�ӷ���
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//���帨���ڵ�
		HeroNode temp = head;
		//�����Ƿ��ҵ�����ڵ�
		Boolean flag = false;
		while (true) {
			//��������
			if (temp.next == null) {
				break;
			}
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
			
		}
		//����flag �ж��Ƿ��ҵ�Ҫ��ĵĽڵ�
		if (flag) {
			temp.name = heroNode.name;
			temp.nickname = heroNode.nickname;
		}else { //û���ҵ�����ڵ�
			System.out.println("û���ҵ�"+heroNode.no+"����ڵ�");
		}
		
	}
	
	//ɾ���ڵ�
	public void delete(int no) {
		//����Ϊ�գ�ֱ�ӷ�����ʾ
		if (head.next == null) {
			System.out.println("�������Ϊ��");
			return;
		}
		//�����ڵ�
		HeroNode temp = head;
		//��ʾ�Ƿ���ָ������ɾ���Ľڵ�
		boolean flag = false;
		
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("û���ҵ�ָ���Ľڵ�");
		}
	}
	
	//��ʾ����
	public void list() {
		//�ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//ͷ��㲻�۶��������Ҫһ����������������
		HeroNode temp  = head.next;
		while (true) {
			//�ж��Ƿ����������
			if (temp == null) {
				break;
			}
			//����ڵ���Ϣ
			System.out.println(temp.toString());
			//��temp
			temp = temp.next;
		}
	}

	//�ݹ��ȡ������Ľڵ����
	public int size() {
		int num = 0;
		HeroNode temp = head.next;
		if (temp ==null) {
			System.out.println("����Ϊ��");
			return num;
		}else {
			return numbers(++num,temp.next);
		}
		
	}
	//�ݹ���Ҹ���
	public int numbers(int num, HeroNode next) {
		if (next == null) {
			return num;
		}else {
			return numbers(++num,next.next);
		}
	}
	
	
	
	
}

//����HerNode��ÿ��HeroNode �������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//����ָ����һ���ڵ�
	
	//������
	public HeroNode(int hNo,String name,String nickname) {
		this.no = hNo;
		this.name = name;
		this.nickname = nickname;
	}

	//��дtoString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname+ "]";
	}
}
