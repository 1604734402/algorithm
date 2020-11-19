package com.data_structure.queue;

/**
 * 一次性队列,即插入到队列尾后不能再次插入,哪怕前面数据已取出
 */
public class OneTimeArrayQueue {

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
