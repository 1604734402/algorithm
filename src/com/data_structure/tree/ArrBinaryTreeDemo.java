package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/13
 * 顺序存储二叉树
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
//        arrBinaryTree.preOrder(0);
//        arrBinaryTree.inifxOrder(0);
        arrBinaryTree.postOrder(0);
    }
}
