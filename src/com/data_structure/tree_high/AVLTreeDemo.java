package com.data_structure.tree_high;

/**
 * @auther liuyiming
 * @date 2021/1/18 10:31
 * @description
 */
public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4,3,6,5,7,8};
        int[] arr = {10,8,12,7,9,6};
        AVLTree avlTree = new AVLTree();

        for (int i : arr) {
            avlTree.add(new AVLTreeNode(i));
        }

//        avlTree.infixOrder();
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().getLeft().height());
        System.out.println(avlTree.getRoot().getRight().height());
        System.out.println(avlTree.getRoot().getVal());
        System.out.println(avlTree.getRoot().getRight().getVal());
        System.out.println(avlTree.getRoot().getRight().getLeft().getVal());
        System.out.println(avlTree.getRoot().getRight().getRight().getVal());
//        System.out.println(avlTree.getRoot().getLeft().getVal());
//        System.out.println(avlTree.getRoot().getLeft().getLeft().getVal());
    }


}
