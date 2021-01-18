package com.data_structure.tree_high;

/**
 * @auther liuyiming
 * @date 2021/1/17 15:34
 * @description 平衡二叉树
 */
public class AVLTree {

    private AVLTreeNode root;

    public AVLTreeNode getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode root) {
        this.root = root;
    }

    /**
     * 添加
     *
     * @param node
     */
    public void add(AVLTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 删除节点
     *
     * @param val
     */
    public void delNode(int val) {
        if (root == null) {
            return;
        }
        //1、寻找删除节点
        AVLTreeNode targetNode = search(val);
        if (targetNode == null) {
            return;
        }

        //如果删除的是根节点
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }

        //2、寻找父节点
        AVLTreeNode parent = searchParent(val);

        //3、删除处理
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            //如果要删除的节点是叶子节点
            //左子节点
            if (parent.getLeft() != null && parent.getLeft() == targetNode) {
                parent.setLeft(null);
                return;
            }
            //右子节点
            if (parent.getRight() != null && parent.getRight() == targetNode) {
                parent.setRight(null);
                return;
            }
        }else if (targetNode.getLeft() != null && targetNode.getRight() != null){
            //如果删除的左右子树都非空
            //取右边最小值法:先寻找到以右子节点为根节点最左边，也就是比当前节点大中，最小值的节点
            //取到后先给删除，然后返回节点的信息，把要删除节点的信息替换成这个已删除节点
            int minVal = delRightTreeMin(targetNode.getRight());
            //取左边最大值法:先寻找到以左子节点为根节点最右边，也就是比当前节点小中，最大值的节点
            //取到后先给删除，然后返回节点的信息，把要删除节点的信息替换成这个已删除节点
//            int minVal = delLeftTreeMax(targetNode.getLeft());
            targetNode.setVal(minVal);
        }else {
            //如果要删除的节点只有一个子节点
            //到这步说明删除节点只有左子节点，如果父节点的左子节点和需要删除节点相等，则直接提上来
            if (targetNode.getLeft()!=null){
                //左右节点删除时候需要额外注意一下父节点是否为空，如果说有两个节点的话，是用不到父节点
                if (parent!=null){
                    //如果targentNode 是parent 的左子节点
                    if (parent.getLeft().getVal() == val){
                        parent.setLeft(targetNode.getLeft());
                    }else { // targetNode 是parent的右子节点
                        parent.setRight(targetNode.getLeft());
                    }
                }else {
                    root = targetNode.getLeft();
                }

            }else {
                if (parent != null){
                    //到这步说明删除节点只有右子节点，如果父节点的右子节点和需要删除节点相等，则直接提上来
                    if (parent.getLeft().getVal() == val){
                        parent.setLeft(targetNode.getRight());
                    }else {
                        parent.setRight(targetNode.getRight());
                    }
                }else {
                    root = targetNode.getRight();
                }

            }
        }
    }

    /**
     * 寻找要删除的节点
     *
     * @param val
     * @return
     */
    public AVLTreeNode search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    /**
     * 寻找要删除节点的父节点
     *
     * @param val
     * @return
     */
    public AVLTreeNode searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    /**
     * 返回以node为根节点最左边的节点数
     * @param node 传入的节点(当做二叉排序树的根节点)
     * @return 返回的是以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(AVLTreeNode node){
        AVLTreeNode temp = node;
        //循环查找最左节点，因为是二叉排序树，所以最左节点必定是最小，最大节点必定是最大
        while (temp.getLeft()!=null){
            temp = temp.getLeft();
        }
        //删除最小节点
        delNode(temp.getVal());
        return temp.getVal();
    }

    /**
     * 返回以node为根节点最右边的节点的数
     * @param node 传入的节点(当做二叉排序树的根节点)
     * @return 返回的是以node为根节点的二叉排序树的最小节点的值
     */
    public int delLeftTreeMax(AVLTreeNode node){
        AVLTreeNode temp = node;
        while (temp.getRight()!=null){
            temp = temp.getRight();
        }
        delNode(temp.getVal());
        return temp.getVal();
    }



    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder(root);
        }
    }


}
