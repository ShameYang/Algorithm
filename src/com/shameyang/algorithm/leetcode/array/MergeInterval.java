package com.shameyang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author ShameYang
 * @date 2023/4/15 17:40
 * @description 合并区间
 * 思路：先按二维数组的一维排序，然后比较
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] res = new int[intervals.length][2];
        int index = 0; //结果数组的下标
        int length = intervals.length;
        for (int i = 0; i < length; i++) {
            //第一个数组直接添加，或者当前数组的左端比前一个数组的右端大，直接添加
            if (i == 0 || intervals[i][0] > res[index - 1][1]) {
                res[index++] = intervals[i];
            } else { //合并
                res[index - 1][1] = Math.max(res[index - 1][1], intervals[i][1]);
            }
        }

        return Arrays.copyOf(res, index); //不直接返回res，防止出现多余数组
    }
}
