package com.chenlei.util;

import static com.chenlei.util.NumberUtils.swapInt;

/**
 * @author chenlei
 * @create 2016 - 09 - 11 20:14
 */
public class SortUtils {

    public static void quickSort(int a[], int low ,int high) {
        if( low < high ) {
            int location = partition(a, low, high);
            quickSort(a, low, location - 1);
            quickSort(a, location + 1, high);
        }
    }

    public static int partition(int a[], int low, int high) {
        int left = low + 1, right = high;
        while(true) {
            while(a[low] > a[left] && left <= right) left++;
            while(a[low] <= a[right] && left <= right) right--;
            if(left > right) {
                break;
            } else {
                swapInt(a, left, right);
            }
        }
        swapInt(a, low, left - 1);
        return left - 1;
    }
}
