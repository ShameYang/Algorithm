package com.shameyang.algorithm.leetcode.binary_search_tree;

import java.util.PriorityQueue;

/**
 * @author ShameYang
 * @date 2023/5/30 17:34
 * @description 数据流中的第K大元素 - 优先队列
 */
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
