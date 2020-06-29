package com.algorithm.sort;

public class Bubble {

	public static void main(String[] args) {
		int arr[] = new int[80000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0,8000000)�������
		}
		int a = (int) System.currentTimeMillis();
		int arr2[] = bubblesort(arr);
		int b = (int) System.currentTimeMillis();
		System.out.println(b-a);
	}
	
	public static int[] bubblesort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (min>arr[j]) {
					min = arr[j];
					minIndex = j;
					System.out.println(" "+i);
				}
			}
			if (minIndex!=i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
				
			}
		}
		
		return arr;
	} 
	
	public static int[] bubblesort2(int[] arr) {
		Boolean flag = false;
		int num = arr[0];
		int length = arr.length;
		for (int i = 0; i < arr.length-1; i++) {
			
			length--;
			for (int j = 0; j < length; j++) {
				if (arr[j]>arr[j+1]) {
					flag = true;
					num = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = num;
				}
			}
			if (!flag) {
				//�����һ�δ�ѭ���У�һ�ζ�û�н���������ô��֤�����Ѿ�����ֱ���˳�
				break;
			}else {
				//����������ˣ����û�Ϊfalse;
				flag = false;
			}
		}
		
		return arr;
	} 
}
