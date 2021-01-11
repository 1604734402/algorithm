package com.algorithm.search;

import javax.swing.text.AsyncBoxView;
import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 110, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1000));
    }

    /**
     * 获取斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找
     * 非递归
     *
     * @param a   需要查找的数组
     * @param key 要找值的下标
     * @return
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int f[] = fib();//获取到斐波那契数列

        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k] 可能大于a的长度，隐藏我我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);

        //需要使用a数组的最后数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }



        //使用while来循环处理找到key
        while (low <= high) { //只要还未找到，则一直找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//应该向数组的前面查找(左边)
                high = mid - 1;
                //1、全部元素 = 前面的元素 + 后边元素
                //2、f[k] = f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2]+f[k-3]
                //即在f[k-1]的前面继续查找
                k--;
            } else if (key > temp[mid]) {//向数组的后面查找
                low = mid + 1;
                //1、全部元素 = 前面的元素 + 后边元素
                //2、f[k] = f[k-1]+f[k-2]
                //3、因为后面有f[k-2] 所以可以继续拆分f[k-1] = f[k-3]+f[k-4]
                //4、即在f[k-2]的前面进行查找 k -=2
                //5、即下次循环 mid = f[k -1 -2] -1
                k -= 2;
            } else { //如果找到
                //需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;

    }

}
