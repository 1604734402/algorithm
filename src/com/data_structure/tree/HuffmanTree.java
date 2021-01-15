package com.data_structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther liuyiming
 * @date 2021/1/15
 * 哈夫曼树
 */
public class HuffmanTree {


    /**
     * 创建哈夫曼树
     *
     * @param arr
     */
    public static TreeNode createHuffmanTree(int[] arr) {

        //为了操作方便
        //1、遍历arr数组
        //2、arr的每个元素构建成一个Node
        //3、将Node放入到ArrayList中
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (int val : arr) {
            nodes.add(new TreeNode(val));
        }

        //直到列表里只剩一个最终的父节点
        while (nodes.size() > 1) {

            //排序 从小到大 因为TreeNode类继承了Comparable<> 所以可排序
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //这里取前两个，是因为TreeNode实现Collections接口，
            //重写了compareTo()方法，所以是从小到大升序排序
            //1、取出权值最小的节点(二叉树)
            TreeNode leftNode = nodes.get(0);
            //2、取出权值第二小的节点(二叉树)
            TreeNode rightNode = nodes.get(1);

            //3、构建一个新的二叉树
            TreeNode parent = new TreeNode(leftNode.getVal() + rightNode.getVal());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            //4、从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }

        return nodes.get(0);

    }

    /**
     * 前序遍历
     * 根据传入结点进行遍历
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {

        System.out.println(node);

        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrder(node.getRight());
        }

    }
}
