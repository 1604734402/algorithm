package com.algorithm.recursion;

public class MiGong {

	public static void main(String[] args) {
		// �ȴ�����ά���飬ģ���Թ�
		int[][] map = new int[8][7];
		// ʹ��1��ʾǽ
		// ����ȫ����Ϊ1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		// ������Ϊ1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		// ���õ���
//		map[5][5] = 1;
//		map[5][4] = 1;
//		map[6][4] = 1;
		map[3][1] = 1;
		map[3][2] = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("``````````````````````");
		// ʹ�õݹ���ݸ�С����·
		setWay2(map, 1, 1);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * ʹ�õݹ��������С����·
	 * 
	 * i,j ��ʾ�ӵ�ͼ���Ǹ�λ�ÿ�ʼ����(1,1) ���С���ܵ�map[6][5],��˵���ҵ�ͨ· ��map[i][j] Ϊ0
	 * ��ʾ�õ�û���߹�����Ϊ1ʱ��ʾǽ 2��ʾͨ· 3��ʾ�õ��߹��������߲�ͨ
	 * �����Թ�ʱ����Ҫȷ��һ������(����)����->��->��->������õ��߲�ͨ���ٻ���
	 * 
	 * @param map �����ͼ
	 * @param i   ���ĸ�λ�ÿ�ʼ��
	 * @param j   ����ҵ�ͨ·���ͷ���true,���򷵻�false
	 * @return
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // ͨ·�Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) {// �����ǰ����㻹û���߹�
				// ���ղ��� ��-> �� -> �� -> �� ��
				map[i][j] = 2;// �ٶ��õ������ͨ
				if (setWay(map, i + 1, j)) { // ������
					return true;
				} else if (setWay(map, i, j + 1)) { // ������
					return true;
				} else if (setWay(map, i - 1, j)) { // ������
					return true;
				} else if (setWay(map, i, j - 1)) { // ������
					return true;
				} else {
					// ˵���õ��߲�ͨ������·
					map[i][j] = 3;
					return false;
				}
			} else { // ���map[i][j] !=0,������ 1,2,3
				return false;

			}
		}
	}
	
	
	//�ı���� ��-> �� -> �� -> ��
	public static boolean setWay2(int[][] map, int i, int j) {
		if (map[6][5] == 2) { // ͨ·�Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) {// �����ǰ����㻹û���߹�
				// ���ղ��� ��-> �� -> �� -> �� ��
				map[i][j] = 2;// �ٶ��õ������ͨ
				if (setWay2(map, i-1, j)) { // ������
					return true;
				} else if (setWay2(map, i, j + 1)) { // ������
					return true;
				} else if (setWay2(map, i + 1, j)) { // ������
					return true;
				} else if (setWay2(map, i, j - 1)) { // ������
					return true;
				} else {
					// ˵���õ��߲�ͨ������·
					map[i][j] = 3;
					return false;
				}
			} else { // ���map[i][j] !=0,������ 1,2,3
				return false;
			}
		}
	}
}
