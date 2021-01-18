package com.data_structure.tree_high;

/**
 * @auther liuyiming
 * @date 2021/1/17 15:23
 * @description 平衡二叉树节点
 */
public class AVLTreeNode {

    private int val;

    private AVLTreeNode left;
    private AVLTreeNode right;

    public AVLTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }


    /**
     * 返回左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 返回右子数高度
     *
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前节点的高度
     *
     * @return 从左右节点中选择最大的进行加一
     */
    public int height() {
        int leftNum = 0;
        int rightNum = 0;

        if (left == null) {
            leftNum = 0;
        } else {
            leftNum = left.height();
        }

        if (right == null) {
            rightNum = 0;
        } else {
            rightNum = right.height();
        }

        return Math.max(leftNum, rightNum) + 1;
//        return Math.max(left == null?0:left.height(),right == null?0:right.height())+1;
    }

    /**
     * 左旋
     */
    private void leftRotate() {
        //1、创建新的节点，以当前根节点的值
        AVLTreeNode newNode = new AVLTreeNode(val);
        //2、把新节点的左子树设置成当前节点的左子树
        newNode.setLeft(left);
        //3、把新节点的右子数设置为当前节点的右子数的左子树
        newNode.setRight(right.getLeft());
        //4、把当前节点的值换为右子树节点的值
        this.val = right.getVal();
        //5、把当前节点的右子数设置成右子数的右子数
        this.setRight(right.getRight());
        //6、把当前节点的左子树设置成新节点
        this.setLeft(newNode);
    }

    /**
     * 右旋
     */
    private void rightRotate() {

        //1、创建新的节点，以当前根节点的值
        AVLTreeNode newNode = new AVLTreeNode(this.getVal());
        //2、把新节点的右节点设置成当前节点的右节点
        newNode.setRight(right);
        //3、把新节点的左节点设置成当前节点左节点的右节点
        newNode.setLeft(left.getRight());
        //4、把当前节点的值替换成左节点的值
        this.setVal(left.getVal());
        //5、把当前节点的左节点设置成当前节点的左节点的左节点
        this.setLeft(left.getLeft());
        //6、把当前节点的右节点设置成新节点
        this.setRight(newNode);
    }

    /**
     * 递归添加节点
     *
     * @param node
     */
    public void add(AVLTreeNode node) {

        if (node == null) {
            return;
        }

        //判断传入的节点值，和当前子树的根节点的值关系
        if (node.getVal() < this.getVal()) {
            //如果当前节点左子节点为空
            if (left == null) {
                this.setLeft(node);
            } else {
                left.add(node);
            }

        } else {
            if (right == null) {
                this.setRight(node);
            } else {
                right.add(node);
            }
        }

        //当添加完一个节点后,如果(右子数的高度-左子树的高度) >1 ,那么就需要左旋转
        //如果他的左子树的右子数高度大于他的左子树的高度
        //先对当前这个节点的左节点进行左旋转
        //再对当前节点进行右旋转
        if (rightHeight() - leftHeight() > 1) {

            if (right != null && right.rightHeight() < right.leftHeight()) {
                //先对右子数进行旋转
                this.right.leftRotate();
            }
            leftRotate();
            return;
        }
        // 当添加玩一个节点后，如果(左子树的高度-右子数的高度)>1,那么就需要右旋转
        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.getLeft().height() < left.getRight().height()) {
                left.rightRotate();
            }
            rightRotate();
            return;
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param val 要删除节点的值
     * @return 如果找到返回该节点，否则为null
     */
    public AVLTreeNode search(int val) {
        if (val == this.getVal()) {//如果相等，则说明找到，直接返回
            return this;
        } else if (val < this.getVal()) { //如果小于，说明需要左递归
            if (left != null) {
                return left.search(val);
            }
        } else {
            if (right != null) { //如果大于，说明需要右递归
                return right.search(val);
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
    public AVLTreeNode searchParent(int val) {
        //如果当前节点就是要删除节点的父节点，就返回
        if ((left != null && left.getVal() == val) || (right != null && right.getVal() == val)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (val < this.getVal() && this.left != null) {
                //左递归
                return left.searchParent(val);
            } else if (val >= this.getVal() && this.right != null) {
                //右递归
                return right.searchParent(val);
            } else {
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
    public void infixOrder(AVLTreeNode node) {

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
