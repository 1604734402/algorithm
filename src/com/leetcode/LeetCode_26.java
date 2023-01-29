package com.leetcode;

import com.common.ListNode;

/**
 * @auther liuyiming
 * @date 2021/3/27 10:39
 * @description
 */
public class LeetCode_26 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int i = removeDuplicates(arr);
        System.out.println(i);
        for (int i1 : arr) {
            System.out.println(i1);
        }

    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0,fast = 1;

        while(fast<nums.length && slow<nums.length-1){
            if(nums[slow] == nums[fast]){
                fast++;
            }else if (nums[slow] <nums[fast]){
                nums[++slow] = nums[fast];
            }
        }

        return slow+1;
    }



}
