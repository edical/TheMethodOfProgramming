package com.chenlei.dp.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 子序列的个数
 * @author chenlei
 * @since 2017 - 06 - 09 11:24
 */
public class SubSeqCount {

    //dp[i] = 2*dp[i-1] - sum[a[i]]
    //dp[i] = dp[i-1]的子序列加a[i]或者不加a[i], 其中dp[i-1]子序列中不以a[i]结尾的子序列中会有一部分与a[i]值结尾的子序列数量相等，当新添a[i]时，这部分会重合
    private static int getSubSeqCount(int a[]) {
        Map<Integer, Integer> sum = new HashMap<>();
        int nowCount = 1;
        sum.put(a[0], 1);
        for(int i = 1; i < a.length; i++) {
            sum.putIfAbsent(a[i], 0);
            int temp = nowCount;
            nowCount = 2 * nowCount - sum.get(a[i]);
            sum.put(a[i], temp);
        }
        return nowCount;
    }

    public static void main(String[] args) {
        int a[] = {4, 13, 14, 1, 2, 3};
        System.out.println(getSubSeqCount(a));
    }
}
