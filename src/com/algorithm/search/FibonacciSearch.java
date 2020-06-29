package com.algorithm.search;

import java.security.PublicKey;
import java.util.Arrays;

public class FibonacciSearch {
	// 쳲��������еĳ���
	public static int maxLength = 20;

	public static void main(String[] args) {
		int[] arr = { 1, 8, 10, 89, 1000, 1234 };

//		System.out.println(Arrays.toString(fib()));
		System.out.println(fibSearch(arr, 1234));
	}

	// ��Ϊ��������Mid = Low +F(k-1)-1,��Ҫʹ�õ�쳲��������У����������Ҫ�Ȼ�ȡ��һ��쳲���������
	// �ǵݹ�ķ����õ�һ��쳲���������
	public static int[] fib() {
		int[] f = new int[maxLength];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	/**
	 * ��д쳲����������㷨 ʹ�÷ǵݹ�ķ���
	 * 
	 * @param a   ���������
	 * @param key Ҫ���ҵ�ֵ
	 * @return ���ض�Ӧ���±꣬���û�о�-1
	 */
	public static int fibSearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int k = 0;// 쳲������ָ���ֵ���±�
		int mid = 0;// ���midֵ
		int f[] = fib();// ��ȡ��쳲���������
		// ��ȡ��쳲������ָ���ֵ���±�
		while (high > f[k] - 1) {
			k++;
		}
		// ��Ϊf[k] ��ֵ ���ܴ��� a �ĳ��ȣ����������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��temp[]
		// ����Ĳ��ֻ�ʹ��0���
		int[] temp = Arrays.copyOf(a, f[k]);
		// ʵ������Ҫʹ��a��������������temp
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}

		// ʹ��while��ѭ�������ҵ����ǵ���key
		while (low <= high) {// ֻҪ����������㣬�Ϳ���һֱ��
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {// ˵������Ӧ�ü����������ǰ�����(���)
				high = mid - 1;
				// 1. ȫ��Ԫ�� = ǰ���Ԫ�� + �����Ԫ��
				// 2. f[k] = f[k-1] + f[k-2]
				// 3. ��Ϊ ǰ���� f[k-1]��Ԫ�أ����п��ü������ f[k-1] = f[k-2] + f[k-3]
				// 4. ����f[k-1]��ǰ��������� k--
				// 5. �´�ѭ��Mid = f[k-1-1]-1
				k = k-1;
			} else if (key > temp[mid]) {// ˵������Ӧ�ü���������ĺ������(�ұ�)
				low = mid + 1;
				// 1. ȫ��Ԫ�� = ǰ���Ԫ�� + �����Ԫ��
				// 2. f[k] = f[k-1] + f[k-2]
				// 3. ��Ϊ ������ f[k-2]��Ԫ�أ����п��ü������ f[k-2] = f[k-3] + f[k-4]
				// 4. ��f[k-2] ��ǰ����в��� k-=2
				// 5. ���´�ѭ�� mid = f[k-1-2]-1
				k = k-2;
			} else {
				if (mid <= high) {
					return mid;
				} else {
					return high;
				}
			}
		}
		return -1;
	}
}
