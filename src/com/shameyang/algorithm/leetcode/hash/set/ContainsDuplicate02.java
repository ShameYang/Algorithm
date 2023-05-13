package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/13 14:08
 * @description 存在重复元素2
 */
public class ContainsDuplicate02 {
    public boolean containsDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
