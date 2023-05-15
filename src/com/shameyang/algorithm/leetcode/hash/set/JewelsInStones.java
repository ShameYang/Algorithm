package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/15 15:13
 * @description 宝石与石头
 */
public class JewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        char[] ca1 = jewels.toCharArray();
        for (char c : ca1) {
            set.add(c);
        }
        char[] ca2 = stones.toCharArray();
        int count = 0;
        for (char c : ca2) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
