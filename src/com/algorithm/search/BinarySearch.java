package com.algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 5, 5, 7, 8, 9 };
//		int resind = binarySearch(arr, 0, arr.length-1, 222);
		System.out.println(binarys(arr, 0, arr.length - 1, 222));
//		System.out.println(resind);
	}

	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal < midVal) {// ��ݹ�
			return binarySearch(arr, left, mid - 1, findVal);
		} else if (midVal < findVal) {// �ҵݹ�
			return binarySearch(arr, mid + 1, right, findVal);
		} else {
			return mid;
		}
	}

	public static List<Integer> binarys(int[] arr, int left, int right, int findVal) {
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (left > right) {
			return new ArrayList<Integer>();
		}
		if (findVal < midVal) {// ��ݹ�
			return binarys(arr, left, mid - 1, findVal);
		} else if (midVal < findVal) {// �ҵݹ�
			return binarys(arr, mid + 1, right, findVal);
		} else {
			// ˼·����
			// 1. ���ҵ�mid ����ֵ����Ҫ���Ϸ���
			// 2. ��mid ����ֵ�����ɨ�裬����������1000��Ԫ�ص��±꣬���뵽����ArrayList
			// 3. ��mid ����ֵ���ұ�ɨ�裬����������1000��Ԫ�ص��±꣬���뵽����ArrayList
			// 4. ��ArrayList����

			List<Integer> resIndexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp--);

			}
			resIndexList.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp++);

			}

			return resIndexList;
		}
	}
}
