package com.chenlei.array;

import com.chenlei.util.NumberUtils;

/**
 * @author chenlei
 * @since 2017 - 03 - 06 21:15
 */
public class PerfectShuffle {

    //走环算法
    private static void doCircle(int a[], int k, int begin, int n) {
//        int index = 1, num = a[begin];
//        do {
//            int temp = num;
//            num = a[2*index%(2*n+1) - 1 + begin];
//            a[2*index%(2*n+1) - 1 + begin] = temp;
//            index = 2*index%(2*n+1) + begin;
//        } while(index != 1);
//        a[begin] = num;
        int index = begin, num = a[k + begin - 1];
        for(int nextIndex = 2*index%(2*n+1); nextIndex != begin; nextIndex = 2*index%(2*n+1)) {
            int temp = num;
            num = a[k + nextIndex - 1];
            a[k + nextIndex - 1] = temp;
            index = nextIndex;
        }
        a[k + begin - 1] = num;
    }

    //完美洗牌
    private static void perfectShuffle(int a[]) {
        int reserveLength = a.length;
        int rangeIndex = 0;
        while (reserveLength > 0) {
            int k  = 1;
            while((NumberUtils.ciFang(3, k) - 1) <= reserveLength) {
                k++;
            }
            k--;
            int n = (NumberUtils.ciFang(3, k) - 1) / 2;
            NumberUtils.reverseNoChanged(a, rangeIndex + n, rangeIndex + reserveLength / 2, rangeIndex + reserveLength / 2 + n - 1);
            for(int i = 0; i < k; i++) {
                doCircle(a, rangeIndex, NumberUtils.ciFang(3, i), n);
            }
            reserveLength -= 2*n;
            rangeIndex += 2*n;
        }
        closeExchange(a);
    }

    private static void closeExchange(int a[]) {
        for(int i = 0; i < a.length; i += 2) {
            NumberUtils.swapInt(a, i, i+1);
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        perfectShuffle(a);
//        doCircle(a, 0, 1, 4);
        NumberUtils.printInArray(a);
    }
}
