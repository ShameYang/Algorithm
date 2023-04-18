package com.shameyang.algorithm.leetcode.string;

/**
 * @author ShameYang
 * @date 2023/4/17 17:54
 * @description 最长回文子串
 * 思路：双指针中心扩展，判断左或右是否与中间字符相同，都与中间不同则判断左和右是否相同
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }

        int strLen = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0; //最大长度
        int maxStart = 0; //最大长度起始
        char[] charArray = s.toCharArray();

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            int len = 1;
            //比较左侧
            while (left >= 0 && charArray[left] == charArray[i]) {
                left--;
                len++;
            }
            //比较右侧
            while (right < strLen && charArray[right] == charArray[i]) {
                right++;
                len++;
            }
            //左右比较
            while (left >= 0 && right < strLen && charArray[left] == charArray[right]) {
                left--;
                right++;
                len += 2;
            }
            //更新最大长度及起始位置
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
