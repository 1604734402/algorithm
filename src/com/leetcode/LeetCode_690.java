package com.leetcode;

import com.data_structure.hashtab.Emp;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther liuyiming
 * @date 2021/5/1 02:27
 * @description
 */
public class LeetCode_690 {

    public static void main(String[] args) {
        Employee a4 = new Employee(4,1,new ArrayList<Integer>());
        Employee a3 = new Employee(3, 4, new ArrayList<Integer>());
        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(4);
//        arr1.add(3);
        Employee a2 = new Employee(2,3,arr1);
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(2);
        arr2.add(3);
        Employee a1 = new Employee(1, 5, arr2);

        List<Employee> arr = new ArrayList<>();
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);

        LeetCode_690 leetCode_690 = new LeetCode_690();
        int importance = leetCode_690.getImportance(arr, 1);
        System.out.println(importance);


    }

    public int getImportance(List<Employee> employees, int id) {
        for(Employee emp : employees){
            if(emp.id == id){
                if(emp.subordinates.size()<1) return emp.importance;

                return  getOutImportance(employees,emp);
            }
        }
        return 0;
    }

    public int getOutImportance(List<Employee> employees,Employee emp){
        if(emp.subordinates.size()==0) return emp.importance;
        int temp = emp.importance;
        for(int id:emp.subordinates){
            for(Employee emp1 : employees){
                if(id == emp1.id){
                    temp += getOutImportance(employees,emp1);
                }
            }
        }
        return temp;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};
