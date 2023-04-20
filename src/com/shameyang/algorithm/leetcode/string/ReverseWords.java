package com.shameyang.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/4/17 17:34
 * @description 翻转字符串中的单词，其中可能有多个空格
 * 思路：
 * 1.双指针
 *      先去除两端空格，然后从尾到头把每个单词添加到 StringBuilder 中，不断改变尾指针的位置，与头指针的位置进行对比，判断是否还有单词
 * 2.API + 正则
 */
public class ReverseWords {
    //1.双指针
    public String reverseWords01(String s) {
        //去除首尾空格
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') {
            left++;
        }
        while (s.charAt(right) == ' ') {
            right--;
        }
        //从尾到头添加到 StringBuilder 中
        StringBuilder sb = new StringBuilder();
        int index = right;
        while (left <= right) {
            while (index >= left && s.charAt(index) != ' ') {
                index--;
            }
            for (int i = index + 1; i <= right; i++) {
                sb.append(s.charAt(i));
            }
            //还有单词未添加
            if (index > left) {
                sb.append(' ');
            }
            //寻找下一个单词
            while (index >= left && s.charAt(index) == ' ') {
                index--;
            }
            right = index;
        }
        return sb.toString();
    }

    //2.API + 正则
    public String reverseWords02(String s) {
        //去除两端空格
        s = s.trim();
        //正则匹配空格作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
