package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/20 17:30
 * @description 环形链表 - 根据给定头结点，判断是否链表是否有环
 * 思路：快慢指针，快指针走两步，慢指针走一步，判断两指针是否相遇
 */
public class HasCycle {
    public boolean hasCycle(Node head) {
        if(head == null) {
            return false;
        }
        //创建快慢指针
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
