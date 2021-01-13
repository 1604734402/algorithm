package com.data_structure.tree;

import java.util.ArrayList;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * 1、n个节点的二叉链表中含有N+1 公司 2n-(n-1) = n+1 个空指针域，
 *  利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针(这种附加的指针成为“线索”)
 * 2、这种加上了线索的二叉链表被成为线索链表，相应的二叉树成为线索二叉树(Threaded BinaryTree).
 *  根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
 * 3、一个节点的前一个节点，成为前驱节点
 * 4、一个节点的后一个节点，成为后继节点
 *
 * 当线索二叉树后，Node节点的属性Left和right
 * 1、left指向的是左子树，也可能指向的前驱节点
 * 2、right指向的是右子数，也可能指向后继节点
 */
public class ThreadedBinaryTree {

    private TreeNode root;

    //在线索化二叉树时候，指向前驱节点
    private TreeNode pre;

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

    /**
     * 线索化二叉树
     * @param node
     */
    public void threadedNodes(TreeNode node){

        if (node == null){
            return;
        }

        threadedNodes(node.getLeft());

        threadedNodes(node.getRight());



    }





}
