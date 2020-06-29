package com.leetcode.esay;

import java.util.HashMap;
import java.util.Stack;

public class e_20 {
	
	public static void main(String[] args) {
		 String m = "()[]}{";
	        boolean is = isValid(m);
	        System.out.println(is);
	}
	
	private static boolean isValid(String s) {
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')','(');
        mapping.put(']','[');
        mapping.put('}','{');
        //��ʼ��Ҫʹ�õ�ջ
        Stack<Character> stack =new Stack<Character>();
        //��������ַ���
        for (int i = 0; i < s.length(); i++) {
        	//תΪchar
            char c = s.charAt(i);
            //�ж��Ƿ���������
            //containsKey() �鿴�����ֵ�Ƿ����Ѿ���put��key��
            if (mapping.containsKey(c)){
                //�ж��Ƿ�ջ��
                if (stack.empty()) {
                	//���ջ�ǿգ��ҵ�һ���������ţ���ôֱ�ӿ��Է���false
					return false;
				}else {
					//�����Ϊ�գ��Ǿ͵�������ַ��������ж��Ƿ��ǵ�ǰ�ַ�����ƥ������
					char popchar = stack.pop();
					if (popchar != mapping.get(c)){
	                    return false;
	                }
				}
            }else {
            	//������������ţ���ô��ֱ�ӷ���ջ��
                stack.push(c);
            }
        }
        //�������ջ�Ƿ�Ϊ��
        return stack.isEmpty();
    }
}
