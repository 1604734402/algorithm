package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/4/29 08:41
 * @description
 */
public class LeetCode_403 {

    public static void main(String[] args) {
        int[] arr = {0,1,3,5,6,8,12,17};

        boolean b = canCross(arr);
    }

    public static boolean canCross(int[] stones) {
        if(stones.length <1) return true;

        int step = stones[1]-stones[0];//步长

        for(int i=0;i<stones.length-1;i++){
            int curstep = stones[i+1]-stones[i];
            if(curstep != step && curstep != step+1 && curstep != step-1){
                return false;
            }
            step = curstep;
        }
        return true;
    }
}
