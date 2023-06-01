package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/25 20:46
 * @description 合并两个有序链表
 * 思路：
 *      1.虚拟头结点 + 迭代：虚拟头结点用于返回结果链表，注意最后处理最后一个结点
 *      2.递归
 */
public class MergeTwoLists {
    //1.虚拟头结点 + 迭代
    public Node mergeTwoLists01(Node list1, Node list2) {
        //虚拟头结点
        Node dummy = new Node(-1);
        //迭代
        Node prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        //连接最后一个结点，list1 和 list2 其中会有一个结点未连接
        prev.next = list1 == null ? list2 : list1;

        return dummy.next;
    }

    //2.递归
    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
