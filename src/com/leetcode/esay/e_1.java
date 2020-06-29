package com.leetcode.esay;

public class e_1 {
	public static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<=nums.length;i++){
            for(int j = 0;j<=nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		int[] arr = {2,7,9,11};
		int i  = 9;
		int two[] = twoSum(arr,9);
		for(int j = 0;j<=1;j++) {
			System.out.println(two[j]);
		}
	}
}
