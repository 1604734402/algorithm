package com.algorithm.sort;

import java.util.Arrays;

import javax.xml.transform.Templates;

public class MergetSort {
	
	public static void main(String[] args) {
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if (left < right) {
			int mid = (left + right)/2;//�м������
			//��ݹ�ֽ�
			mergeSort(arr, left, mid, temp);
			//�ҵݹ�ֽ�
			mergeSort(arr, mid +1, right, temp);
			//�ϲ�
			merge(arr, left, mid, right, temp);
			
		}
	}
	
	
	
	
	/**
	 * �ϲ��ķ���
	 * @param arr �����ԭʼ����
	 * @param left ����������еĳ�ʼ����
	 * @param mid �м�����
	 * @param right �ұ�����
	 * @param temp ����ת������
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left; // ��ʼ��i,����������еĳ�ʼ����
		int j = mid +1; // ��ʼ��j,�ұ��������еĳ�ʼ����
		int t = 0; // ָ��temp����ĵ�ǰ����
		
		//�Ȱ���������(����)�����ݰ�װ������䵽temp����
		//ֱ���������ߵ��������У���һ�鴦�����Ϊֹ
		while(i <= mid && j<= right) {
			//�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
			//������ߵĵ�ǰԪ�أ�������temp����
			//Ȼ�� t���ƣ�i����
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t ++;
				i ++;
			}else {
				temp[t] = arr[j];
				t ++;
				j ++;
			}
		}
		//����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		//��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
		while( i <= mid) {
			temp[t] = arr[i];
			t ++;
			i ++;
		}
		
		//�ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
		while( j <= right) {
			temp[t] = arr[j];
			t++;
			j++;
		}
		
		//��temp�����Ԫ�ؿ�����arr
		//������ÿ�ζ�����
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}
}
