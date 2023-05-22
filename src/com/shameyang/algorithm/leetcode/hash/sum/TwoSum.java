package com.shameyang.algorithm.leetcode.hash.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/11 13:52
 * @description 两数之和
 * 思路：将数组采用键值对（数值-索引）存储到 HashMap，遍历数组，
 *      判断是否存在 target - nums[i]，存在返回 i 和 get(target - nums[i]) 即可
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }
}
