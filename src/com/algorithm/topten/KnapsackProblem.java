package com.algorithm.topten;

/**
 * @auther liuyiming
 * @date 2021/2/3 16:13
 * @description 01背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] w = {1, 4, 3}; //物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值
        int m = 4; //背包的容量
        int n = val.length; //物品个数

        //记录放入商品的情况，定义一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];

        //初始化第一行和第一列，这里在本程序汇总，可以不去处理，默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0; //将第一列设置为0  将每一个容量为0的背包的价值，设置为0，重量为0，价值也为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0; //将第一行设置为0  第0个物品价值，不论放多少物品，最终价值也为0
        }

        for (int i = 1; i < v.length; i++) { //i=1不处理第一行
            for (int j = 1; j < v[0].length; j++) { //j=1不处理第一列
                //一旦物品的重量大于当前背包，那么就把上一个背包的价值，直接复制到当前背包
                //针对一个的情况，如1、2、3重量背包放入不下 重量为4的物品，
                //那么，重量为1的背包中价值，就复制重量为0的背包，也就是0
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //如果说当前背包可以放入当前重量的物品(如,当前容量为4,背包价值为3,那么就会剩余1容量，则就会进行比较)
                    // v[i-1][j] 容量-1的背包，也就是上一个背包
                    // val[i-1]+v[i-1][j-w[i-1]] 当前物品价值，加上最大剩余价值
//                    v[i][j] =  Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);//公式
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }

                }
            }
        }


        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=====商品情况======");
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1; //列的最大下标
        //逆向遍历
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                //如4容量，先去找3容量，然后再从1容量寻找
                //如 5,3,1 背包9容量 1、[9-5 4] [4-3 1] [1-1 0]
                j -= w[i - 1];//容量减少
            }
            i--;
        }

        System.out.println("=====最优情况======");
        for (int k = 0; k < path.length; k++) {
            for (int l = 0; l < path[k].length; l++) {
                System.out.printf("%d  ",path[k][l]);
            }
            System.out.println();
        }

    }


}
