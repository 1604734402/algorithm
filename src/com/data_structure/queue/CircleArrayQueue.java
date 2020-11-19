package com.data_structure.queue;

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
public class CircleArrayQueue {

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