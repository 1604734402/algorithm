package com.algorithm.sort;

import java.util.Arrays;

import javax.imageio.event.IIOReadWarningListener;

public class QuickSort {

	public static void main(String[] args) {
//		int arr[] = {9,5,4,13,-2,-1,8,7,6};
		int arr[] = {1, 0, 4, 4, 3, 1, 4, 4, 0, 0, 1, 1, 3, 2, 0, 4, 2, 1, 2, 0};
		quick(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quick(int arr[], int left, int right) {
		int l = left;// ���±�
		int r = right;// ���±�
		int pivot = arr[(left + right) / 2]; // ���ᣬ�����ҵı�׼
		int temp = 0;// ����ʱʹ��
		// whileѭ����Ŀ�����ñ�pivotֵ���÷ŵ����
		// ��pivetֵ��ķŵ��ұ�
		while (l < r) {
			// ��pivot������һֱ�ң��ҵ����ڵ���pivotֵ�����˳�
			while (arr[l] < pivot) {
				//�߽�ֵ�����û�и���ģ���ô��˵������ߵ�L�±���������
				l++;
			}
			// ��pivot���ұ�һֱ�ң��ҵ�С�ڵ���pivotֵ�����˳�
			while (arr[r] > pivot) {
				r--;
			}
			// ��� l >= r ˵��pivot ����������ֵ���Ѿ��������ȫ����
			// С�ڵ���pivotֵ���ұ�ȫ�����Ǵ��� pivotֵ
			//���������ѭ������������arr[l]��arr[r]���
			if (l >= r) {
				break;
			}
			// ����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			// ���������󣬷������arr[l] == pivotֵ ��� r--,ǰ��
			if (arr[l] == pivot) {
				r--;
			}
			// ���������󣬷������arr[r] == pivotֵ ��� l++,����
			if (arr[r] == pivot) {
				l++;
			}
		}

		// ��� l==r,����l++,r--.�������ջ���
		if (l == r) {
			//ֻ��һ�����ݵ�ʱ��ֱ���˳�
			l++;
			r--;
		}
		// ����ݹ�
		if (left < r) {
			quick(arr, left, r);
		}
		// ���ҵݹ�
		if (right > l) {
			quick(arr, l, right);
		}
	}
}
