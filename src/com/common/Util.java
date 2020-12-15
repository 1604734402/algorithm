package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");


    public static int[] random(int size,int maxNum){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * maxNum);
        }
        return arr;
    }

    public static String curTime(){
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d,", i);
        }
        System.out.println();
    }

}
