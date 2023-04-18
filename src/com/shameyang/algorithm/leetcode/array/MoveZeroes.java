package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:50
 * @description 移动零
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;

        for (; right < len; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
