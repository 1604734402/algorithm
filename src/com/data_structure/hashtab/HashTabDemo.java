package com.data_structure.hashtab;



/**
 * @auther liuyiming
 * @date 2021/1/12
 */
public class HashTabDemo {

    public static void main(String[] args) {

        HashTap hashTap = new HashTap(7);

        hashTap.add(new Emp(8,"222"));
        hashTap.add(new Emp(15,"333"));
        hashTap.add(new Emp(22,"444"));
        hashTap.add(new Emp(1,"111"));

        hashTap.list();

//        System.out.println(hashTap.findEmpById(8).getName());
//        System.out.println(hashTap.delEmpById(1));

//        hashTap.list();
    }
}
