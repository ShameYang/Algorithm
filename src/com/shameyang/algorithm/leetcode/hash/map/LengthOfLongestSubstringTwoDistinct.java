package com.shameyang.algorithm.leetcode.hash.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/14 17:31
 * @description 最长字串的长度
 */
public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 1;
        Map<Character, Integer> hashMap = new HashMap<>();
        while (right < chars.length) {
            if (hashMap.size() < 3) {
                hashMap.put(chars[right], right++);
            }
            if (hashMap.size() == 3) {
                int del_index = Collections.min(hashMap.values());
                hashMap.remove(chars[del_index]);
                left = del_index + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
