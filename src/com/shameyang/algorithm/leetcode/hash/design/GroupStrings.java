package com.shameyang.algorithm.leetcode.hash.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/20 16:12
 * @description 移位字符串分组
 */
public class GroupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String key = encode(strings[i]);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strings[i]);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        int len = s.length();
        for (int i = 1; i < len; i++) {
            int offset = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
            sb.append((char) ('a' + offset));
        }
        return sb.toString();
    }
}
