package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/9/22 17:05
 * @description
 */
public class LeetCode_58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }


    public static int lengthOfLastWord(String s) {
        if(s.length() <=0 ) return 0;
        String[] strs = s.split(" ");
        int length = strs.length;
        for(int i = length-1 ;i>=0 ;i--){
            if(strs[i].length() > 0){
                return strs[i].length();
            }
        }
        return 0;

    }
}
