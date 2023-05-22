package com.shameyang.algorithm.leetcode.hash.map;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/22 13:43
 * @description 根据字符出现频率排序
 */
public class FrequencySort {
    public String frequencySort(String s) {
        //将字符串转化为字符数组，存储到 map(字符 : 频率)
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        //根据频率排序
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        //遍历排序后的 list，添加到结果数组
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
