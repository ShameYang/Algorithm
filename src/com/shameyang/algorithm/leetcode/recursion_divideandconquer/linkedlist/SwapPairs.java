package com.shameyang.algorithm.leetcode.recursion_divideandconquer.linkedlist;

/**
 * @author ShameYang
 * @date 2023/6/1 15:14
 * @description 两两交换链表中的节点
 * 递归出口：当前节点或者下一个节点为空，返回
 * 方法内容：当前节点next，指向当前节点，指针互换
 * 返回值：返回交换完成的节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
