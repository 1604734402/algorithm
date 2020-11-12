package com.algorithm.search;

public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		System.out.println(insert(arr, 0, arr.length-1, 20));
		
		System.out.println(29000/12);
	}
	
	public static int insert(int[] arr,int left,int right,int findVal) {
		System.out.println("----------");
		if (left>right || findVal<arr[0] || findVal>arr[arr.length-1]) {
			return -1;
		}
		
		int mid = left + (right-left)*(findVal - arr[left]) / (arr[right]-arr[left]);
		int midVal = arr[mid];
		
		if (findVal<midVal) {
			return insert(arr, left, mid-1, findVal);
		}else if (midVal<findVal) {
			return insert(arr,mid+1,right,findVal);
		}else {
			return mid;
		}
	}
}