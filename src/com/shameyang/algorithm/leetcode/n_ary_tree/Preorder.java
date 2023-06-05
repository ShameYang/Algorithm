package com.shameyang.algorithm.leetcode.n_ary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/6/5 13:42
 * @description N 叉树的前序遍历
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node n : root.children) {
            helper(n, res);
        }
    }
}
