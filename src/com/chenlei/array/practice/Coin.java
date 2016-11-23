package com.chenlei.array.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 投硬币问题
 * 这种实现方式不存在重复计算，因此不需要递推
 * @author chenlei
 * @since 2016 - 11 - 23 11:42
 */
public class Coin {

    //基本的剪枝搜索
    public static int f(int val, List<Integer> coins, int index) {
        if (val == 0) {
            return 1;
        }
        if (index == coins.size()) {
            return 0;
        }
        int count = 0;
        while (val >= 0) {
            count += f(val, coins, index + 1);
            val -= coins.get(index);
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        coins.add(10);
        System.out.println(f(100, coins, 0));
    }
}
