package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/5/22 16:20
 * @description 先序遍历二叉树
 * 给你二叉树的根节点 root ，返回它节点值的前序遍历
 * 1.递归
 * 2.迭代（栈）
 */
public class PreorderTraversal {
    //1.递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //2.迭代
    public List<Integer> preorderTraversal02(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
