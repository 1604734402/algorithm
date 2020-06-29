package com.algorithm.HashTable;

import java.util.Scanner;

public class HashTabDemo {
	
	public static void main(String[] args) {
		HashTab hashTab = new HashTab(8);
		
		String key = "";
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("����Name");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("�������id");
				int findid = scanner.nextInt();
				hashTab.findEmpById(findid);
				break;
			case "exit":
				scanner.close();
				break;
			default:
				break;
			}
		}
	}
	
}
//����HashTab �����������
class HashTab{
	private EmpLinkList[] empLinkedListArray;
	private int size;//��ʾ��������
	
	//������
	public HashTab(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkList[size];
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkList();
		}
		
	}
	
	//��ӹ�Ա
	public void add(Emp emp) {
		//����Ա����Id���õ���Ա��Ӧ����ӵ��Ǹ�����
		int empLinkedListNO = hashFun(emp.getId());
		//��emp��ӵ���Ӧ��������
		
		empLinkedListArray[empLinkedListNO].add(emp);
		
	}
	
	//��дһ��ɢ�к�����ʹ��һ����ȡģ��
	public int hashFun(int id) {
		return id%size;
	}
	
	//����hash��
	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	public void findEmpById(int id) {
		
//		for (int i = 0; i < empLinkedListArray.length; i++) {
//			Emp resEmp = empLinkedListArray[i].findEmpById(id);
//			if (resEmp!=null) {
//				System.out.println("��"+(i+1)+"������==>"+resEmp.getId()+"---"+resEmp.getName());
//				return;
//			}
//		}
//		System.out.println("û���ҵ�");
		
		
		int empLinkedListNO = hashFun(id);
		Emp resEmp = empLinkedListArray[empLinkedListNO].findEmpById(id);
		if (resEmp!=null) {
			System.out.println("��"+(empLinkedListNO+1)+"������==>"+resEmp.getId()+"---"+resEmp.getName());
			return;
		}
		System.out.println("û���ҵ�");
	}
	
}


//��ʾ��Ա��
class Emp{
	private int id;
	private String name;
	private Emp next; // nextĬ��Ϊ��
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Emp getNext() {
		return next;
	}

	public void setNext(Emp next) {
		this.next = next;
	}

	public Emp(int id,String name) {
		this.id = id;
		this.name = name;
	}
}

//EmpLinkedList����ʾ����
class EmpLinkList{
	//ͷָ�룬ָ���һ��Emp�����������������head ��ֱ��ָ���һ��Emp
	private Emp head;// ͷָ�룬Ĭ��Ϊ��
	
	
	//��ӹ�Ա������
	//�ٶ���ӹ�Աʱ��id���������ģ���id�ķ������Ǵ�С����
	//������ǽ��ù�Աֱ�Ӽ��뵽����������ܼ���
	public void add(Emp emp) {
		//�������ӵ�һ����Ա
		if (head == null) {
			head = emp;
			return;
		}
		//������ǵ�һ����Ա���Ǿ���һ������ָ����ָ�����һ��
		Emp curEmp = head;
		
		while(true) {
			if (curEmp.getNext() == null) {
				break;
			}
			if (curEmp.getId() < emp.getId() && curEmp.getNext().getId() > emp.getId()) {
				emp.setNext(curEmp.getNext());
				curEmp.setNext(emp);
				return;
			}
			curEmp = curEmp.getNext();
		}
		curEmp.setNext(emp);
	}
	
	//����
	public void list(int i) {
		if (head==null) {
			System.out.println("��"+(i+1)+"������Ϊ��");
			return;
		}
		Emp curEmp = head;
		while(true) {
			if (curEmp == null) {
				return;
			}
			System.out.println("��"+(i+1)+"������==>"+curEmp.getId()+"---"+curEmp.getName());
			curEmp = curEmp.getNext();
		}
		
	}
	
	
	//����id���ҹ�Ա��������ҵ����ͷ��أ����û�ҵ����ͷ���Null
	public Emp findEmpById(int id) {
		if (head == null) {
			return null;
		}
		Emp curEmp = head;
		while(true) {
			if (curEmp == null) {
				break;
			}
			
			if (curEmp.getId() == id) {
				break;
			}
			
			curEmp = curEmp.getNext();
		}
		return curEmp;
	}
	
	
	public void delEmp(int id) {
		if (head == null) {
			System.out.println("����Ϊ�գ�����ɾ��");
			return;
		}
		if (head.getId() == id && head.getNext()!=null) {
			head = head.getNext();
			System.out.println("ɾ���ɹ�");
			return;
		}
		if (head.getId() == id && head.getNext() ==null) {
			System.out.println("ɾ���ɹ�");
			return;
		}
		Emp curEmp = head;
		while(true) {
			if (curEmp.getNext() == null) {
				System.out.println("δ���ҵ�");
				return;
			}
			if (curEmp.getNext().getId() == id) {
				if (curEmp.getNext().getNext()!=null) {
					curEmp.setNext(curEmp.getNext().getNext());
					System.out.println("ɾ���ɹ�");
					return;
				}else {
					curEmp.setNext(null);
					System.out.println("ɾ���ɹ�");
					return;
				}
			}
		}
		
	}
	
	
}