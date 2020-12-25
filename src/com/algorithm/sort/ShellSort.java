package com.algorithm.sort;

import com.common.Util;

/**
 * 希尔排序
 * 缩小增量排序
 * 希尔排序是把记录按下表的一定增量分组，对每组使用盒子精插入排序算法排序
 * 随着增量逐渐减少，每组包含的关键字越来越多，当增量减至1时，整个文件被分组一组
 * 进行插入排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        int[] arr = {8,9,11,7,2,3};
//        Util.printArray(arr);
        Util.printArray(shellSort2(arr));
    }


    /**
     * 位移式，插入排序
     * 以步长分组，最后再进行一次插入排序
     *
     * @param arr
     * @return
     */
    private static int[] myShellSort(int[] arr) {

        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //引用i的值，因为这是初始下标，还需要++
                int j = i;
                //先把需要移动的下标保存
                int temp = arr[j];
                //如果当前下标值小于前一个步长值，那么就开始进行循环替换
                if (arr[j] < arr[j - gap]) {
                    //j-gap >=0 防止减步长值越界
                    //temp < arr[j-gap] 如果发现后一个步长比前一个大，那么就进行覆盖
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出循环时,则证明找到合适位置，将保存的值插入
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] sehllSort(int[] arr) {
        int temp = 0;
        for (int x = arr.length; x > 0; x /= 2) {
            //先分组排序,第i个相当于和第i+x相比
            for (int i = x; i < arr.length; i++) {
                //遍历各组中的元素(以 x/=2 的哈希值来区分组数 每组相隔x个数)
                for (int j = i - x; j >= 0; j -= x) {
                    //如果当前元素大于 相隔的元素，那么就需要交换
                    if (arr[j] > arr[j + x]) {
                        temp = arr[j];
                        arr[j] = arr[j + x];
                        arr[j + x] = temp;
                    }

                }

            }

        }

        return arr;
    }

    private static int[] shellSort1(int[] arr) {

        for (int gap = arr.length; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }

            }

        }

        return arr;
    }

    private static int[] shellSort2(int[] arr) {

        for (int gap = arr.length; gap > 0; gap--) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j-gap] > arr[j]) {
                    while (j - gap >= 0 && arr[j-gap] > arr[j]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;

                }

            }

        }
        return arr;
    }
}
