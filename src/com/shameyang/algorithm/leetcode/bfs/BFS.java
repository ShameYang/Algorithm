package com.shameyang.algorithm.leetcode.bfs;

import com.shameyang.algorithm.leetcode.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/24 13:47
 * @description 广度优先搜索
 */
public class BFS {
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
