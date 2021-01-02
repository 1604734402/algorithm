package com.algorithm.sort;

import com.common.Util;

/**
 * 归并排序
 * 利用归并的思想实现的排序方法，该算法采用经典的分治策略
 * 递归拆分子序列
 * 分治(分而治之)：
 * 分治法将问题分成一些小的问题然后递归求解，而治的阶段则将分的阶段得到的答案“修补”在一起
 * 边分边合
 */
public class MergeSort {
    static int curCount = 0;
    static int curCount1 = 0;

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        Util.printArray(arr);

    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
//        System.out.println("curCount1:"+curCount1++);
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //左递归进行分解
            mergeSort(arr,left,mid,temp);
            //右递归进行分解机
            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }


    }


    /**
     * @param arr   需要排序的原始数组
     * @param left  左边序列的初始下标
     * @param mid   中间件索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.printf("左下标:%d,中间开始下标:%d,右下标:%d\n",left,mid,right);

        int i = left;//初始化i ,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//临时数组(temp)的初始索引

        //先把左右两边的(有序)的数据安装规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列当前元素，小于等于右边有序序列的当前元素
            //即将左边的元素,拷贝到temp数组
            //t后移，i后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }

        }

        //把有剩余数据的一边的数据局级依次全部填充到temp

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp数组中排好序的元素拷贝到arr
        t = 0;
        int temLeft = left;
        while (temLeft <= right) {
            arr[temLeft] = temp[t];
            t++;
            temLeft++;
        }

    }


    /**
     * @param arr   需要排序的原始数组
     * @param left  左边序列的初始下标
     * @param mid   中间件索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge1(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;//初始化i ,左边有序序列的初始索引
        int j = mid + 1;//初始化j,右边有序序列的初始索引
        int t = 0;//临时数组(temp)的初始索引

        //先把左右两边的(有序)的数据安装规则填充到temp数组
        while (i <= mid && j <= right) {
            //如果左边的有序序列当前元素，小于等于右边有序序列的当前元素
            //即将左边的元素,拷贝到temp数组
            //t后移，i后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //直到左右两边的有序序列，有一边处理完毕为止


        //把有剩余数据的一边的数据局级依次全部填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }


        //将temp数组的元素拷贝到arr
        for (int k = 0; k < arr.length; k++) {
            arr[k] = temp[k];
        }

    }

}
