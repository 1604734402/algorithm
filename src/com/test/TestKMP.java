package com.test;

import java.util.Arrays;

/**
 * @auther liuyiming
 * @date 2021/5/17 16:18
 * @description
 */
public class TestKMP {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
//        String str1 = "ABCBDDA";
//        String str2 = "BD";

        System.out.println(kmp(str1,str2));

    }

    public static int kmp(String str1,String str2) {
        int[] next = getNext(str2);
        int i = 0,j = 0;
        while (i<str1.length()){

            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i-j+1;
            }
            i++;
        }


        return -1;
    }

    public static int[] getNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        int i = 1,j = 0;
        while (i<dest.length()){

            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }

            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
            i++;
        }
        return next;
    }
}
