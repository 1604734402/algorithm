package com.algorithm.sort;

public class SelectSort {
	
	public static void main(String[] args) {
		int arr[] = {1,6,7,8,1,56,4,6};
		int arr2[] = selectsort(arr);
		for (int i : arr2) {
			System.out.print(i+" ");
		}
		
		
//		int arr[] = new int[80000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 80000);//����һ��[0,80000)�������
//		}
//		int a = (int) System.currentTimeMillis();
//		int arr2[] = selectsort(arr);
//		int b = (int) System.currentTimeMillis();
//		System.out.println(b-a);
	}
	
	
	public static int[] selectsort(int[] arr) {
		int num = 0;
		int j = 0;
		int i = 0;
				
		for(i = 0;i<arr.length-1;i++) {
			for(j = i;j<arr.length;j++) {
				if (arr[i] > arr[j]) {
					num = arr[j];
					arr[j] = arr[i];
				}
			}
			if (i!=j) {
				arr[i] = num;
			}
		}
		return arr;
	}
}
