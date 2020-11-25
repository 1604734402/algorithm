package com.data_structure.stack;

public class ArrayStack {

    //栈的最大长度，容量
    private int maxSize;
    //数组模拟栈
    private int[] stack;
    //栈顶指针
    private int top;

    /**
     * 通过传入容量来初始化栈
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    /**
     * 判断栈满
     * 因为maxSize为数组初始化容量，所以栈顶到数组最后一个指针则判断为满
     * @return
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * 判断栈空
     * 如果栈顶为初始化值，则说明未插入数据
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * push数据
     * 先移动栈顶指针，然后插入数据
     * @param val
     */
    public void push(int val){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = val;
    }

    /**
     * pop数据
     * 由于有返回值，先将数据保存，然后进行指针后移
     * @return
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 遍历栈
     * 由于是数组模拟栈，所以要从后往前进行遍历
     */
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }

        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]:%d\n",i,stack[i]);
        }
    }


}
