package com.shameyang.algorithm.leetcode.hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/15 15:44
 * @description 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char[] ca = s.toCharArray();
        for (int left = 0, right = 0; right < ca.length; right++) {
            if (map.containsKey(ca[right])) {
                left = Math.max(left, map.get(ca[right]) + 1);
            }
            map.put(ca[right], right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
