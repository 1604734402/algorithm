package com.algorithm.search;


import java.util.Arrays;

/**
 * @auther liuyiming
 * @date 2021/1/11
 * <p>
 * 与前两种类似，只不过不是通过中间值而是黄金分割点附近mid = low+F(k-1)-1
 * 1、由斐波那契数列F[K]=F[K-1]+F[K-2]的性质，可得到(F[K]-1)=(F[K-1]-1)+(F[K-2]-1)+1
 * 该式说明，只要顺序表的长度为F[K]-1,则可以将该表分成长度为F[K-1]-1和F[K-2]-1的两段
 * 2、类似的，每一子段也可以用相同的方式分割
 * 3、顺序表长度n不一定刚好等于f[K]-1,所有需要将原来的循序表长度n增加值F[K]-1。
 * 这里的K值只要能使得F[K]-1恰好大于或等于n即可
 * 序表长度增加后,新增的位置(从n+1到F[K]-1位置),都赋为n位置的值即可
 * <p>
 * while(n>fib(k)-1) k++;
 */
public class FibonacciSearch {


    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 110, 89, 1000, 1234};
//        System.out.println(fibSearch(arr, 1000));
        System.out.println(testFib(arr, 1000));
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


    /**
     * 递归法
     *
     * @param a
     * @param key
     * @return
     */
    public static int testFib(int[] a, int key) {
        int k = 0;
        int[] f = fib();
        int low = 0;
        int high = a.length - 1;
        while (high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(a, f[k] - 1);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        return testFib(temp, low, high, f, k, key);
    }

    public static int testFib(int[] arr, int low, int high, int[] f, int k, int findVal) {

        int mid = low + f[k - 1] - 1;

        if (low < high) {
            if (findVal == arr[mid]) {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            } else if (findVal < arr[mid]) {
                return testFib(arr, low, mid - 1, f, --k, findVal);
            } else {
                k = k - 2;
                return testFib(arr, mid + 1, high, f, k, findVal);
            }
        }

        return -1;
    }


}
