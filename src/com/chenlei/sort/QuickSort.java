package com.chenlei.sort;

import com.chenlei.util.NumberUtils;

/**
 * @author chenlei
 * @since 2016 - 11 - 17 19:55
 */
public class QuickSort {

    public static void quickSort(int []array, int start, int end) {
        if(start < end) {
            int q = partition(array, start, end);
            quickSort(array, start, q - 1);
            quickSort(array, q + 1, end);
        }
    }

    public static int partition(int []array, int start, int end) {
        int first = start + 1, second = end;
        while(true) {
            while(first <= end && array[start] >= array[first]) first++;
            while (first <= end && array[start] < array[second]) second--;
            if(first > second) {
                break;
            }
            NumberUtils.swapInt(array, first, second);
            first++;
            second--;
        }
        NumberUtils.swapInt(array, start, second);
        return second;
    }

    public static int partitionByTwoArray(int a[], int b[], int start, int end) {
        int first = start + 1, second = end;
        while (true) {
            while(first <= end && getRightValue(a, b, start) >= getRightValue(a, b, first)) first++;
            while(first <= end && getRightValue(a, b, start) < getRightValue(a, b, second)) second--;
            if(first > second) {
                break;
            }
            NumberUtils.swapIntByTwoArray(a, b, first, second);
            first++;
            second--;
        }
        NumberUtils.swapIntByTwoArray(a, b, start, second);
        return second;
    }

    private static int getRightValue(int a[], int b[], int index) {
        if(index < a.length) {
            return a[index];
        } else {
            return b[index - a.length];
        }
    }


    public static void main(String[] args) {
        int array[] = {3, 2, 5, 4, 7};
        quickSort(array, 0, array.length - 1);
        NumberUtils.printInArray(array);
    }
}
