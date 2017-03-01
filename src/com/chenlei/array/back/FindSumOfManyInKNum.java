package com.chenlei.array.back;

import com.chenlei.sort.QuickSort;
import com.chenlei.util.NumberUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2.3.3 寻找和为S的K个数的组合
 * @author chenlei
 * @since 2017 - 03 - 01 20:46
 */
public class FindSumOfManyInKNum {

    private static void findTheSumOfManyByCut(int a[], int s, int k, int index, List<Integer> list, int leftTotal, Set<String> set) {
        if(s == 0 && list.size() == k) {
            set.add(list.toString());
            return;
        }
        if(index >= a.length || list.size() > k) {
            return;
        }
        if(s - a[index] >= 0) {
            list.add(a[index]);
            findTheSumOfManyByCut(a, s - a[index], k, index + 1, list, leftTotal - a[index], set);
            list.remove(list.size() - 1);
        }

        if(leftTotal - a[index] >= s) {
            findTheSumOfManyByCut(a, s, k, index + 1, list, leftTotal - a[index], set);
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 1, 3, 0, 1};
        QuickSort.quickSort(a, 0, a.length - 1);
        NumberUtils.printInArray(a);
        Set<String> set = new HashSet<>();
        findTheSumOfManyByCut(a, 3, 2, 0, new ArrayList<>(), NumberUtils.sum(a), set);
        //去重叠用hash吧
        System.out.println(set);
    }
}
