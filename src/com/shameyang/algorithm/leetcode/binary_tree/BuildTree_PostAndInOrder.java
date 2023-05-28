package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShameYang
 * @date 2023/5/25 17:41
 * @description 从中序与后序遍历序列构造二叉树
 * 思路：根据后序找到根节点，然后根据中序分为左右子树
 */
public class BuildTree_PostAndInOrder {
    int post_idx;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        //从后序遍历的最后一个值开始
        post_idx = postorder.length - 1;
        //建立哈希表(元素，下标)，快速定位根节点
        int idx = 0;
        for (Integer val : inorder) {
            map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        //根据 post_idx 位置创建当前子树的根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        //根据 root 分成左右两棵子树
        int index = map.get(root_val);
        post_idx--;
        //根据后序遍历顺序，所以先构建右子树
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }
}
