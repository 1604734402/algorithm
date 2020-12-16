package com.algorithm.sort;

import com.common.Util;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3};
        Util.printArray(insertSort(arr));
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
}
