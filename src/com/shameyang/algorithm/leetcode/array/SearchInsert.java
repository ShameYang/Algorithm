package com.shameyang.algorithm.leetcode.array;

/**
 * @author ShameYang
 * @date 2023/4/15 17:36
 * @description 搜索插入位置
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        //二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2; //防止数据溢出
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
