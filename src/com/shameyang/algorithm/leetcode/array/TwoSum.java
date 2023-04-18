package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:35
 * @description 两数之和 - 输入有序数组
 * 思路：双指针遍历求两数之和，如果比目标值大，尾指针前移，否则头指针后移
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }

        }
        return new int[]{-1, -1};
    }
}
