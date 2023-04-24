package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/24 14:05
 * @description 奇偶链表
 * 思路：odd 指向头结点连接奇数位置，创建一个 evenHead 作为偶数的头结点，even 指向 evenHead，连接偶数位置
 */
public class OddEvenList {
    public Node oddEvenList(Node head) {
        if (head == null) {
            return null;
        }
        //注意这里需要创建 evenHead，否则形成环
        Node evenHead = head.next;
        Node odd = head;
        Node even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
