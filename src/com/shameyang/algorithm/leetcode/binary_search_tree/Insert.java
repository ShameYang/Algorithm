package com.shameyang.algorithm.leetcode.binary_search_tree;

/**
 * @author ShameYang
 * @date 2023/5/29 14:19
 * @description 二叉搜索树 - 插入
 */
public class Insert {
    public TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = insertBST(root.left, val);
        } else {
            root.right = insertBST(root.right, val);
        }

        return root;
    }
}
