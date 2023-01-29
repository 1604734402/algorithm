package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/3/27 10:39
 * @description
 */
public class LeetCode_922 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int[] i = sortArrayByParityII(arr);
        System.out.println(i);
        for (int i1 : i) {
            System.out.println(i1);
        }

    }

    public static int[] sortArrayByParityII(int[] nums) {
        int[] res = nums;
        for(int i = 0;i<nums.length;i++){
            int cur = i;
            //判断位数是否在偶数
            if(i%2 == 0){
                //判断当前数是否是偶数
                if(nums[i]%2 == 0){
                    res[i] = nums[i];
                }else{
                    //如果当前数是奇数,那么就去寻找下一个偶数
                    while(cur<nums.length){
                        if(nums[cur]%2 == 0){
                            int temp = nums[i];
                            nums[i] = nums[cur];
                            nums[cur] = temp;
                            res[i] = nums[i];
                            break;
                        }
                        cur++;
                    }
                }
            }else{
                //判断当前数是否是偶数
                if(nums[i]%2 == 1){
                    res[i] = nums[i];
                }else{
                    //如果当前数是奇数,那么就去寻找下一个偶数
                    while(cur<nums.length){
                        if(nums[cur%2] == 1){
                            int temp = nums[i];
                            nums[i] = nums[cur];
                            nums[cur] = temp;
                            res[i] = nums[i];
                            break;
                        }
                        cur++;
                    }
                }
            }
        }
        return res;
    }



}
