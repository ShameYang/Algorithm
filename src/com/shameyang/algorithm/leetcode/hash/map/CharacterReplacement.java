package com.shameyang.algorithm.leetcode.hash.map;

/**
 * @author ShameYang
 * @date 2023/5/13 15:14
 * @description 替换后的最长重复字符
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26]; //记录每个字符出现的次数
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        for (; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            //更新历史最大值
            max = Math.max(max, map[index]);
            //当前窗口长度 > 历史窗口长度 + k，向右滑动
            if (right - left + 1 > max + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
