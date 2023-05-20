package com.shameyang.algorithm.leetcode.hash.design;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/15 13:45
 * @description 字母异位词分组
 * 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
 * 故可以将排序之后的字符串作为哈希表的键。
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
