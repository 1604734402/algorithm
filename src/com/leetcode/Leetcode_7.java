package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/5/3 21:10
 * @description
 */
public class Leetcode_7 {

    public static void main(String[] args) {
        Leetcode_7 l = new Leetcode_7();
        int reverse = l.reverse(0);


        System.out.println(reverse);


    }

    public int reverse(int x) {
        int num = 0;
        boolean negativ = x<0;
        x = negativ?x*-1:x;
        while (x>0){
            int temp = x%10;
            x /=10;
            num = num*10 + temp;
        }

        return negativ?num*-1:num;
    }
}
