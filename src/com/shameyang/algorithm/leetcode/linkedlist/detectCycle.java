package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/20 17:56
 * @description 环形链表2 - 找到入环点
 * 思路：快慢指针，快指针走两步，慢指针走一步，先判断是否有环
 * 根据计算得到，出发点到入环点的距离 = 相遇点到入环点的距离，
 * 所以当两指针相遇时，慢指针回到出发点，快指针在相遇点，两指针共速走，再次相遇点即入环点
 */
public class detectCycle {
    public Node detectCycle(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        //有环一直走，相遇就停下
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        //没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        //慢指针回到出发点，快指针在相遇点，相同速度走，再次相遇就找到入环点
        slow = head;
        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
