package com.shameyang.algorithm.leetcode.hash.map;

/**
 * @author ShameYang
 * @date 2023/5/14 16:53
 * @description 最大连续 1 的个数
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeros = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros > k && nums[left++] == 0) {
                zeros--;
            }
        }
        return right - left;
    }
}
