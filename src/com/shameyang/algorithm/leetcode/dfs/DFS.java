package com.shameyang.algorithm.leetcode.dfs;

import com.shameyang.algorithm.leetcode.binarytree.TreeNode;

/**
 * @author ShameYang
 * @date 2023/5/24 13:47
 * @description 深度优先搜索
 */
public class DFS {
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
