package com.data_structure.tree_high;

/**
 * @auther liuyiming
 * @date 2021/1/17 15:23
 * @description 二叉排序树节点
 */
public class BinarySortTreeNode {

    private int val;

    private BinarySortTreeNode left;
    private BinarySortTreeNode right;

    public BinarySortTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinarySortTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySortTreeNode left) {
        this.left = left;
    }

    public BinarySortTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySortTreeNode right) {
        this.right = right;
    }

    /**
     * 递归添加节点
     *
     * @param node
     */
    public void add(BinarySortTreeNode node) {

        if (node == null) {
            return;
        }

        //判断传入的节点值，和当前子树的根节点的值关系
        if (node.getVal() < this.getVal()) {
            //如果当前节点左子节点为空
            if (this.getLeft() == null) {
                this.setLeft(node);
            } else {
                this.getLeft().add(node);
            }

        } else {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.getRight().add(node);
            }
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param val 要删除节点的值
     * @return 如果找到返回该节点，否则为null
     */
    public BinarySortTreeNode search(int val) {
        if (val == this.getVal()) {//如果相等，则说明找到，直接返回
            return this;
        } else if (val < this.getVal()) { //如果小于，说明需要左递归
            if (this.getLeft() != null) {
                return this.getLeft().search(val);
            }
        } else {
            if (this.getRight() != null) { //如果大于，说明需要右递归
                return this.getRight().search(val);
            }
        }
        return null;
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param val 要找到的节点的值
     * @return
     */
    public BinarySortTreeNode searchParent(int val) {
        //如果当前节点就是要删除节点的父节点，就返回
        if ((this.getLeft() != null && this.getLeft().getVal() == val) || (this.getRight() != null && this.getRight().getVal() == val)) {
            return this;
        }else{
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (val < this.getVal() && this.left!=null){
                //左递归
                return this.getLeft().searchParent(val);
            }else if (val>=this.getVal() && this.right != null){
                //右递归
                return this.getRight().searchParent(val);
            }else {
                //没找到父节点
                return null;
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void infixOrder(BinarySortTreeNode node) {

        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            node.infixOrder(node.getLeft());
        }
        System.out.println(node.getVal());
        if (node.getRight() != null) {
            node.infixOrder(node.getRight());
        }
    }


}
