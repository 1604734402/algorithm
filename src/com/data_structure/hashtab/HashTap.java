package com.data_structure.hashtab;

/**
 * @auther liuyiming
 * @date 2021/1/12
 */
public class HashTap {

    private EmpLinkedList[] empLinkedListsArray;

    private int size;

    /**
     * 构造方法
     * 根据传入的size,来创建多少个链表
     * 需要初始化每一个数组中的链表！
     * @param size
     */
    public HashTap(int size) {
        //初始化empLinkedListArray
        this.empLinkedListsArray = new EmpLinkedList[size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加
     * 先hash数组，然后再放入
     * @param emp
     */
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFun(emp.getId());
        //将emp添加到对应的链表中
        empLinkedListsArray[empLinkedListNo].addOrder(emp);
    }

    /**
     * 查找
     * 遍历所有的hashtab
     */
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i].list(i);
        }
    }

    /**
     * 查找
     * 根据id查询
     * @param id
     * @return
     */
    public Emp findEmpById(int id){
        return empLinkedListsArray[hashFun(id)].findEmpById(id);
    }

    public boolean delEmpById(int id){
        return empLinkedListsArray[hashFun(id)].delEmpById(id);
    }


    /**
     * 根据Id返回hash的数组索引
     * @param id
     * @return
     */
    private int hashFun(int id) {
        return id % size;
    }


}
