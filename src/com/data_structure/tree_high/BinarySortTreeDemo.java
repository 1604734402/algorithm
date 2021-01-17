package com.data_structure.tree_high;

/**
 * @auther liuyiming
 * @date 2021/1/17 15:22
 * @description 二叉排序树
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {7,3,10,12,5,1,9,2};
        int[] arr = {7,3,10,1,5,9,12,2};
        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i : arr) {
            binarySortTree.add(new BinarySortTreeNode(i));
        }

        binarySortTree.infixOrder();
        System.out.println("================");
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(10);
        binarySortTree.delNode(3);
//        binarySortTree.delNode(1);

        binarySortTree.infixOrder();
    }
}
