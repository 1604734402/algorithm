package com.leetcode;

import com.common.TreeNode;

/**
 * @auther liuyiming
 * @date 2021/4/25 08:38
 * @description
 */
public class LeetCode_897 {

    public static TreeNode resNode;

    public static void main(String[] args) {

        TreeNode head = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        head.left = node2;
        head.right = node3;

//        TreeNode treeNode = new TreeNode();
//        TreeNode temp = treeNode;


        increasingBST(head);


    }


    public static TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        search(root);
        return dummyNode.right;
    }



    public static void search(TreeNode node){

        if (node.left!=null){
            search(node.left);
        }

        resNode.right = new TreeNode(node.val);
        resNode = resNode.right;



        if (node.right!=null){
         search(node.right);
        }



    }

}
