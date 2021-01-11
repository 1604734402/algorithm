package com.algorithm.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther liuyiming
 * @date 2021/1/8
 * <p>
 * 二分查找
 * <p>
 * 1、首先确定该数组的中间的下标 mid = (left + right) /2
 * 2、让需要查找的数findVal和arr[mid]比较
 * 2.1 findVal>arr[mid],说明需要查找的数在mid右边，需要递归向右查询
 * 2.2 findVal<arr[mid],说明要查找的数在mid左边，因此需要递归向左查找
 * 2.3 findVal == arr[mid] 说明找到，返回
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,5};
        ArrayList<Integer> arrayList = binarySearch2(arr, 1, 0, arr.length - 1);
        System.out.println(Arrays.toString(arrayList.toArray()));

//        System.out.println(binarySearch(arr, 5));
    }

    /**
     * 递归
     * @param arr
     * @param val
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] arr, int val, int left, int right)
    {
        int mid = (left + right) / 2;
        if (left <= right) {

            if (arr[mid] == val) {
                return mid;
            } else if (val < arr[mid]) {
                return binarySearch(arr, val, left, mid-1);
            } else if (arr[mid] < val) {
                return binarySearch(arr, val, mid+1, right);
            }

        }
        return -1;
    }

    /**
     * 迭代
     * @param arr
     * @param val
     * @return
     */
    public static int binarySearch(int[] arr,int val){

        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left<=right){
            mid = (left + right) / 2;
            if (arr[mid] == val){
                return mid;
            }else if (val < arr[mid]){
                right = mid-1;
            }else if (val > arr[mid]){
                left = mid+1;
            }
        }

        return -1;
    }


    /**
     * 递归批量
     * @param arr
     * @param val
     * @param left
     * @param right
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int val, int left, int right) {

        int mid = (left + right) / 2;
        if (left <= right) {

            if (arr[mid] == val) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                int temp = mid;
                while (temp>0 && arr[temp-1] == val){
                    arrayList.add(--temp);
                }
                arrayList.add(mid);
                temp = mid;
                while (temp<arr.length-1 && arr[temp+1]==val){
                    arrayList.add(++temp);
                }
                return arrayList;
            } else if (val < arr[mid]) {
                return binarySearch2(arr, val, left, mid-1);
            } else if (arr[mid] < val) {
                return binarySearch2(arr, val, mid+1, right);
            }

        }
        return new ArrayList<Integer>();
    }

}
