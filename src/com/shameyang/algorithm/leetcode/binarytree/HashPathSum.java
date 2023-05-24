package com.shameyang.algorithm.leetcode.binarytree;

/**
 * @author ShameYang
 * @date 2023/5/24 16:28
 * @description 路径总和 - 递归
 */
public class HashPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
