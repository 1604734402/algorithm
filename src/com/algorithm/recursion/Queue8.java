package com.algorithm.recursion;
            
public class Queue8 {
	
	//����һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	//��������array,���ڱ���ṹ
	int array[] = new int[max];
	
	static int num = 0;
	static int judgeCount = 0;
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.println(num);
		System.out.println(judgeCount);
	}
	
	//��дһ�����������õ�n���ʺ�
	//�ر�ע�⣺check ��ÿһ�εݹ�ʱ�����뵽check�У���˻��л���
	private void check(int n) {
		if(n ==max) { //n = 8 ,��ʵ8���ʺ�ͷź���
			num++;
			print();//��ӡ���ʺ�λ��
			return;
		}
		//���η���ʺ󣬲��ж��Ƿ��ͻ
		for (int i = 0; i < max; i++) {
			//�Ȱѵ�ǰ�ʺ� n ���ŵ����еĵ�1��
			array[n] = i;
			//�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if (judge(n)) { // �������ͻ
				//���ŷ�n+1���ʺ󣬼���ʼ�ݹ�
				check(n+1);
			}
			//�����ͻ���ͼ���ִ��array[n] = i;������n���ʺ󣬷����ڱ��к��Ƶ�һ��λ��
		}
	}
	
	//�鿴�����Ƿ��õ�n���ʺ󣬾�ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	private boolean judge(int n) {
		judgeCount++;
		for(int i = 0;i<n;i++) {
			//1. array[i] == array[n]��ʾ�ж� ��n���ʺ��Ƿ��ǰ���n-1���ʺ���һ��
			if (array[i] == array[n]) {
				return false;
			//2. Math.abs(n-i) == Math.abs(array[n]-array[i]) ��ʾ�жϵ�n���ʺ��Ƿ�͵�i���ʺ���һ��б��
			}else if (Math.abs(n-i) == Math.abs(array[n]-array[i])) {
				return false;
			}
			//3. �ж��Ƿ���ͬһ�У�û�б�Ҫ����Ϊÿ��n���ڵ���
		}
		return true;
	}
	
	
	//����һ�����������Խ��ʺ�ݷõ�λ�����
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
