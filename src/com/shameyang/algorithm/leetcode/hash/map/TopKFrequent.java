package com.shameyang.algorithm.leetcode.hash.map;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/16 17:58
 * @description
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o2.getValue() - o1.getValue();  // 降序排序
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int key = list.get(i).getKey();
            ans[i] = key;
        }
        return ans;
    }
}
