package com.algorithm.sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
//		int arr[] = { 53, 3, 542, 748, 14, 214 };
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 8000);
		}
		radixSort(arr);

	}

	public static void radix(int[] arr) {
		// 1.�õ�����������λ��
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();

		int[][] bucket = new int[10][arr.length];

		int[] bucketElementCounts = new int[10];

		// for(int i = 0,n=1;i<maxLength;i++,n *=10)
		// int digitOfElement = arr[j]/n % 10;
		for (int i = 1; i < max; i *= 10) {
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / i % 10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}

			int index = 0;
			for (int k = 0; k < bucket.length; k++) {
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];

					}
				}
				bucketElementCounts[k] = 0;
			}
		}
	}

	// ��������
	public static void radixSort(int[] arr) {

		// ����һ����ά���飬��ʾͰ
		// 1.��ά�������10��һλ����
		// 2.Ϊ�˷�ֹ��������ʱ�������������ÿ��һλ���飬��С��λarr.length
		int[][] bucket = new int[10][arr.length];

		// Ϊ�˼�¼ÿ��Ͱ�У�ʹ������˶��ٸ����ݣ����Ƕ���һ��һλ���飬����¼����Ͱ��ÿ�η�������ݸ���
		// ���磺bucketElementCounts[0],��¼�ľ��� bucket[0] Ͱ�ķ������ݸ���
		int[] bucketElementCounts = new int[10];

		// ��һ��(���ÿ��Ԫ�صĸ�λ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j] % 10;
			// ���뵽��Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}

		// �������Ͱ��˳��(һλ������±�һ��ȡ�����ݣ�����ԭ��������)
		int index = 0;
		// ����ÿһ��Ͱ,����Ͱ�����ݣ����뵽ԭ����
		for (int k = 0; k < bucket.length; k++) {
			// ���Ͱ�У������ݣ����Ǿͷŵ�ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ������K��Ͱ(����K��һλ����)������
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط��뵽arr
					arr[index++] = bucket[k][l];

				}
			}
			bucketElementCounts[k] = 0;
		}

		System.out.println(Arrays.toString(arr));

		// �ڶ���(���ÿ��Ԫ�ص�ʮλ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j] / 10 % 10;
			// ���뵽��Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}

		// �������Ͱ��˳��(һλ������±�һ��ȡ�����ݣ�����ԭ��������)
		index = 0;
		// ����ÿһ��Ͱ,����Ͱ�����ݣ����뵽ԭ����
		for (int k = 0; k < bucket.length; k++) {
			// ���Ͱ�У������ݣ����Ǿͷŵ�ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ������K��Ͱ(����K��һλ����)������
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط��뵽arr
					arr[index++] = bucket[k][l];

				}
			}
			bucketElementCounts[k] = 0;
		}

		System.out.println(Arrays.toString(arr));

		// ������(���ÿ��Ԫ�صİ�λ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j] / 100 % 10;
			// ���뵽��Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;
		}

		// �������Ͱ��˳��(һλ������±�һ��ȡ�����ݣ�����ԭ��������)
		index = 0;
		// ����ÿһ��Ͱ,����Ͱ�����ݣ����뵽ԭ����
		for (int k = 0; k < bucket.length; k++) {
			// ���Ͱ�У������ݣ����Ǿͷŵ�ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ������K��Ͱ(����K��һλ����)������
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط��뵽arr
					arr[index++] = bucket[k][l];

				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
