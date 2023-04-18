package com.shameyang.algorithm.leetcode.string;

/**
 * @author ShameYang
 * @date 2023/4/17 17:45
 * @description 翻转字符串中的单词，单词间只有一个空格
 * 思路：编写方法，逐个翻转单词，遇到空格就调用方法。注意最后没有空格，需要再调用一次方法
 */
public class ReverseWords03 {

    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        int start = 0;

        for (int i = 0; i < len; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
            }
            //末尾没有空格，需要再翻转一次
            if (i == len - 1) {
                reverse(array, start, i);
            }
        }

        return String.valueOf(array);
    }

    //提供方法，翻转一个单词
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tem = array[left];
            array[left] = array[right];
            array[right] = tem;
            left++;
            right--;
        }
    }
}
