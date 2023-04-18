package com.shameyang.algorithm.leetcode.string;

/**
 * @author ShameYang
 * @date 2023/4/17 17:31
 * @description 反转字符串
 * 思路：双指针，头尾交换
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        for (; start < end; start++, end--) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
        }
    }
}
