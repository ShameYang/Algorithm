package com.shameyang.algorithm.leetcode.recursion_divideandconquer.linkedlist;

/**
 * @author ShameYang
 * @date 2023/6/1 15:11
 * @description 移除链表元素
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
