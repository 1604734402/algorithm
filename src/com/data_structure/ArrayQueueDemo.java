package com.data_structure;

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

/**
 * 一次性队列,即插入到队列尾后不能再次插入,哪怕前面数据已取出
 */
class OneTimeArrayQueue {

    private int maxSize; //表示数组长度
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //用数组模拟队列

    /**
     * 构造函数初始化队列长度
     * <p>
     * front是指向队列头的前一个位置
     * rear 指向队列尾部
     *
     * @param maxSize
     */
    public OneTimeArrayQueue(int maxSize) {
        this.maxSize = maxSize; //最大长度
        this.arr = new int[maxSize]; //新建队列
        this.front = -1; //初始化队列头
        this.rear = -1; //如诗画队列尾
    }

    /**
     * 判断队列是否满
     * 队列头指向队列最后一个数据，则队列满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * 如果队列头等于队列尾，则改队列为空
     * 如果插入数据时，队列尾必将后移
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列
     *
     * @param val 添加数据
     */
    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列已满，不能插入数据");
            return;
        }
        rear++; //让rear后移

        arr[rear] = val;

    }

    /**
     * 获取队列数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        front++;//队列头后移
        return arr[front];

    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]:" + arr[i]);
        }
    }

    /**
     * 显示头数据
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front + 1];
    }
}

/**
 * 环形队列
 * <p>
 * 1、front指向队列的第一个元素
 * 2、rear指向队列的最后一个元素的后一个位置
 * 3、空出一个空间作为约定
 * 4、队列满时,(rear +1) % maxSize = front
 * 5、队列空时,rear = front
 * 6、初始化时,front = 0;rear =0
 * 7、队列有效个数,(rear + maxSize - front)%maxSize
 */
class CircleArrayQueue {

    private int maxSize; //表示数组长度

    private int front;//队列头

    private int rear;//队列尾

    private int[] arr;//用数组模拟队列

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 判断队列是否满
     * 尾部加一是否等于头
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * 如果头等于尾，则这个队列为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据
     * 由于rear指向最后一个数据的后一个元素，所以直接将数据加入
     * 加入数据后，将rear后移
     * @param val
     */
    public void addQueue(int val) {
        if (isFull()) {
            System.out.println("队列已满，不能插入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = val;
        //将rear后移
        rear = (rear + 1) % maxSize;

    }

    /**
     * 取数据
     * 把要取出的值保留到临时变量
     * 将front后移
     * 把临时变量放回
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;

    }

    /**
     * 显示队列的所有数据
     * 从front遍历，遍历多少个元素
     */
    public void showQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }

        int num = front;
        for (int i = 0; i <showQueueNum(); i++) {
            System.out.println("arr[" + i + "]:" + arr[num]);
            num = (num+1)%maxSize;
        }
    }

    /**
     * 显示队列的有效个数
     *
     * @return
     */
    public int showQueueNum() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }

        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示头数据
     *
     * @return
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front];
    }

}
