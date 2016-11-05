package com.chenlei.string;

import com.chenlei.util.StringUtils;

import java.util.Arrays;

/**
 * 1.3
 * @author chenlei
 * @create 2016 - 09 - 04 19:09
 */
public class StringPerm {

    public static void permutationByRecursion(char a[], int i) {
        if (i == a.length - 1) {
            System.out.print(String.valueOf(a) + " ");
            return;
        }
        for (int index = i; index < a.length; index++) {
            StringUtils.swapChar(a, i, index);
            permutationByRecursion(a, i+1);
            StringUtils.swapChar(a, i, index);
        }
    }

    public static boolean nextPermutation(char a[]) {
        int index = -1;
        for(int i = a.length - 2; i >= 0; i--) {
            if(a[i] < a[i +1]) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            return false;  //当前整个序列为最大值
        }
        int afterIndex = a.length - 1;
        while(a[index] >= a[afterIndex]) afterIndex--;
        StringUtils.swapChar(a, index, afterIndex);
        StringUtils.reverseCharArray(a, index + 1, a.length -1);
        return  true;
    }

    public static void permutation(char a[]) {
        Arrays.sort(a);
        do {
            System.out.print(String.valueOf(a) + " ");
        } while (nextPermutation(a));
    }

    public static void main(String[] args) {
        char[] perm = {'a', 'b', 'c'};
        permutationByRecursion(perm, 0);
        System.out.println();
        permutation(perm);
    }
}
