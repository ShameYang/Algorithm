package com.shameyang.algorithm.leetcode.hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/13 14:09
 * @description 存在重复元素 II
 */
public class ContainsDuplicate02 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
