package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther liuyiming
 * @date 2021/5/20 08:21
 * @description
 */
public class LeetCode_692 {


    public List<String> topKFrequent(String[] words, int k) {
        List<String> arr = new ArrayList<>();
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        for(String word:words){
            map.put(word,map.get(word) == null?0:map.get(word) + 1);
        }

        Integer ad = map.get("ad");

        for(String key :map.keySet()){
            if(map.get(key) == k){
                arr.add(key);
            }
        }
        return arr;

    }
}
