package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/23 14:36
 * @description 移除链表元素
 * 思路：
 * 1.哑结点：无需考虑头结点是否为删除元素，直接遍历链表，结果返回 dummy.next 即可
 * 2.双指针
 * 3.递归
 */
public class RemoveElements {
    //1.哑结点
    public Node removeElements01(Node head, int val) {
        //创建哑结点
        Node dummy = new Node(-1, head);
        //从哑结点开始遍历，判断下一个结点的值是否符合删除值
        Node cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    //2.双指针
    public Node removeElements02(Node head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    //3.递归
    public Node removeElements03(Node head, int val) {
        if(head == null) {
            return null;
        }

        head.next = removeElements03(head.next, val);
        return head.val == val ? head.next : head;
    }
}
