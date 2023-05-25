package com.shameyang.algorithm.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/25 18:29
 * @description 从前序与中序遍历序列构造二叉树
 */
public class BuildTree_PreAndInOrder {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        //建立哈希表，快速定位根节点
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        //在中序中定位根节点
        int in_root = map.get(preorder[pre_left]);
        //先构建根节点
        TreeNode root = new TreeNode(preorder[pre_left]);
        //左子树的节点数目
        int size_left_subtree = in_root - in_left;

        root.left = helper(preorder, inorder, pre_left + 1, pre_left + size_left_subtree,
                in_left, in_root - 1);
        root.right = helper(preorder, inorder, pre_left + size_left_subtree + 1, pre_right,
                in_root + 1, in_right);

        return root;
    }
}
