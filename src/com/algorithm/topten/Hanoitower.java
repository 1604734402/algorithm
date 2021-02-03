package com.algorithm.topten;

/**
 * @auther liuyiming
 * @date 2021/2/3 9:36
 * @description 汉诺塔
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(3, "A","B","C");
    }

    /**
     * 汉诺塔
     * @param num 在开始柱上多少个盘子
     * @param begin 开始柱
     * @param transit 中转柱
     * @param end 结束柱
     */
    public static void hanoiTower(int num,String begin,String transit,String end){
        if (num == 1){
            System.out.println(begin+"->"+end);
        }else {
            hanoiTower(num-1, begin, end, transit);
            System.out.println(begin+"->"+end);
            hanoiTower(num-1, transit, begin, end);
        }
    }
}
