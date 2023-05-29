package com.shameyang.algorithm.leetcode.binary_search_tree;

/**
 * @author ShameYang
 * @date 2023/5/29 14:11
 * @description 二叉搜索树 - 搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val == root.val) {
            return root;
        }

        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
