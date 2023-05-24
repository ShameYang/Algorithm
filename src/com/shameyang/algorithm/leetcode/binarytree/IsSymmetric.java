package com.shameyang.algorithm.leetcode.binarytree;

/**
 * @author ShameYang
 * @date 2023/5/24 16:20
 * @description 对称二叉树 - 递归实现
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root.left, root.right);
    }

    boolean bfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return bfs(left.left, right.right) && bfs(left.right, right.left);
    }
}
