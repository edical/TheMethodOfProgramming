package com.chenlei.util;

/**
 * @author chenlei
 * @since  2016 - 09 - 07 21:04
 */
public class NumberUtils {
    public static <T extends  Comparable<T>>  T  min(T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    public static void swapInt(int []ints, int first, int second) {
        int temp = ints[first];
        ints[first] = ints[second];
        ints[second] = temp;
    }

    public static void swapInteger(Integer []array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T> void printArray(T [] array) {
        for(T t : array) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println(min(3,5));
    }
}
