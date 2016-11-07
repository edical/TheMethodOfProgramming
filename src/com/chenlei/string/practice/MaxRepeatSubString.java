package com.chenlei.string.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  13 最长重复出现子串
 * @author chenlei
 * @since 2016 - 11 - 07 21:54
 */
public class MaxRepeatSubString {

    private static void resolveBySuffix(String str) {
        StringBuilder buffer = new StringBuilder(str);
        List<String> suffixs = new ArrayList<>();
        for (int i = 0; i < buffer.length(); i++) {
            suffixs.add(buffer.substring(i, buffer.length()));
        }
        Collections.sort(suffixs, String::compareTo);
        int maxRepeatLength = -1;
        int index = 0;
        for (int i = 0; i < suffixs.size() - 1; i++) {
            int repeatLength = repeatLength(suffixs.get(i), suffixs.get(i+1));
            if(repeatLength > maxRepeatLength) {
                index = i;
                maxRepeatLength = repeatLength;
            }
        }
        System.out.println(suffixs.get(index).substring(0, maxRepeatLength));
    }

    private static void basic(String str) {
        int maxRepeatLength = -1;
        int beforeIndex = 0, afterIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int repeatLength = repeatLength(str, i, j);
                if (repeatLength > maxRepeatLength) {
                    maxRepeatLength = repeatLength;
                    beforeIndex = i;
                    afterIndex = j;
                }
            }
        }
        System.out.println(str + ", maxRepeatLength is " + maxRepeatLength + ", beforeIndex is " + beforeIndex + ", afterIndex is " + afterIndex);
    }

    private static int repeatLength(String str, int before, int after) {
        int end = after;
        while (end < str.length() && str.charAt(before) == str.charAt(end)) {
            before++;
            end++;
        }
        return end - after;
    }

    private static int repeatLength(String str1, String str2) {
        int length = 0;
        while (length < str1.length() && length < str2.length() && str1.charAt(length) == str2.charAt(length)) {
            length++;
        }
        return length;
    }

    private static void resolveByKmp(String str) {
        StringBuilder buffer = new StringBuilder(str);
        List<String> suffixs = new ArrayList<>();
        for (int i = 0; i < buffer.length(); i++) {
            suffixs.add(buffer.substring(i, buffer.length()));
        }
        int maxRepeatLength = -1;
        int index = 0;
        for(int i = 0; i < suffixs.size(); i++) {
            int maxNextValue = maxNext(suffixs.get(i));
            if(maxNextValue > maxRepeatLength) {
                maxRepeatLength = maxNextValue;
                index = i;
            }
        }
        System.out.println(suffixs.get(index).substring(0,maxRepeatLength));
    }

    private static int maxNext(String str) {
        List<Integer> nexts = new ArrayList<>();
        nexts.add(0);
        int k = 0;
        int index = 1;
        int maxNext = 0;
        boolean interrupt = false;

        while(index < str.length()) {
            if(str.charAt(k) == str.charAt(index)) {
                if( !interrupt ) {
                    nexts.add(nexts.get(nexts.size() - 1) + 1);
                } else {
                    nexts.add(k + 1);
                    interrupt = false;
                }
                k++;
                index++;
                if(nexts.get(nexts.size() - 1) > maxNext) {
                    maxNext = nexts.get(nexts.size() - 1);
                }
            } else if(k == 0) {
                index++;
                nexts.add(0);
            }else {
                k = nexts.get(k);
                interrupt = true;
            }
        }
        return maxNext;
    }

    public static void main(String[] args) {
        basic("canffcancd");
        resolveBySuffix("canffcancd");
        resolveByKmp("canffcancd");
    }
}
