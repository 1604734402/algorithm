package com.algorithm.search;


public class SeqSearch{
	public static void main(String[] args) {
		int arr[] = {1,9,2,3,4,5,6};
		int num = seq(arr, 20);
		System.out.println(num==-1?"û�в��ҵ�":"���ҵ����±���:"+num);
	}
	
	public static int seq(int[] arr,int num) {
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}
}