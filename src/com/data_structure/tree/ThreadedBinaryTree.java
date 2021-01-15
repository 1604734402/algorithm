package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * 线索化二叉树
 *
 * 1、n个节点的二叉链表中含有N+1 公司 2n-(n-1) = n+1 个空指针域，
 * 利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针(这种附加的指针成为“线索”)
 * 2、这种加上了线索的二叉链表被成为线索链表，相应的二叉树成为线索二叉树(Threaded BinaryTree).
 * 根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
 * 3、一个节点的前一个节点，成为前驱节点
 * 4、一个节点的后一个节点，成为后继节点
 * <p>
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
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 前序查找
     *
     * @param id
     * @return
     */
    public TreeNode preSearch(int id) {
        return root.preSearch(id);
    }

    /**
     * 中序查找
     *
     * @param no
     * @return
     */
    public TreeNode infixSearch(int no) {
        return root.infixSearch(no);
    }

    /**
     * 后续查找
     *
     * @param no
     * @return
     */
    public TreeNode postSearch(int no) {
        return root.postSearch(no);
    }

    /**
     * 删除
     * 先左再右
     *
     * @param no
     * @return
     */
    public boolean preDelRoot(int no) {
        if (root == null) {
            return false;
        }
        if (root.getId() == no) {
            root = null;
            return true;
        }
        return root.preDelChildRoot(no);
    }

    /**
     * 先右再左
     *
     * @param no
     * @return
     */
    public boolean postDelRoot(int no) {
        if (root == null) {
            return false;
        }
        if (root.getId() == no) {
            root = null;
            return true;
        }
        return root.postDelChildRoot(no);
    }

    public void infixThreadedNodes() {
        threadedNodes(root);
    }

    public void preThreadedNodes() {
        preThreadedNodes(root);
    }

    public void postThreadedNodes() {
        postThreadedNodes(root);
    }

    /**
     * 中序线索化二叉树
     *
     * @param node
     */
    public void threadedNodes(TreeNode node) {

        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());

        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱结点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每处理一个节点，让当前节点是下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());


    }


    /**
     * 前序线索化二叉树
     */
    public void preThreadedNodes(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeftType(1);
            node.setLeft(pre);
        }

        if (pre != null && pre.getRight() == null && pre.getLeft() != node) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        if (node.getLeftType() == 0) {
            preThreadedNodes(node.getLeft());
        }

        preThreadedNodes(node.getRight());

    }


    /**
     * 后序线索化二叉树
     */
    public void postThreadedNodes(TreeNode node) {

        if (node == null) {
            return;
        }
        postThreadedNodes(node.getLeft());
        postThreadedNodes(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;


    }


    /**
     * 中序遍历线索化二叉树
     */
    public void threadedList() {
        TreeNode treeNode = root;

        while (treeNode != null) {
            //循环找到leftType == 1 的节点
            //当leftType == 1时，说明该结点是按照线索化处理后面节点
            while (treeNode.getLeftType() == 0) {
                treeNode = treeNode.getLeft();
            }
            //输出当前节点
            System.out.println(treeNode);
            //如果当前结点的右指针指向的是后继节点，就一直输出
            while (treeNode.getRightType() == 1) {
                treeNode = treeNode.getRight();
                System.out.println(treeNode);
            }
            //替换遍历的节点
            treeNode = treeNode.getRight();

        }


    }

    /**
     * 前序遍历线索化二叉树
     */
    public void preThreadedList() {
        TreeNode treeNode = root;


        while (treeNode != null) {
            //输出当前节点
            System.out.println(treeNode);
            //循环找到leftType == 1 的节点
            //当leftType == 1时，说明该结点是按照线索化处理后面节点
            while (treeNode.getLeftType() == 0) {
                treeNode = treeNode.getLeft();
                System.out.println(treeNode);
            }

            if (treeNode.getRightType() == 1) {
                treeNode = treeNode.getRight();
            } else if (treeNode.getRight() == null) {
                return;
            }

        }


    }

    /**
     * 后续递归遍历线索化二叉树
     */
    public void postThreadedList() {
        postThreadedList(root);
    }

    /**
     * 后序遍历线索化二叉树
     */
    public void postThreadedList(TreeNode node) {

        if (node.getLeftType() == 0) {
            postThreadedList(node.getLeft());
        }
        if (node.getRightType() == 0) {
            postThreadedList(node.getRight());
        }
        System.out.println(node);

    }


}
