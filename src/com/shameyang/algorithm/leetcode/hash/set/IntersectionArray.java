package com.shameyang.algorithm.leetcode.hash.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/5/11 15:24
 * @description 两数组交集
 * 思路：先遍历第一个数组，添加到 set1，然后遍历另一个数组，判断元素在 set1 中是否存在，
 *      存在则添加到 set2，将 set2 转换成数组即可得到结果数组
 */
public class IntersectionArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            res[index++] = i;
        }
        return res;
    }
}
