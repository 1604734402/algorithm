package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");


    /**
     * 创建随机数组
     *
     * @param size   数据量
     * @param maxNum 0-maxNum 范围
     * @return
     */
    public static int[] random(int size, int maxNum) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxNum);
        }
        return arr;
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static String curTime() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 打印当前时间
     */
    public static void printCurTime() {
        System.out.println(simpleDateFormat.format(new Date()));
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d,", i);
        }
        System.out.println();
    }

    /**
     * 交换数组中的数据
     *
     * @param arr    要交换的数组
     * @param index1 数据1
     * @param index2 数据2
     */
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
