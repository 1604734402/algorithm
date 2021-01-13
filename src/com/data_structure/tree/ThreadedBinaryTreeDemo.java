package com.data_structure.tree;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

        //构建需要的二叉树
        TreeNode root = new TreeNode(1,"1");
        TreeNode node1 = new TreeNode(3,"3");
        TreeNode node2 = new TreeNode(6,"6");
        TreeNode node3 = new TreeNode(8,"8");
        TreeNode node4 = new TreeNode(10,"10");
        TreeNode node5 = new TreeNode(14,"14");

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);

        //中序线索化
//        threadedBinaryTree.infixThreadedNodes();
//        threadedBinaryTree.threadedList();

        //前序线索化
        threadedBinaryTree.preThreadedNodes();
        threadedBinaryTree.preThreadedList();

//        threadedBinaryTree.postThreadedNodes();
//        threadedBinaryTree.postThreadedList();
//        System.out.println( node3.getRight().toString());






    }
}
