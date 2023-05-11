package com.shameyang.algorithm.leetcode.hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/11 14:21
 * @description 同构字符串
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        char[] c1 = s.toCharArray();
        char[] c2 = s.toCharArray();
        int len = c1.length;
        for (int i = 0; i < len; i++) {
            char x = c1[i];
            char y = c2[i];
            if (s2t.containsKey(x) && s2t.get(x) != y ||
                    t2s.containsKey(y) && t2s.get(y) != x) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
