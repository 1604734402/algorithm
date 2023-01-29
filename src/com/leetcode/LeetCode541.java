package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/8/20 09:09
 * @description
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode541 {


    public static void main(String[] args) {
//        String str = "abcd";
//        String turn = rever(str, 4, 5);
        reverseStr("abcd",3);
//        System.out.println(turn);
    }

    public static String reverseStr(String s, int k) {
        int length = s.length();
        int count = 1;
        int i;
        for(i = 0;i<length - (length % k*2);i++){
            if(count == k*2){
                count = 0;
                s = rever(s,i-k*2+1,i-k);
            }
            count++;
        }

        if(length - i >= k){
            s = rever(s,i-1,i+k-1-1);
        }else {
            s = rever(s,i-1, length-1);
        }

        return s;
    }

    private static String rever(String str,int left,int right){
        char[] temp = new char[right-left+1];
        char[] results = str.toCharArray();
        int index = 0;

        for (int i = 0;i<right-left+1;i++){
            temp[i] = str.charAt(right-i);
        }

        while(left<=right){
            results[left] = temp[index];
            left++;
            index++;
        }

        return new String(results);
    }

}
