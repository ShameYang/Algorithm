package com.shameyang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author ShameYang
 * @date 2023/4/17 16:29
 * @description 数组拆分，求最大总和
 * 思路：先排序，无法取最大的，那就取第二大的，使用双指针遍历求和
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = n - 2;
        for (; left < right; left += 2, right -= 2) {
            res += (nums[left] += nums[right]);
        }
        return res;
    }
}
