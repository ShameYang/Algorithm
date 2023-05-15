package com.shameyang.algorithm.leetcode.hash.design;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/15 13:45
 * @description 字母异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //排序
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            //排序后的 ca 作为 key
            String key = new String(ca);
            //添加到 map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
