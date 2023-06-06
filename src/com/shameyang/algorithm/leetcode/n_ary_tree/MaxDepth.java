package com.shameyang.algorithm.leetcode.n_ary_tree;

/**
 * @author ShameYang
 * @date 2023/6/6 18:08
 * @description N 叉树的最大深度
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        for (Node child : root.children) {
            res = Math.max(res, maxDepth(child));
        }

        return res + 1;
    }
}
