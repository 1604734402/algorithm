package com.algorithm.stack;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		
		String expression = "1+((2+3)*4)-5";
		for(String item:parseSuffixExpressionList(toInfixExpressionList(expression))){
//			System.out.println(item);
		};
		
		System.out.println((parseSuffixExpressionList(toInfixExpressionList(expression))));
		
		// �ȶ���һ���沨�����ʽ
		// (3+4)*5-6 => 30 4 + 5 * 6 -
		// Ϊ�˷��㣬�沨�����ʽ�����ֺͷ���ʹ�ÿո����
//		String suffixExpression = "30 4 + 5 * 6 -";

		// ˼·
		// 1. �Ƚ���3 4 + 5 * 6 -�� => �ŵ�ArrayList��
		// 2. ��ArrayList ���ݸ�һ������������ArrayList ���ջ ��ɼ���
//		List<String> rpnList = getListString(suffixExpression);
//		System.out.println(rpnList);
//		System.out.println(getResult(rpnList));
	}
	
	public static List<String> parseSuffixExpressionList(List<String> ls){
		//��������վ
		Stack<String> s1 = new Stack<>();
		//��Ϊs2���ջ��������ת�������У�û��pop���������һ�Ҫ�������
		//��Ϊ�Ƚ��鷳������ֱ��ʹ��List������
		//State<String> s2 = new Stack<>();
		List<String> s2 = new ArrayList<>();
		
		//����ls
		for(String item:ls) {
			System.out.println(item);
			if (item.matches("\\d+")) {
				s2.add(item);
			}else if (item.equals("(")) {
				s1.push(item);
			}else if (item.equals(")")) {
				//����ǡ�)�������ţ������ε���s1ջ�������������ѹ��s2,ֱ������������Ϊֹ��Ȼ�����������Ŷ���
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//���������������
			}else {
				//��item�����ȼ�С�ڵ���s1ջ�������,��s1ջ���������������ѹ�뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				//����Ҫ��itemѹ��ջ
				s1.push(item);
			}
		}
		
		//��s1��ʣ�����������ε���������s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		
		//��Ϊ�Ǵ�ŵ�List����˰�˳��������Ƕ�Ӧ�ĺ�׺���ʽ��Ӧ��List
		return s2;
	}
	
	//����׺���ʽת��Ϊ��Ӧ��List
	public static List<String> toInfixExpressionList(String s){
		//����һ��List�������׺���ʽ��Ӧ������
		List<String> ls = new ArrayList<>();
		//������ʱָ�룬���ڱ�����׺���ʽ�ַ���
		int i = 0;
		//�Զ�λ����ƴ��
		String str;
		//ÿ������һ���ַ����ͷ���c
		char c;
		
		do {
			//���c��һ�������֣���Ҫ���뵽1s
			if ((c = s.charAt(i))<48 || (c = s.charAt(i))>57) {
				ls.add(""+c);
				i++;
			}else {
				//��������֣�����Ҫ�����Ƿ��Ƕ�λ��
				str = "";
				while(i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) {
					str += c;//ƴ��
					i++;
				}
				ls.add(str);
			}
			
		} while (i<s.length());
		
		return ls;
	}

	// ��һ���沨�����ʽ�����ν����ݺ���������뵽ArrayList��
	public static List<String> getListString(String suffixExpression) {
		String strs[] = suffixExpression.split(" ");
		List<String> strList = new ArrayList<>();
		for (String str : strs) {
			strList.add(str);
		}
		return strList;
	}

	public static int getResult(List<String> list) {
		// ���ڴ�Ž����ջ
		Stack<Integer> numStack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			String strlist = list.get(i);
			if (strlist.equals("+")) {
				int a = numStack.pop();
				int b = numStack.pop();
				numStack.push(a + b);
			} else if (strlist.equals("-")) {
				int a = numStack.pop();
				int b = numStack.pop();
				numStack.push(b - a);
			} else if (strlist.equals("*")) {
				int a = numStack.pop();
				int b = numStack.pop(); 
				numStack.push(b * a);
			} else {
				int num = Integer.parseInt(strlist);
				numStack.push(num);
			}
		}
		return numStack.pop();
	}
}

//��дһ���� Operation ���Է���һ���������Ӧ�����ȼ�
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//дһ���������ض�Ӧ�����ȼ�����
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;

		default:
			System.out.println("�����ڸ������");
			break;
		}
		return result;
	}
	
}
