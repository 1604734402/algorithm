package com.algorithm.sort;

import com.common.Util;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3};
        Util.printArray(insertSortTest(arr));
    }

    /**
     * 略优化,找到后才插入
     * @param arr
     * @return
     */
    private static int[] insertSort(int[] arr) {

        //从第二个开始，循环每一个数，使之向前比较
        for (int i = 1; i < arr.length; i++) {
            //当前值 需要插入的值
            int curVal = arr[i];
            //前一个的索引,用于寻找应插入的下标
            int preIndex = i - 1;
            //通过循环，如果发现当前值比前一个值小，则说明顺序不对，需要排序
            while (preIndex >= 0 && arr[preIndex] > curVal) {
                //将前一个覆盖给当索引下标值，将索引前移
                arr[preIndex+1] =arr[preIndex];
                preIndex--;
            }
            //找到正确的下标，进行插入
            arr[preIndex+1] = curVal;
        }
        return arr;
    }


    /**
     * 每一次都进行了交换，效率低
     * @param arr
     * @return
     */
    private static int[] myInsertSort(int[] arr) {

        //从第二个开始，循环每一个数，使之向前比较
        for (int i = 1; i < arr.length; i++) {
            //当前值 需要插入的值
            int curVal = arr[i];
            //前一个的索引
            int preIndex = i - 1;
            int curIndex = i;
            while (preIndex >= 0 && arr[preIndex] > curVal) {
                int temp = arr[preIndex];
                arr[preIndex] =arr[curIndex];
                arr[curIndex] = temp;
                curIndex--;
                preIndex--;
            }
        }

        return arr;
    }

    private static int[] insertSortTest(int[] arr){
        int val=0;
        int valPreIndex=0;
        for (int i = 1; i < arr.length; i++) {
            //要排序的值
            val = arr[i];
            //要排序的前一个索引
            valPreIndex = i-1;

            //valPreIndex>=0 防止越界
            //val<arr[valPreIndex] 如果当前值，小于前一个值，则进行前值后移操作
            while (valPreIndex>=0 && val<arr[valPreIndex]){
                arr[valPreIndex+1] = arr[valPreIndex];
                valPreIndex--;
            }
            //退出循环时，则证明当前值比前一个值大，这时进行插入即可
            arr[valPreIndex+1] = val;
        }



        return arr;
    }
}
