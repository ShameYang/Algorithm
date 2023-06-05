package com.shameyang.algorithm.leetcode.n_ary_tree;

import java.util.List;

/**
 * @author ShameYang
 * @date 2023/6/5 13:45
 * @description
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}