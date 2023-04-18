package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:52
 * @description 删除排序数组中的重复项，返回新数组长度
 * 思路：双指针从第二个元素开始遍历，当前元素与前一个元素不同时，覆盖左指针位置的值，左指针右移
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = 1;
        for (; right < len; right++) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
