package com.leetcode.esay;


public class e_9 {


    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;

        if (x%10 == 0 && x != 0)
            return false;

        int y = 0;
        while (x>y){
            y = y*10 + x%10;
            x = x/10;
        }
        System.out.println(x);
        System.out.println(y);
        return  x==y || y/10 ==x ;
    }

    public static boolean isPalindrome1(int x) {
        if (x<0)
            return false;

        if (x%10 == 0 && x != 0)
            return false;
        int z = x;
        int y = 0;
        while (x>0){
            y = y*10 + x%10;
            x = x/10;
        }
        System.out.println(z);
        System.out.println(y);
        return  z == y ;
    }



    public static void main(String[] args) {
            int x = 123321;
        System.out.println(isPalindrome1(x));;

    }
}
