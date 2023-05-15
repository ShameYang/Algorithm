package com.shameyang.algorithm.leetcode.hash.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/15 16:14
 * @description 两数之和 III - 数据结构设计
 */
public class TwoSumIII {
    private HashMap<Integer, Integer> map;

    public TwoSumIII() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if(map.containsKey(number)) {
            map.replace(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if(complement != entry.getKey()) {
                if(map.containsKey(complement)) {
                    return true;
                }
            } else {
                if(entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
