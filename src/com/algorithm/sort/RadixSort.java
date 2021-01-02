package com.algorithm.sort;

import com.common.Util;

/**
 * 基数排序
 * 属于分配至排序，又称“桶子法”或bin sort 顾名思义，它是通过键值的各个位数值
 * 将要排序的元素分配至某些“桶”中，达到排序的作用
 * <p>
 * 基数排序法师属于稳定性的排序，技术排序法师效率高的稳定性排序法
 * <p>
 * 基数排序是桶排序的扩展
 * <p>
 * <p>
 * 将所有待比较熟知统一为同样的位数长度，位数较短的数前面补0
 * 从最低位开始，依次进行一次排序，这样从最低位排序一直到最高位排序完成以后，数列就变成了一个有序序列
 */
public class RadixSort {

    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println(Util.curTime());

        int arr[] = Util.random(40000000, 40000000);
        myRadixSort(arr);
        System.out.println(Util.curTime());
//        Util.printArray(arr);
    }

    public static void radixSort(int[] arr) {
        //针对每个元素的个位数进行排序处理

        //定义一个二维数组，表示10个桶，每个桶就是一个一位数组
        //1、二维数组包含10个一位数组
        //2、为了防止在放入数的时候，数据溢出，每一个一位数组的大小定位arr.length
        //3、基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一位数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一位数组的小兵一次取出数据，放入原来数组)
        int index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中没有数据，则直接跳过
            if (bucketElementCounts[i] != 0) {
                //循环非空桶，放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }


        Util.printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一位数组的小兵一次取出数据，放入原来数组)
        index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中没有数据，则直接跳过
            if (bucketElementCounts[i] != 0) {
                //循环非空桶，放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }

        Util.printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 100 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一位数组的小兵一次取出数据，放入原来数组)
        index = 0;
        //遍历每一个桶，并将桶中数据，放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中没有数据，则直接跳过
            if (bucketElementCounts[i] != 0) {
                //循环非空桶，放入原数组
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }

        Util.printArray(arr);

    }

    public static void myRadixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        max = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int divisor = 1;
        int index;
        for (int divisornum = 0; divisornum < max; divisornum++) {

            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[i] / divisor % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            index = 0;
            for (int i = 0; i < bucket.length; i++) {
                //如果桶中没有数据，则直接跳过
                if (bucketElementCounts[i] != 0) {
                    //循环非空桶，放入原数组
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                bucketElementCounts[i] = 0;
            }

            divisor *= 10;
        }
    }
}
