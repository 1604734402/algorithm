package com.leetcode.esay;

public class e_14 {
    public static void main(String[] args) {
        String[] arr = {"abc","abcd","abcdefg","ab"};
        String result = minString(arr);
        System.out.println(result);
    }

    public static String minString(String[] strs){
        if (strs.length<=0) return "";
        String first = strs[0];

        for (int i = 0; i <strs.length ; i++) {
            while (strs[i].indexOf(first) != 0){
                first = first.substring(0,first.length()-1);
                if (first.isEmpty()) return "";
            }
        }
        return first;
    }

}
