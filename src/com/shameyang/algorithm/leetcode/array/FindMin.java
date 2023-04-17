package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/17 16:58
 * @description 寻找旋转排序数组中的最小值
 * 思路：二分查找，与最左端比较有特殊情况，所以与最右侧比较
 */
public class FindMin {

    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
