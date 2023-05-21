package com.shameyang.algorithm.leetcode.hash.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/21 18:20
 * @description 两个数组的交集 II
 */
public class IntersectionArrayII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[nums2.length];
        int idx = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                res[idx++] = i;
                count--;
                if (count > 0) {
                    map.put(i, count);
                } else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}
