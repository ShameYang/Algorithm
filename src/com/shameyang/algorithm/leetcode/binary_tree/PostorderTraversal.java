package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/5/23 20:47
 * @description 后序遍历二叉树
 */
public class PostorderTraversal {
    //1.递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    //2.迭代
    public List<Integer> postorderTraversal02(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
