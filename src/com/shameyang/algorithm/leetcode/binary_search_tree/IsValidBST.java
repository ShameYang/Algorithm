package com.shameyang.algorithm.leetcode.binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShameYang
 * @date 2023/5/29 13:50
 * @description 验证二叉搜索树
 */
public class IsValidBST {
    //1.递归
    public boolean isValidBST01(TreeNode root) {
        return isValidBST01(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST01(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST01(node.left, lower, node.val) && isValidBST01(node.right, node.val, upper);
    }

    //2.迭代
    public boolean isValidBST02(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long min = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) {
                return false;
            }

            min = root.val;
            root = root.right;
        }
        return true;
    }
}
