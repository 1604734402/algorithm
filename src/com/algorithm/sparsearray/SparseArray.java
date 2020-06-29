package com.algorithm.sparsearray;

public class SparseArray {
	private static int chessArr[][];
	public static void main(String[] args) {
		//��ʼ������
		init();
		soutArray(chessArr);
		System.out.println("--------------------");
		int tosparseArray[][] = arraytosparseArray(chessArr);
		soutArray(tosparseArray);
		int toArray[][] = sparseArraytoarray(tosparseArray);
//		soutArray(toArray);

	}
	//��ʼ������
	public static void init() {
		chessArr = new int[11][11];
		chessArr[1][2] = 1;
		chessArr[2][3] = 2;
		chessArr[4][5] = 1;
	}
	//��ӡ��ά����
	public static void soutArray(int array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
		System.out.println();
	}

	//����תΪϡ������
	public static int[][] arraytosparseArray(int array[][]) {
		//����ѹ���ú������
		int sparseArray[][];
		
		int sum  = 0;
		//�����й��ж��ٸ���Чֵ
		for(int row[]:chessArr) {
			for(int data:row) {
				if (data !=0) {
					sum++;
				}
			}
		}
		//��ʼ�����ϡ������
		sparseArray = new int[sum+1][3];
		sparseArray[0][0] = array.length;
		sparseArray[0][1] = array.length;
		sparseArray[0][2] = sum;
		int z = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j]!=0) {
					sparseArray[z][0] = i;
					sparseArray[z][1] = j;
					sparseArray[z][2] = array[i][j];
					z++;
				}
			}
		}
		return sparseArray;
	}
	
	//ϡ������תΪ����
	public static int[][] sparseArraytoarray(int sparseArray[][]) {
		int array[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		int z = 1;
		for (int i = 1; i < sparseArray.length; i++) {
				array[sparseArray[z][0]][sparseArray[z][1]] = sparseArray[z][2];
				z++;
		}
		return array;
	}
}
 