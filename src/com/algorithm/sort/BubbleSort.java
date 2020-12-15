package com.algorithm.sort;

import com.common.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * 冒泡排序
 * 思想：
 * 通过对待排序序列从前向后，依次比较相邻元素的值，
 * 若发现逆序则交换，使值较大的元素逐渐从前向后移动
 * 规则：
 * 1、一共进行数组的大小-1次大循环
 * 2、每一趟排序的次数都在逐步减少
 * 3、如果发现在某趟循环后，未发生排序，可以提前结束冒泡排序(优化)
 */
public class BubbleSort {

    public static void main(String[] args) {

        int arr[] = Util.random(30000, 8000000);

        System.out.println(Util.curTime());
        bubbleSortMajorization(arr);
//        bubbleSort(arr);
        System.out.println(Util.curTime());
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        //用于交换的临时变量
        int temp = 0;
        //外循环，使得每次循环次数递减
        for (int i = arr.length - 1; i > 0; i--) {
            //内循环
            for (int j = 0; j < i; j++) {
                //若发现后一个大于前一个，则进行交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 优化排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSortMajorization(int[] arr) {
        //用于交换的临时变量
        int temp = 0;
        boolean flag = true;
        //外循环，使得每次循环次数递减
        for (int i = arr.length - 1; i > 0; i--) {
            //内循环
            for (int j = 0; j < i; j++) {
                //若发现后一个大于前一个，则进行交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                System.out.println("优化了");
                break;
            } else {
                flag = true;
            }
        }
        return arr;
    }



}
