package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/3/27 11:27
 * @description
 */
public class Test {

    private static final int N = 6;
    private static final int maxT = 100;
    private static int c[][] = new int[N][N];

    public static void main(String[] args) {

//        int[] w = {1, 4, 3}; //物品的重量
//        int[] v = {1500, 3000, 2000}; //物品的价值
//
//        System.out.println(memoized_Knapsack(v,w,N));

        new Animal("222");

        new Dog();
    }

    /**
     * 背包问题
     * @param v 价值数组
     * @param w 重量数组
     * @param T 背包容量
     * @return
     */
    public static int memoized_Knapsack(int[] v,int[] w,int T){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <=N; j++) {
                c[i][j] = -1;
            }
        }
        return calculate_Max_Value(v,w,N-1 ,0);
    }

    /**
     * 获取当前最优价值
     * @param v
     * @param w
     * @param i
     * @param j
     * @return
     */
    public static int calculate_Max_Value(int[] v,int[] w,int i,int j){
        int temp = 0;
        if (c[i][j] != -1) {
            return c[i][j];
        }

        if (i == 0|| j==0){
            c[i][j] = 0;
        }else {
            c[i][j] = calculate_Max_Value(v,w,i,j);
            if (N>w[j]){
                temp = c[i][j];
                if (c[i][j]<temp){
                    c[i][j] = Math.max(c[i-1][j],c[i-1][j-w[i]+v[i]]);
                }
            }
        }

        return c[i][j];

    }
}

class Animal{
    public Animal(String name){
        System.out.println("动物："+name);
    }
}

class Dog extends Animal{
    public Dog(){
        super("111");
    }
}
