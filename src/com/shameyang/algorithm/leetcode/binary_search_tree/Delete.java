package com.shameyang.algorithm.leetcode.binary_search_tree;

/**
 * @author ShameYang
 * @date 2023/5/30 17:46
 * @description 二叉搜索树 - 删除
 */
public class Delete {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        //删除的值为根节点
        if (key == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //新的根节点为右子树中的最小值
            TreeNode newRoot = root.right;
            while (newRoot.left != null) {
                newRoot = newRoot.left;
            }
            //在右子树中删除新的节点
            root.right = deleteNode(root.right, newRoot.val);
            newRoot.right = root.right;
            newRoot.left = root.left;
            return newRoot;
        }
        return root;
    }
}
