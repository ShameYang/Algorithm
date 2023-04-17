package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/15 17:37
 * @description 数组中心下标，左侧和等于右侧和
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0;
        int sum = 0;
        for (int num : nums) {
            total += num;
        }
        //前缀和法
        for (int i = 0; i < n; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
