package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/24 15:24
 * @description 二叉树的层序遍历 - bfs
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
