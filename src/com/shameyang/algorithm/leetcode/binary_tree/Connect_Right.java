package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/26 19:18
 * @description 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点，
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL
 *
 * 思路：1.迭代 - bfs 横向
 *      2.递归 - dfs 纵向
 */
public class Connect_Right {
    //1.bfs
    public Node connect01(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                //将同一层元素串联起来
                if (i < n - 1) {
                    node.next = queue.peek();
                }
                //处理左右子树
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    //2.常量辅助空间迭代
    public Node connect02(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        while (pre.left != null) {
            Node temp = pre;
            while (temp != null) {
                //连接同一根节点的元素
                temp.left.next = temp.right;
                //连接不同根节点的元素
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                //遍历同层的下一元素
                temp = temp.next;
            }
            //遍历下一层
            pre = pre.left;
        }
        return root;
    }

    //3.递归
    public Node connect03(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
