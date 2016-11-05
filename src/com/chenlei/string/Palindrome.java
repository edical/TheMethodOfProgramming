package com.chenlei.string;

import com.chenlei.util.StringUtils;

/**
 * 1.5
 * @author chenlei
 * @create 2016 - 09 - 06 21:30
 */
public class Palindrome {

    public static boolean isPalindrome(String str) {
        if(StringUtils.isBlank(str)) {
            return false;
        }
        int before = 0, after = str.length() - 1;
        while(before < after) {
            if(str.charAt(before) != str.charAt(after)) {
                return false;
            }
            before++;
            after--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("issi"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abcea"));
    }
}
