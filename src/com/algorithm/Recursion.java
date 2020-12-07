package com.algorithm;

/**
 * 递归
 *
 * 递归就是方法自己调用自己，每次调用时传入不同的变量，
 * 递归有助于编程者坚决复杂的问题，同时少写代码
 *
 * 1、执行一个方法上，就会创建一个新的受保护的独立空间(栈、栈帧)
 * 2、方法的局部变量是独立的，不会相互影响
 *      如果方法中使用的是引用类型变量(静态变量等)，就会共享该引用类型的数据 
 * 3、递归必须向退出递归的条件比较，否则就是无限递归，栈溢出
 * 4、当一个方法执行完毕，或者遇到return,就会返回，遵守谁调用，就将结果返回谁
 *      同时，当方法指向完毕或者返回时，该方法也就执行完毕
 */
public class Recursion {

    public static void main(String[] args) {
//        testPrint(4);

        System.out.println(factorial(10));
    }

    /**
     * 打印问题
     * 从小到大打印，加不加else是两回事
     * @param n
     */
    public static void testPrint(int n){
        if (n>2){
            testPrint(n-1);
        }
        System.out.println(n);
    }

    /**
     * 阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else {
            return factorial(n -1) * n;
        }
    }
}
