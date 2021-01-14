package com.algorithm.sort;

import com.common.Util;

/**
 * 快速排序
 * 选定Pivot中心轴
 * 将大于Pivot的数字放在Pivot的右边
 * 将小于Pivot的数字放在Pivot的左边
 * 分别对左右子序列重复前三步操作
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 0, -567, 0};
        testqquickSort(arr, 0, arr.length - 1);
//        quickSortFirst(arr, 0, arr.length - 1);
        Util.printArray(arr);
    }

    /**
     * 以中间的值为基准
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortPrivot(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;
        //中轴值
        int privot = arr[(left + right) / 2];

        //while 循环的目的是让比pivot 值小的放到左边,比Pivot大的值放到右边，进行交换
        while (l < r) {
            //在Pivot的左边一直找，找到一个大于等于pivot的值，退出
            while (arr[l] < privot) {
                l++;
            }
            //在pivot的右边一直找，找到一个小于等于pivot的值，退出
            while (arr[r] > privot) {
                r--;
            }
            //如果l >=r 说明pivot的左右两值，左边都小于pivot值，右边都大于pivot值
            if (l >= r) {
                break;
            }
            //进行交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[1] == pivot值 相等--,前移
            if (arr[l] == privot) {
                r--;
            }
            //如果交换完后，发现arr[r] == pivot值 相等l++,后移
            if (arr[r] == privot) {
                l++;
            }

        }

        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSortPrivot(arr, left, r);
        }

        if (l < right) {
            quickSortPrivot(arr, l, right);
        }


    }

    /**
     * 以第一个数做基准
     * 从前往后开始
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortFirst(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = arr[left];

        //l<r 保证不越界 双指针
        while (l < r) {

            //l <r 保证不越界
            //arr[r]>=pivot从右往左寻找小于pivot的值
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            //如果说寻找到下标r的数大于下标l的数，则进行赋值
            if (l < r) {
                arr[l] = arr[r];
            }

            //从左往右寻找大于pivot的值
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            //如果说寻找到下标l的值小于下标r的值，则进行赋值
            if (l < r) {
                arr[r] = arr[l];
            }
        }
        //当退出循环时，则证明找到合适位置，将预先保存的pivot值赋值
        arr[l] = pivot;


        //左递归
        if (r > left) {
            quickSortFirst(arr, left, r - 1);
        }

        //右递归
        if (l < right) {
            quickSortFirst(arr, l + 1, right);
        }


    }

    /**
     * 以最后一个数做基准
     * 从后往前开始
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortLast(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int pivot = arr[right];

        while (l < r) {

            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (r > l) {
                arr[r] = arr[l];
            }
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            if (r > l) {
                arr[l] = arr[r];
            }
        }

        arr[r] = pivot;

        if (l < right) {
            quickSortLast(arr, l + 1, right);
        }
        if (r > left) {
            quickSortLast(arr, left, r - 1);
        }

    }

    public static void testqquickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[l];

        while (l < r) {
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            if (l < r) {
                arr[l] = arr[r];
            }
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            if (l < r) {
                arr[r] = arr[l];
            }
        }


        arr[l] = pivot;

        if (l < right) {
            testqquickSort(arr, l + 1, right);
        }

        if (r > left) {
            testqquickSort(arr, left, r - 1);
        }


    }

}
