package com.algorithm.search;

/**
 * 线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        int i = seqSearch(arr,34);
        System.out.println(i); 
    }

    /**
     * 线性查找
     * 根据数组，所查找的值，如果有所查找的，返回下标，否则返回-1
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;

    }
}
