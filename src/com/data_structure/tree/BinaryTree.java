package com.data_structure.tree;

import java.util.ArrayList;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * 二叉树
 * Why
 * 1、数组
 *  优点：通过下标方式访问元素，速度快。对于有序数组，还可使用二分查找提高检索速度
 *  缺点：如果要检索具体某个值，或者插入值(按一定顺序)会整体移动，效率较低
 * 2、链表
 *  优点：在一定程度上对数组存储方式有优化，插入，删除
 *  缺点：再进行检索时，效率较低，需要从头开始遍历
 * 3、树
 * 能提高数据存储，读取的效率
 * 利用二叉排序树，既可以保证数据的检索速度，同时也可以保证数据插入，删除，修改速度
 *
 *
 *
 *
 */
public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 前序查找
     * @param id
     * @return
     */
    public TreeNode preSearch(int id){
        return root.preSearch(id);
    }

    /**
     * 中序查找
     * @param no
     * @return
     */
    public TreeNode infixSearch(int no){
        return root.infixSearch(no);
    }

    /**
     * 后续查找
     * @param no
     * @return
     */
    public TreeNode postSearch(int no){
        return root.postSearch(no);
    }

    /**
     * 删除
     * 先左再右
     * @param no
     * @return
     */
    public boolean preDelRoot(int no){
        if (root == null){
            return false;
        }
        if (root.getId() == no){
            root = null;
            return true;
        }
        return root.preDelChildRoot(no);
    }

    /**
     * 先右再左
     * @param no
     * @return
     */
    public boolean postDelRoot(int no ){
        if (root == null){
            return false;
        }
        if (root.getId() == no){
            root = null;
            return true;
        }

        return root.postDelChildRoot(no);
    }





}
