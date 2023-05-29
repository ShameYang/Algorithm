package com.shameyang.algorithm.leetcode.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/5/29 14:06
 * @description 二叉搜索树迭代器
 */
public class BSTIterator {
    private int idx;
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
        idx = 0;
        list = new ArrayList<>();
        inorderTraversal(root, list);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
