package com.shameyang.algorithm.leetcode.hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/21 18:22
 * @description 有效的字母异位词：判断两字符串是否为字母异位词
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        for (char c1 : chars1) {
            int count = map.getOrDefault(c1, 0) + 1;
            map.put(c1, count);
        }
        char[] chars2 = t.toCharArray();
        for (char c2 : chars2) {
            int count = map.getOrDefault(c2, 0) - 1;
            map.put(c2, count);
            if (map.get(c2) < 0) {
                return false;
            }
        }
        return true;
    }
}
