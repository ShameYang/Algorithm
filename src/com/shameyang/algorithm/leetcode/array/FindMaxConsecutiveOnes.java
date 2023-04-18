package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:42
 * @description 最大连续 1 的个数
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int max = 0;
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }

        return max > count ? max : count;
    }
}
