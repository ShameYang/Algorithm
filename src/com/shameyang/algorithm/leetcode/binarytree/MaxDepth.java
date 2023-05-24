package com.shameyang.algorithm.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/24 14:55
 * @description 二叉树的最大深度
 * 1.递归
 * 2.迭代
 */
public class MaxDepth {
    //1.递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //2.迭代
    public int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
