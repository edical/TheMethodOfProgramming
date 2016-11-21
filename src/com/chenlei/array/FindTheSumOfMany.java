package com.chenlei.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  寻找和为定值的多个数
 * @author chenlei
 * @since 2016 - 11 - 20 9:27
 */
public class FindTheSumOfMany {

    public static void findTheSumOfMany(int n, int target, int i, List<Integer> list) {
        if(i > n) {
            int sum = 0;
            for(Integer j : list)
                sum += j;
            if(sum == target) {
                System.out.println(list);
            }
            return;
        }
        list.add(i);
        findTheSumOfMany(n ,target, i + 1, list);
        list.remove(list.size() - 1);
        findTheSumOfMany(n ,target, i + 1, list);
    }

    public static void findTheSumOfManyByCut(int target, int i, int nowValue, List<Integer> list) {
        if(nowValue == target) {
            System.out.println(list);
            return;
        }
        if(i < 1) {
            return;
        }
        if(nowValue + i <= target) {
            list.add(i);
            findTheSumOfManyByCut(target, i - 1, nowValue + i, list);
            list.remove(list.size() - 1);
        }
        findTheSumOfManyByCut(target, i - 1, nowValue, list);

    }


    public static void main(String[] args) {
        findTheSumOfMany(10, 15, 1, new ArrayList<>());
        findTheSumOfManyByCut(15, 10, 0, new ArrayList<>());
    }
}
