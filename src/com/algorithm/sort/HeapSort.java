package com.algorithm.sort;

import com.common.Util;

/**
 * @auther liuyiming
 * @date 2021/1/14
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        //数组升序
        int arr[] = {4, 6, 8, 5, 9};

//        int[] a = Util.random(50000000, 8098998);
//        System.out.println(Util.curTime());
        smallHeap(arr);
        Util.printArray(arr);
//        System.out.println(Util.curTime());
    }

    /**
     * 大顶堆
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeapRecursion(arr, i, arr.length - 1);
        }
        //排序
        for (int i = arr.length - 1; i >= 1; i--) {
            Util.swap(arr, 0, i);
            adjustHeapRecursion(arr, 0, i - 1);
        }
    }

    /**
     * 小顶堆
     *
     * @param arr
     */
    public static void smallHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            smallHeap(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            Util.swap(arr, 0, i);
            smallHeap(arr, 0, i - 1);
        }

    }


    /**
     * 迭代建堆
     * 将一个数组(二叉树)，调整成一个大顶堆
     * 完成将以i对应的非叶子节点的数调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整 length是在逐渐减少的
     */
    public static void adjustHeapIteration(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //i * 2 + 1 是 i的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果说左子节点小于右子节点的值,则指针指向右节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//k指向右子节点
            }
            //左右两节点较大的那个，和跟节点进行比较
            if (arr[k] > temp) { //如果子节点大于父节点
                //由于这里没有break，所以下次迭代，k的值相当于被调整的左右节点，
                // 然后继续以被调整左右节点为root节点来调整 左右节点
                arr[i] = arr[k]; //把较大的值，赋给当前节点
                i = k; //i指向K,继续循环比较
            } else {
                break;
            }
            arr[i] = temp;
        }

    }

    /**
     * 递归建堆
     * 通过比较寻找左右子树
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeapRecursion(int[] arr, int i, int length) {

        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int tempIndex;

        //确保左右节点不越界
        if (left <= length && right <= length) {
            //这里取左右节点中，较大的节点
            tempIndex = arr[left] > arr[right] ? left : right;
        } else if (left <= length) {
            //如果只有左子树，那么就取左子树下标
            tempIndex = left;
        } else if (right <= length) {
            //如果只有右子树，那么就取右子数下标
            tempIndex = right;
        } else return;//两个都越界，说明是一个子节点，无需建堆或调整

        //左右中最大的与父节点比较
        if (arr[tempIndex] > arr[i]) {
            Util.swap(arr, tempIndex, i);
            adjustHeapRecursion(arr, tempIndex, length);
        }

    }

    /**
     * 迭代建堆
     * 小顶堆
     * @param arr
     * @param i
     * @param length
     */
    public static void smallHeap(int[] arr, int i, int length) {
        //先保存父节点
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {

            if (k + 1 < length && arr[k] > arr[k + 1]) {
                k++;
            }

            if (arr[k] < temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }

            arr[i] = temp;
        }


    }

    /**
     * 递归建堆
     * 小顶堆
     * @param arr
     * @param i
     * @param length
     */
    public static void smallHeap2(int[] arr, int i, int length) {

        //左孩子指针
        int left = i * 2 + 1;
        //右孩子指针
        int right = i * 2 + 2;
        //选出最小指针与父节点比较
        int tempInedx;

        if (left <= length && right <= length) {
            tempInedx = arr[left] < arr[right] ? left : right;
        } else if (left <= length) {
            tempInedx = left;
        } else if (right <= length) {
            tempInedx = right;
        } else return;

        if (arr[i] > arr[tempInedx]) {
            Util.swap(arr, i, tempInedx);
            smallHeap2(arr, tempInedx, length);
        }

    }


}
