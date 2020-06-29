package com.algorithm.sort;

import java.sql.Array;
import java.util.Arrays;

public class insterSort {
	
	public static void main(String[] args) {
		int arr[] = {101,34,119,1};
		System.out.println(Arrays.toString(insertSort(arr)));
	}
	
	//��������
	public static int[] insertSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			//��ʱ��������Ҫ�����ֵ
			int temp = arr[i];
			//ͨ����ʱ���������±�
			int j;
			//��֤Ҫ�����������Խ��Ҳ���ǲ�Ҫ����0�����ҴӺ���ǰ����Ѱ��Ҫ�����λ��
			for(j = i;j>0&&temp<arr[j-1];j--) {
				arr[j] = arr[j-1];
			}
			
			//����ҵ�λ�ú󣬾Ͱ�ͨ����ʱ���������ֵ���뵽�ҵ���λ��
			if (j!=i) {
				arr[j] = temp;
			}
			
		}
		
			
		return arr;
	}
	
}
