package com.algorithm.stack;

import org.omg.PortableInterceptor.DISCARDING;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "3+2*6-2";
		//����ջ
		ArrStack2 numStack = new ArrStack2(10);
		//����ջ
		ArrStack2 operStack = new ArrStack2(10);
		//������Ҫ����ر���
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		//��ÿ��ɨ��õ���char���浽ch
		char ch = ' ';
		//����ƴ�Ӷ�λ��
		String keepNum = "";
		
		//��ʼwhileѭ����ɨ��expression
		while(true) {
			//���εõ�expression��ÿһ���ַ�-
			ch = expression.substring(index,index+1).charAt(0);
			System.out.println(ch);
			//�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			if (operStack.isOper(ch)) {//����������
				//�жϵ�ǰ�ķ���ջ�Ƿ�Ϊ��
				if (!operStack.isEmpty()) {
					//�������ջ�в��������ͽ��бȽϣ�
					//�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ���������Ҫ����ջ��pop�����������ٴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
					//�����ǰ�Ĳ��������ȼ�����ջ�еĲ���������ֱ�������ջ
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//������Ľ����ջ
						numStack.push(res);
						//Ȼ�󽫵�ǰ�Ĳ����������ջ
						operStack.push(ch);
					}else {
						//�����ǰ�Ĳ����������ȼ�����ջ�еĲ���������ֱ�������ջ
						operStack.push(ch);
					}
				}else {
					//���Ϊ��ֱ�������ջ
					operStack.push(ch);
				}
			}else {
				//�����������ֱ������ջ
//				numStack.push(ch - 48);//����ȡ�õ�charֵ������������char,���Ƕ�ӦASCLL����ձ������
				//�������λ��ʱ�����ܷ�����һ������������ջ����Ϊ�����Ƕ�λ��
				//�ڴ���������Ҫ��expression�ı��ʽ��index���ٿ�һλ����������ͽ���ɨ�裬����Ƿ��Ų���ջ
				//��Ҫ����һ���������ַ���������ƴ��
				
				//�����λ��
				keepNum+= ch;
				
				//���ch�Ѿ���expression�����һλ����ֱ����ջ
				if (index ==expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					//�ж���һ���ַ��ǲ������֣���������֣��ͼ���ɨ�裬����������������ջ
					//ֻ�ǿ���һλ������Index++
					if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//�����һλ�������������ջ
						numStack.push(Integer.parseInt(keepNum));
						//�����³�ʼ��keepNum
						keepNum = "";
					}
				}
				
				
			}
			
			//��index +1,���ж��Ƿ�ɨ�赽expression���
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		//�����ʽɨ����ϣ���˳�����ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ�������
		while(true) {
			//�������ջΪ�գ�����㵽���Ľ������ջ��ֻ��һ�����֡������
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);//��ջ
		}
		//����ջ���������pop�������ǽ��
		System.out.println("���ʽ:"+expression+"--�����"+numStack.pop());
	}

}
class ArrStack2{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ��ջ
	private int top = -1;//top ��ʾջ������ʼ��Ϊ-1
	
	public ArrStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ-push
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ�������޷���������");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ����������
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		return stack[top--];
		
	}
	
	//����ʱ����Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		
		for (int i = top; i >=0; i--) {
			System.out.println(stack[i]);
		}
	}
	//����ջ����ֵ�������ǵ���ջ
	public int peek() {
		return stack[top];
	}
	//�жϷ��ŵ����ȼ�
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}else if (oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	//�ж��Ƿ��������
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '/' || val == '*';
	}
	
	//���㷽��
	public int cal(int num1,int num2,int oper) {
		//���Ҫ���صĽ��
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;//������ջ
			break;
		case '*':
			res = num2 * num1;//������ջ
			break;
		case '/':
			res = num2 / num1;//������ջ
			break;
		default:
			break;
		}
		
		return res;
	}
}
