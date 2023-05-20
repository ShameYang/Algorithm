package com.shameyang.algorithm.leetcode.hash.map;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/20 15:35
 * @description 常数时间插入、删除和获取随机元素
 */
public class RandomizedSet {
    Map<Integer, Integer> map;
    Random random;
    List<Integer> nums;

    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int idx = nums.size();
        nums.add(val);
        map.put(val, idx);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(idx, last);
        map.put(last, idx);
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = random.nextInt(nums.size());
        return nums.get(randomIdx);
    }
}
