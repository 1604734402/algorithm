package com.test;

/**
 * @auther liuyiming
 * @date 2021/7/16 15:36
 * @description
 */
public class Offer53 {

    public static void main(String[] args) {
        Offer53 test = new Offer53();
        int[] nums = new int[]{1,1,2};

        System.out.println(test.search(nums,1 ));
    }


    public int search(int[] nums, int target) {
        if(target<nums[0] || target>nums[nums.length-1]) return -1;
        int i = binarySearch(nums, 0, nums.length - 1, target);

        return closenumbers(nums,i,target);
    }

    public int binarySearch(int[] nums,int left,int right,int target){
        int mid = (left+right)/2;
        if (left == right) return -1;
        if(nums[mid] > target){
            //左递归
            return binarySearch(nums,left,mid-1,target);
        }else if(nums[mid] < target){
            //右递归
            return binarySearch(nums,mid+1,right,target);
        }else{
            return mid;
        }
    }

    public int closenumbers(int[] nums,int index,int target){
        int num = 0;
        for(int i = index;i>=0;i--){
            if(nums[i] == target){
                index = i;
            }else{
                break;
            }
        }

        for(;index<nums.length;index++){
            if(nums[index] == target){
                num++;
            }else{
                break;
            }
        }

        return num;
    }
}
