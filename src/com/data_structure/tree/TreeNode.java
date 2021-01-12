package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * <p>
 * 前序遍历：先输出父节点，再遍历左子树和右子树
 * 中序遍历：先遍历左子树，在输出父节点，再遍历右子树
 * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 */
public class TreeNode {

    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "[id:" + id + ",name:" + name + "]";
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this.toString());

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.toString());

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this.toString());
    }


    /**
     * 前序查找
     *
     * @param val
     * @return
     */
    public TreeNode preSearch(int val) {

        if (val == this.getId()) {
            return this;
        }

        if (this.left != null) {
            if (this.left.preSearch(val) != null) {
                return this.left.preSearch(val);
            }
        }

        if (this.right != null) {
            if (this.right.preSearch(val) != null) {
                return this.right.preSearch(val);
            }
        }

        return null;
    }

    /**
     * 中序查找
     *
     * @param no
     * @return
     */
    public TreeNode infixSearch(int no) {
        if (this.left != null) {
            if (this.left.infixSearch(no) != null) {
                return this.left.infixSearch(no);
            }
        }

        if (this.getId() == no) {
            return this;
        }

        if (this.right != null) {
            if (this.right.infixSearch(no) != null) {
                return this.right.infixSearch(no);
            }
        }

        return null;
    }

    /**
     * 后续查找
     * @param no
     * @return
     */
    public TreeNode postSearch(int no) {

        if (this.left != null) {
            if (this.left.postSearch(no) != null) {
                return this.left.postSearch(no);
            }
        }

        if (this.right != null) {
            if (this.right.postSearch(no) != null) {
                return this.right.postSearch(no);
            }
        }

        if (this.getId() == no) {
            return this;
        }

        return null;
    }


}
