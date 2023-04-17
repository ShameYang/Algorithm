package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:39
 * @description 移除元素
 * 思路：快慢指针
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int len = nums.length;
        for (; fast < len; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
