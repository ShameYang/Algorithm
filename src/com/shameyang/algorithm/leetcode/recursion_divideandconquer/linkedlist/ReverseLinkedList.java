package com.shameyang.algorithm.leetcode.recursion_divideandconquer.linkedlist;

/**
 * @author ShameYang
 * @date 2023/6/1 15:05
 * @description 反转链表
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //终止条件，找到尾结点
        if (head == null || head.next == null) {
            return head;
        }

        //cur 是尾结点，也是反转链表的头结点
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
