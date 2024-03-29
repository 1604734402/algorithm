package com.algorithm.topten;

import java.util.Arrays;

/**
 * @auther liuyiming
 * @date 2021/2/5 10:27
 * @description KMP字符串匹配
 */
public class Kmp {


    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "l";

        String kmp1 = "BBC ABCDAB ABCDABCDABDE";
        String kmp2 = "ABCDABD";

        // 0[A]
        // 1[AA] A | A
        // 2[AAA] A AA | AA A
        // 0[AAAB] A AA AAA | AAB AB B
        // 2[AABAA] A AA AAB AABA | A AA BAA ABAA
//        System.out.println(Arrays.toString(kmpNext("AAABA")));
        System.out.println(kmp(str1, str2,kmpNext(str2)));
    }

    /**
     * 暴力匹配
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int violentMatch(String str1, String str2) {
        if (str1.length() <= 0 || str2.length() <= 0) {
            return -1;
        }
        char[] str11 = str1.toCharArray();
        char[] str22 = str2.toCharArray();

        int i = 0;
        int j = 0;
        while (i < str11.length) {
            if (str11[i] == str22[j]) {
                j = 0;
                int ii = i;
                boolean flag = true;
                while (j < str22.length) {
                    if (str11[ii] != str22[j]) {
                        flag = false;
                    }
                    ii++;
                    j++;
                }
                if (flag) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    /**
     * KMP算法
     *
     * @param str1 原字符串
     * @param str2 子串
     * @param next 子串的部分匹配表
     * @return 返回第一个匹配的位置，如果没有则为-1
     */
    public static int kmp(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str1.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                //这里 i是str1的长度，在for循环中是动态增加的
                //j寻找到str2长度相同，那就证明 j是遍历到了和str2也就是相匹配字符串的长度
                //此时i的长度并不是str1的长度，i的末尾一定和j的末尾一样
                return i - j + 1;
            }
        }

        return -1;
    }

    /**
     * 获取到一个字符串(子串)的部分匹配表
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {

        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度为1，部分匹配值就是0
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) ！= dest.charAt(j) 我们需要从next[j-1]获取新的j
            //直到发现有dest.charAt(i) == dest.charAt(j) 才退出
            //KMP算法核心  j从后往前找，一直找到和第一个相同的值
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //当dest.charAt(i) == dest.charAt(j) 满足是，部分匹配值就+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
