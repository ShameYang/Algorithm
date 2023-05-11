package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/10 15:23
 * @description 存在重复元素
 * 思路；遍历数组，添加到 set 中，加不进去则存在重复元素
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
