package com;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {

        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};

        hanoiTower(3,"A","B","C");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            return intersect(nums2, nums1);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                Integer integer = map.get(i);
                map.put(i, ++integer);
            }
        }

        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) != 0) {
                result[index] = i;
                Integer integer = map.get(i);
                map.put(i, --integer);
                index++;
            }
        }
        int[] result1 = new int[index];
        for (int i = 0; i < index; i++) {
            result1[i] = result[i];
        }
        return result1;

    }

    /**
     * 汉诺塔
     * @param num 总共有几个盘
     * @param begin 开始柱
     * @param transfer 中转柱
     * @param end 结束柱
     */
    public static void hanoiTower(int num,String begin,String transfer,String end){
        //如果只有一个盘的情况下，直接把开始柱的盘移动到结束盘
        if(num == 1){
            System.out.println(begin+"->"+end);
        }else {
            //如果是大于等于2个盘的情况
            //先把开始柱所有盘移动到中转柱(如果说到了最后一个盘，那么会直接将最后一个移动到结束柱)
            hanoiTower(num-1,begin,end,transfer);
            //再把开始柱上最后一个移动到结束柱
            System.out.println(begin+"->"+end);
            //最后将中转柱上所有盘移动到结束柱
            hanoiTower(num-1,transfer,begin,end);
        }
    }
}




 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

