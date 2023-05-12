package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/12 13:02
 * @description 快乐数
 */
public class HappyNumber {
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
