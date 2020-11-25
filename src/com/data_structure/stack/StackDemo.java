package com.data_structure.stack;

/**
 *
 * 定义：
 * 栈是一个先入后出的有序列表
 * 栈是限制线性表中元素的插入和删除只能在线性表的同一端进行的一种特殊线性表
 * 允许插入和删除的一端，为变化的一端，称为栈顶，另一端为固定的一端，成为栈底
 *
 * 先放入栈中元素在栈底，后放入的元素在栈顶，
 * 删除时先删栈顶，最先放入的元素最后删除
 *
 * 应用场景
 * 1、子程序的调用:在跳往子程序钱，会先将下个执行的地址存到堆栈中，
 * 直到子程序执行完后再将地址取出，以回到原来的程序中
 * 2、处理递归调用:和子程序的调用类似，只是出了储存下一个指令的地之外，
 * 也将参数，区域变量等数据存入堆栈中
 * 3、表达式的转换与求值
 * 4、二叉树的遍历
 * 5、图形的深度优先搜索法
 */
public class StackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        stack.show();
        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
    }
}
