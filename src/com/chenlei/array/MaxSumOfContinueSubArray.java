package com.chenlei.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  最大连续子数组的和
 * @author chenlei
 * @since 2016 - 11 - 21 20:01
 */
public class MaxSumOfContinueSubArray {

    public static Integer maxSum(int array[]) {
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for(int i = 1; i < array.length; i++) {
            if(list.get(i-1) <= 0) {
                list.add(array[i]);
            } else {
                list.add(list.get(i-1)+array[i]);
            }
        }
        Optional<Integer> op = list.stream().max(Integer::compareTo);
        return op.isPresent() ? op.get() : null;
    }

    public static void main(String[] args) {
        int array[] = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(maxSum(array));
    }
}
