package com.algorithm.search;

/**
 * @auther liuyiming
 * @date 2021/1/8
 *
 * 线性查找
 *
 * 从前向后顺序查找和val相同的数，
 * 若找到，则返回第一个的下标，
 * 若遍历后找不到，则返回-1
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1,5,8,9,12,-1,516,887};

        System.out.println(seqSearch(arr,-1));
    }

    public static int seqSearch(int[] arr,int val){

        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]){
                return i;
            }
        }

        return -1;
    }


}
