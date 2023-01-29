package com.leetcode;

/**
 * @auther liuyiming
 * @date 2021/3/19 11:17
 * @description
 */
public class LeetCode_1603 {

    private int big;
    private int medium;
    private int small;
    private static int _big = 0;
    private static int _medium = 0;
    private static int _small = 0;


    public LeetCode_1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch(carType){
            case 1:
                if(_big<0) return false;
                if(_big>=big){
                    return false ;
                }else{
                    _big++;
                    return true;
                }
            case 2:
                if(_medium<0) return false;
                if(_medium>=medium){
                    return false ;
                }else{
                    _medium++;
                    return true;
                }
            case 3:
                if(_small<0) return false;
                if(_small>=small){
                    return false ;
                }else{
                    _small++;
                    return true;
                }
        }
        return false;
    }
}
