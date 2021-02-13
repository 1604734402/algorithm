package com.algorithm.topten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 */
public class Greedy {

    public static void main(String[] args) {

        //初始化电台
        //创建广播电台，放入到Map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        //将各个电台放入到broadcasts中
        HashSet<String> k1 = new HashSet<>();
        HashSet<String> k2 = new HashSet<>();
        HashSet<String> k3 = new HashSet<>();
        HashSet<String> k4 = new HashSet<>();
        HashSet<String> k5 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        k4.add("上海");
        k4.add("天津");
        k5.add("杭州");
        k5.add("大连");
        broadcasts.put("k1",k1);
        broadcasts.put("k2",k2);
        broadcasts.put("k3",k3);
        broadcasts.put("k4",k4);
        broadcasts.put("k5",k5);
        for (String key :broadcasts.keySet()) {
            allAreas.addAll(broadcasts.get(key));
        }

        //创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<String>();

        //定义一个临时的集合,在遍历的过程中,存放遍历过程中的电台覆盖的地区和还没有覆盖的地区
        HashSet<String> tempSet = new HashSet<String>();

        //定义给maxKey,保存在一次遍历过程中,能够覆盖最大未覆盖的地区对应的电台Key
        //如果maxkey 不为null,则会加入到 selects

        String maxKey = null;

        while (allAreas.size() !=0 ){// 如果allAreas 不为0,则表示还没有覆盖到所有的地区
            int maxTemp = 0;
            maxKey = null;
            //遍历 broadcasts,取出对应key
            for (String key: broadcasts.keySet()) {
                tempSet.clear();
                //当前中国key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet 和 allAreas 集合的交集,交集会付给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量,比maxKey指向的集合地区还多
                //就需要重置maxKey
                //tempSet.size() > broadcasts.get(maxKey).size() 体现出谈心算法的特点 ,每次都选择最优的
                //这里有问题，也就是只要选择了，就会进行重置，应该选择最优的
                // maxTemp 则是进行了循环加入，设第一个是最大的，往后依次寻找，寻找到最大的进行添加，而不是刚遇到就添加
                if (tempSet.size() >0 && (maxKey == null || tempSet.size() > maxTemp)){
                    maxKey = key;
                    maxTemp = tempSet.size();
                }
            }

            if (maxKey != null){
                selects.add(maxKey);
                //将maxKey指向的广播电太覆盖的地区,从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }

        }
        System.out.println("最优解:"+selects);
    }

}
