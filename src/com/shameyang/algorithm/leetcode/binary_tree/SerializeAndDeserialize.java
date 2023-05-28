package com.shameyang.algorithm.leetcode.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/28 16:33
 * @description 二叉树的序列化和反序列化
 */
public class SerializeAndDeserialize {
    //1.bfs
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val);
                //遍历左右子树
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append("null");
            }
            res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!dataList[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if(!dataList[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
