package com.shameyang.algorithm.leetcode.n_ary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/6/5 13:56
 * @description N 叉树的后序遍历
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            helper(ch, res);
        }
        res.add(root.val);
    }
}
