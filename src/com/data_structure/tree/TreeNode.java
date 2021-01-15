package com.data_structure.tree;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * 树节点
 * <p>
 * 前序遍历：先输出父节点，再遍历左子树和右子树
 * 中序遍历：先遍历左子树，在输出父节点，再遍历右子树
 * 后序遍历：先遍历左子树，再遍历右子树，最后输出父节点
 */
public class TreeNode implements Comparable<TreeNode>{

    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;
    private int val; //哈夫曼树权值
    private boolean flag;//判断通过那个构造方法实现，从而toString()返回不同

    //如果leftType == 0 表示指向的是左子树，如果是1则指向前驱节点
    private int leftType;
    //如果rightType == 0 表示指向的是右子数，如果1表示指向后继结点
    private int rightType;

    public TreeNode(int val) {
        this.val = val;
        this.flag = true;
    }

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
        this.flag = false;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return this.flag?("[val:"+this.val+"]"):("[id:" + this.id + ",name:" + this.name + "]");
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
     *
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

    /**
     * 删除
     * 先左再右
     * @return
     */
    public boolean preDelChildRoot(int no) {

        if (this.left != null) {
            if (this.left.getId() == no) {
                this.left = null;
                return true;
            } else {
                if (this.left.preDelChildRoot(no)) {
                    return true;
                }
            }

        }

        if (this.right!=null){
            if (this.right.getId() == no){
                this.right = null;
                return true;
            }else {
                if (this.right.preDelChildRoot(no)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 删除
     * 先左再右
     * @return
     */
    public boolean postDelChildRoot(int no){

        if (this.right!=null){
            if (this.right.getId() == no){
                this.right = null;
                return true;
            }else {
                if (this.right.postDelChildRoot(no)){
                    return true;
                }
            }
        }

        if (this.left!=null){
            if (this.left.getId() == no){
                this.left =null;
                return true;
            }else {
                if (this.left.postDelChildRoot(no)){
                    return true;
                }
            }
        }

        return false;

    }


    @Override
    public int compareTo(TreeNode o) {
        //this.val - o.val 从小到大排序
        return this.val - o.val;
    }
}
