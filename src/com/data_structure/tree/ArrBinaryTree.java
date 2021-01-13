package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/13
 * <p>
 * 顺序存储二叉树
 * 1、顺序存储二叉树通常只考虑完全二叉树
 * 2、第n个元素的左子节点为2 * n +1
 * 3、第n个元素的右子节点为2*n+2
 * 4、第n个元素的父节点为(n-1)/2
 * 5、n表示二叉树中的第几个元素
 *
 * 数组还是原来数组，只是以二叉树的方式来遍历
 */
public class ArrBinaryTree {

    private int[] arr; //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
            return;
        }

        System.out.println(arr[index]);

        //左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }

    }

    /**
     * 中序遍历
     *
     * @param index
     */
    public void inifxOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
            return;
        }

        if ((index * 2 + 1) < arr.length) {
            inifxOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length) {
            inifxOrder(index * 2 + 2);
        }
    }

    /**
     * 后续遍历
     *
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("二叉树为空");
            return;
        }

        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        System.out.println(arr[index]);


    }


}
