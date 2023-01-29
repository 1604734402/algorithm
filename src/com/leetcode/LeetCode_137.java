package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/4/30 08:33
 * @description
 */
public class LeetCode_137 {

    public static void main(String[] args) {
        int[] arr ={1,1,3,1};

        int i = singleNumber(arr);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        int[] step = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++) {
                if(nums[i] == nums[j]){
                    step[i] = 1;
                    step[j] = 1;
                }
            }
        }
        int temp = 0;
        for(int i = 0;i<step.length;i++){
            if(step[i] == 0){
                temp = step[i];
            }
        }
        return temp;

    }
}
