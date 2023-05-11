package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/11 14:46
 * @description 只出现一次的数字
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                hashSet.remove(i);
            } else {
                hashSet.add(i);
            }
        }
        return hashSet.iterator().next(); //根据题意，结果集合中只存在一个元素
    }
}
