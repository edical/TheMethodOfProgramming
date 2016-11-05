package com.chenlei.string.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  9 并查集
 * @author chenlei
 * @create 2016 - 10 - 26 20:05
 */
public class MergeCompo {


    private static void printMerge(String[]... arrays) {
        Map<String, Integer> map = new HashMap<>();
        int temp = 1;
        for(String[] list : arrays) {
            for(String s : list) {
                if(!map.containsKey(s)) {
                    map.put(s,temp++);
                }
            }
        }
        for(String[] list : arrays) {
            Integer targetGroup = map.get(list[0]);
            for(int i = 1; i < list.length; i++) {
                Integer middleGroup = map.get(list[i]);
                if(middleGroup != targetGroup) {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == middleGroup) {
                            map.put(entry.getKey(),targetGroup);
                        }
                    }
                }
            }
        }
//        System.out.println(map);
        Map<Integer,List<String>> map1 = new HashMap<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            Integer i = entry.getValue();
            if(!map1.containsKey(i)) {
                map1.put(i,new ArrayList<>());
            }
            map1.get(i).add(entry.getKey());
        }
        System.out.println(map1);
    }

    public static void main(String[] args) {
        String[] list1 = {"aaa","bbb","ccc"};
        String[] list2 = {"bbb","ddd"};
        String[] list3 = {"eee","fff"};
        String[] list4 = {"ggg"};
        String[] list5 = {"ddd","hhh"};
        printMerge(list1,list2,list3,list4,list5);
    }

}
