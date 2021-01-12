package com.data_structure.hashtab;

/**
 * @auther liuyiming
 * @date 2021/1/12
 * 员工链表
 */
public class EmpLinkedList {

    //头指针，执行第一个Emp,因此我们这个链表的head是指向第一个Emp
    private Emp head;//默认为Null

    /**
     * 添加雇员时，id是自增长，即id的分配总是从小到大
     * 将该雇员，自己加入到本链表的最后
     *
     * @param emp
     */
    public void add(Emp emp) {

        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是最后一个，需要遍历到最后进行插入
        Emp temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(emp);

    }

    public void addOrder(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }

        Emp temp = head;
        if (temp.getId() > emp.getId()) {
            head = emp;
            head.setNext(temp);
            return;
        }

        while (temp != null) {

            if (emp.getId() > temp.getId()) {
                if (temp.getNext() != null) {
                    if (temp.getNext().getId() > emp.getId()) {
                        Emp cur = temp.getNext();
                        temp.setNext(emp);
                        temp.getNext().setNext(cur);
                    }
                } else {
                    temp.setNext(emp);
                }
            }


            if (temp.getNext() != null) {
                temp = temp.getNext();
            } else {
                return;
            }
        }

    }

    /**
     * 遍历链表的雇员信息
     */
    public void list(int i) {
        if (head == null) {//说明链表为空
            System.out.println("链表" + i + "为空");
            return;
        }
        Emp curEmp = head;//辅助指针
        System.out.printf("链表%d信息为:", i);
        while (curEmp != null) {
            System.out.printf("[id:%d,name:%s]", curEmp.getId(), curEmp.getName());
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }


    /**
     * 查找
     * 根据id查找
     * 如果没有查找到，则返回空
     *
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        if (id < 0 || head == null) {
            return null;
        }
        Emp temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            }
            if (temp.getNext() != null) {
                temp = temp.getNext();
            } else {
                return null;
            }
        }
        return null;
    }

    public boolean delEmpById(int id) {
        if (id < 0 || head == null) {
            return false;
        }

        Emp temp = head;

        if (head.getId() == id) {
            if (head.getNext() != null) {
                head = head.getNext();
            } else {
                head = null;
            }
            return true;
        }

        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {
                if (temp.getNext().getNext() != null) {
                    temp.setNext(temp.getNext().getNext());
                } else {
                    temp.setNext(null);
                }
                return true;
            }
            temp = temp.getNext();
        }


        return false;
    }

}
