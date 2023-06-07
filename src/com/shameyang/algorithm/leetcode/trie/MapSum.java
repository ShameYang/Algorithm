package com.shameyang.algorithm.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/6/7 17:19
 * @description 键值映射
 * 设计一个 map ，满足以下几点:
 *      1.字符串表示键，整数表示值
 *      2.返回具有前缀等于给定字符串的键的值的总和
 */
public class MapSum {
    Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String s : map.keySet()) {
            if (s.startsWith(prefix)) {
                res += map.get(s);
            }
        }
        return res;
    }
}
