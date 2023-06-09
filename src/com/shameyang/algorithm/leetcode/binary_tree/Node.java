package com.shameyang.algorithm.leetcode.binary_tree;

/**
 * @author ShameYang
 * @date 2023/5/26 19:16
 * @description Definition for a Node
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
