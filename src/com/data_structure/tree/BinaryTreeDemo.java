package com.data_structure.tree;


/**
 * 二叉树
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        //用到的节点
        TreeNode root = new TreeNode(1, "1");
        TreeNode node1 = new TreeNode(2, "2");
        TreeNode node2 = new TreeNode(3, "3");
        TreeNode node3 = new TreeNode(4, "4");
        TreeNode node4 = new TreeNode(5, "5");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);

        binaryTree.setRoot(root);
//        System.out.println("↘---前序遍历---↙");
//        binaryTree.preOrder();
//        System.out.println("↗------------↖");
//        System.out.println("↘---中序遍历---↙");
//        binaryTree.infixOrder();
//        System.out.println("↗------------↖");
//        System.out.println("↘---后序遍历---↙");
//        binaryTree.postOrder();
//        System.out.println("↗------------↖");

        System.out.println(binaryTree.preSearch(1).toString());
        System.out.println(binaryTree.preSearch(2).toString());
        System.out.println(binaryTree.preSearch(3).toString());
        System.out.println(binaryTree.preSearch(4).toString());
        System.out.println(binaryTree.preSearch(5).toString());
        System.out.println("---------------------------------");
        System.out.println(binaryTree.infixSearch(1).toString());
        System.out.println(binaryTree.infixSearch(2).toString());
        System.out.println(binaryTree.infixSearch(3).toString());
        System.out.println(binaryTree.infixSearch(4).toString());
        System.out.println(binaryTree.infixSearch(5).toString());
        System.out.println("---------------------------------");
        System.out.println(binaryTree.postSearch(1).toString());
        System.out.println(binaryTree.postSearch(2).toString());
        System.out.println(binaryTree.postSearch(3).toString());
        System.out.println(binaryTree.postSearch(4).toString());
        System.out.println(binaryTree.postSearch(5).toString());

    }
}