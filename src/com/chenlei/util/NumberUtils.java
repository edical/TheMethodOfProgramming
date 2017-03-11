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

    public static void swapIntByTwoArray(int a[], int b[], int index1, int index2) {
        if(index1 < a.length) {
            if(index2 < a.length) {
                swapInt(a, index1, index2);
            } else {
                swapIntByTwoArrayEach(a, b, index1, index2 - a.length);
            }
        } else {
            if(index2 < a.length) {
                swapIntByTwoArrayEach(a, b, index2, index1 - a.length);
            } else {
                swapInt(b, index1 - a.length, index2 - a.length);
            }
        }
    }

    private static void swapIntByTwoArrayEach(int a[], int b[], int aIndex, int bIndex) {
        int temp = a[aIndex];
        a[aIndex] = b[bIndex];
        b[bIndex] = temp;
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

    public static void printInArray(int []array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sum(int []array) {
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        return sum;
    }

    public static void printInMatrix(int [][]matrix) {
        for (int[] aMatrix : matrix) {
            printInArray(aMatrix);
        }
    }

    public static int maxOfThree(int num1, int num2, int num3) {
        if(num1 > num2) {
            return num1 > num3 ? num1 : num3;
        } else {
            return num2 > num3 ? num2 : num3;
        }
    }

    public static int minOfThree(int num1, int num2, int num3) {
        if(num1 < num2) {
            return num1 < num3 ? num1 : num3;
        } else {
            return num2 < num3 ? num2 : num3;
        }
    }

    public static boolean isOdd(int val) {
        return val % 2 != 0;
    }

    private static void reverseIntArray(int []arr, int first, int second) {
        while (first < second) {
            swapInt(arr, first++, second--);
        }
    }

    public static void reverseNoChanged(int a[], int before, int middle, int after) {
        NumberUtils.reverseIntArray(a, before, after);
        NumberUtils.reverseIntArray(a, before, after - (middle - before));
        NumberUtils.reverseIntArray(a, after - (middle - before) + 1, after);
    }

    public static int ciFang(int num, int k) {
        if(k == 0) {
            return 1;
        }
        while(k-- > 1) {
            num = num * num;
        }
        return num;
    }

    public static int getBitOne(int num) {
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & num) != 0) {
                return i + 1;
            }
        }
        return 0;
    }

    public static int abs(int a) {
        if(a >= 0) {
            return  a;
        } else {
            return -a;
        }
    }

    public static void main(String[] args) {
        System.out.println(min(3,5));
        System.out.println(getBitOne(8));
    }
}
