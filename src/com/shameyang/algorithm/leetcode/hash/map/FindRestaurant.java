package com.shameyang.algorithm.leetcode.hash.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/12 16:50
 * @description 两个列表索引最小总和
 * 思路：
 *      1.将 list1 添加到 map 中（值-索引）
 *      2.遍历 list2，如果 map 中没有或当前索引大于最小索引和，则 continue;
 *          如果小于最小索引和，清空结果集合并更新 min，将字符串添加到结果集合中，
 *          最后 toArray
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int len = list1.length;
        for (int i = 0; i < len; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int n = list2.length;
        for (int i = 0; i < n; i++) {
            String s = list2[i];
            if (!map.containsKey(s) || i > min) {
                continue;
            }
            if (i + map.get(s) < min) {
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) == min) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
    }
}
