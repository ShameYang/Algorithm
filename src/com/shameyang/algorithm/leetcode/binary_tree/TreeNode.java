package com.shameyang.algorithm.leetcode.binary_tree;

/**
 * @author ShameYang
 * @date 2023/5/22 16:17
 * @description Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
