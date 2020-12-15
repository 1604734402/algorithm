package com.algorithm.sort;

import com.common.Util;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {




        int arr[] = Util.random(50000, 8000000);

        System.out.println(Util.curTime());
        BubbleSort.bubbleSortMajorization(arr);
//        myselectSort(arr);
        System.out.println(Util.curTime());
    }


    private static int[] myselectSort(int[] arr){



        for (int i = 0; i < arr.length-1; i++) {
            //最小的下标
            int minindex = i;
            //当前i的下标
            int curindex = i;

            //一次循环，选出最小的下标
            for (int j = i; j < arr.length; j++) {
                if (arr[minindex]>arr[j]){
                    minindex = j;
                }
            }

            //如果最小的下标小于arr[i],则进行交换
            if (arr[minindex]<arr[curindex]){
                int temp = arr[curindex];
                arr[curindex] =arr[minindex] ;
                arr[minindex] = temp;
            }

        }


        return arr;
    }
}
