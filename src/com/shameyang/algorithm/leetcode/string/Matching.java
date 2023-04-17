package com.shameyang.algorithm.leetcode.string;

/**
 * @author ShameYang
 * @date 2023/4/17 18:11
 * @description 字符串匹配，找到第一个匹配的下标
 * 思路：暴力匹配
 */
public class Matching {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
