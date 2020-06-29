package com.algorithm.sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
//		int arr[] = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		
		int arr[] = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random()*800000);
		}
		
		
		Date time1 = new Date();
		SimpleDateFormat timef1 = new SimpleDateFormat("HH:mm:ss");
		System.out.println(timef1.format(time1));
		shellsort(arr);
		Date time2 = new Date();
		SimpleDateFormat timef2 = new SimpleDateFormat("HH:mm:ss");
		System.out.println(timef1.format(time2));

	}

	public static void shellsort(int arr[]) {
		
		//����ʽ
		//����ÿ�εĲ�����ÿ�ζ���2
//		for(int gap = arr.length/2;gap>0;gap /= 2) {
//			int temp = 0;
//			//��
//			for (int i = gap; i < arr.length; i++) {
//				for (int j = i-gap; j >=0; j -= gap) {
//					if (arr[j]>arr[j+gap]) {
//						temp = arr[j+gap];
//						arr[j+gap] = arr[j];
//						arr[j] = temp;
//					}
//				}
//			}
////			System.out.println(Arrays.toString(arr));
//		}
		
		//λ��ʽ
		for(int gap = arr.length/2;gap>0;gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				//�ȱ��棬��һ��ֱ���Ƶ�ǰ�棬���û�ҵ������ƶ�
				int temp = arr[i];
				int j = i;
				while(j-gap>=0&&temp<arr[j-gap]) {
					arr[j] = arr[j-gap];
					j = j-gap;
				}
				if (j!=i) {
					arr[j] = temp;
				}
				
			}
//			System.out.println(Arrays.toString(arr));
		}
		
		
		
		
		/*
		// ϣ������ĵ�1������
		// ��Ϊ�ǵ�1�������ǽ�10������ֳ���5��
		for (int i = 5; i < arr.length; i++) {
			// �������������е�Ԫ��(��5�飬ÿ��������Ԫ��)������5
			for (int j = i - 5; j >= 0; j -= 5) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));

		// ϣ������ĵ�2������
		// ��Ϊ��2�������ǽ�10�����ݷֳ���5/2 = 2��
		for (int i = 2; i < arr.length; i++) {
			// �������������е�Ԫ��(��5�飬ÿ��������Ԫ��)������5
			for (int j = i - 2; j >= 0; j -= 2) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));

		// ϣ������ĵ�3������
		// ��Ϊ��3�������ǽ�10�����ݷֳ���2/2 = 1��
		for (int i = 1; i < arr.length; i++) {
			// �������������е�Ԫ��(��5�飬ÿ��������Ԫ��)������5
			for (int j = i - 1; j >= 0; j -= 1) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
		
		*/
	}

}
