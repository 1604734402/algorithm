package com.algorithm.topten;

import com.common.Util;

/**
 * @auther liuyiming
 * @date 2021/2/2 16:49
 * @description 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearchForRecur(arr, 1));
//        System.out.println(binarySearchForRecursion(arr, 0,arr.length-1,1));
    }


    /**
     * 迭代
     * @return
     */
    public static int binarySearchForRecur(int[] arr,int num){

        int l = 0;
        int r = arr.length-1;
        int midTemp;

        while (l<=r){
            midTemp = (l+r)/2;
            if (arr[midTemp] == num){
                return l;
            }else if (arr[midTemp] <num ){
                l = midTemp+1;
            }else {
                r = midTemp-1;
            }
        }

        return -1;
    }

    /**
     * 递归
     * @return
     */
    public static int binarySearchForRecursion(int[] arr,int left,int right,int num){

        if (left<right){
            int temp = (left+right)/2;
            if (arr[temp] == num){
                return temp;
            }else if (arr[temp] < num){
                return binarySearchForRecursion(arr, temp+1, right, num);
            }else if (arr[temp] > num){
                return binarySearchForRecursion(arr, left, right-1, num);
            }
        }

        return -1;
    }






}
