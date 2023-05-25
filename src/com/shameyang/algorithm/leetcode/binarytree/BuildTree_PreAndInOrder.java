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
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right || in_left > in_right) {
            return null;
        }
        //根节点的值
        int rootVal = preorder[pre_left];
        //在中序中定位根节点
        int in_idx = map.get(rootVal);
        //先构建根节点
        TreeNode root = new TreeNode(rootVal);
        //左子树的节点数目
        int size_left_subtree = in_idx - in_left;
        
        root.left = helper(preorder, inorder,
                pre_left + 1, pre_left + size_left_subtree, in_left, in_idx - 1);
        root.right = helper(preorder, inorder,
                pre_left + size_left_subtree + 1, pre_right, in_idx + 1, in_right);

        return root;
    }
}
