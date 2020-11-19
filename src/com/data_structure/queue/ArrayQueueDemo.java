package com.data_structure.queue;

import java.util.Scanner;

/**
 * 队列
 * <p>
 * 1、队列是一个有序列表,可以用数组或是链表来表示
 * 2、遵循先入先出的原则,即：先存入队列的数据，要先去除，后存入的数据要后取出
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {


//        oneTimeArrayQueue();

        circleArrayQueue();


    }

    private static void oneTimeArrayQueue() {
        OneTimeArrayQueue arrayQueue = new OneTimeArrayQueue(3);

        Scanner scanner = new Scanner(System.in);
        char key = ' ';//用户输入的Key
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    System.out.println("退出程序");
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int val = scanner.nextInt();
                    arrayQueue.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据为：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("头数据为：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("请输入正确字符串");
                    break;
            }
        }
    }

    private static void circleArrayQueue() {
        CircleArrayQueue arrayQueue = new CircleArrayQueue(5);

        Scanner scanner = new Scanner(System.in);
        char key = ' ';//用户输入的Key
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    System.out.println("退出程序");
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int val = scanner.nextInt();
                    arrayQueue.addQueue(val);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据为：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("头数据为：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'n':
                    try {
                        int res = arrayQueue.showQueueNum();
                        System.out.println("有效个数为：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("请输入正确字符串");
                    break;
            }
        }
    }

}




