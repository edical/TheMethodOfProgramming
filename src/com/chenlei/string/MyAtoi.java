package com.chenlei.string;

/**
 * 1.4
 * @author chenlei
 * @create 2016 - 09 - 05 21:14
 */
public class MyAtoi {

    private static int myAtoi(String number) {  //假设number是纯的数字
        int value = 0;
        for(char single : number.toCharArray()) {
            if(Integer.MAX_VALUE / 10 < value) {
                value = Integer.MAX_VALUE;
                break;
            }
            value = value * 10 + (single - '0');
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("13542"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
