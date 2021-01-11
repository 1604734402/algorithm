package com.algorithm.search;

/**
 * @auther liuyiming
 * @date 2021/1/11
 * <p>
 * 插值查找算法
 * 自适应查找
 * 1、对于数据量大,罐子自副本比较俊宇的查找表来说，采用插值查找，速度较快
 * 2、关键字分布不均匀的情况下，该方法不一定比折半好
 */
public class InsertValueSearch {


    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 2));
//        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr     查询的数组
     * @param left    左下标
     * @param right   右下标
     * @param findVal 需要查找的值
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        if (left <= right && findVal < arr[arr.length - 1] && findVal > arr[0]) {

            int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

            int midVal = arr[mid];
            if (findVal == midVal) {
                return mid;
            } else if (findVal > midVal) { //说明应该向右边递归
                return insertValueSearch(arr, mid + 1, right, findVal);
            } else {
                return insertValueSearch(arr, left, mid - 1, findVal);
            }
        }

        return -1;
    }
}
