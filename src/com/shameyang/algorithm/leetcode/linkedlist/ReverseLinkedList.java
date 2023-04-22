package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/22 22:32
 * @description 反转链表
 * 思路：
 * 1.迭代
 *      将链表的 next 指向前一个结点，需要事先存储前一个结点，更改引用时要存储后一个结点
 * 2.递归
 *      递归核心思想：后边的结点已经成功翻转，我们只需要将头结点和次结点反转即可
 *      1 -> 2 -> 3 -> 4 -> 5
 *      1 -> 2 <- 3 <- 4 <- 5
 */
public class ReverseLinkedList {
    //1.迭代
    public Node reverseList01(Node head) {
        Node prev = null; //存储前一个结点
        Node cur = head;
        Node next = null; //存储后一个结点
        while (cur != null) {
            next = cur.next;
            cur.next = prev; //当前结点连接前一个结点
            prev = cur;
            cur = next;
        }
        return prev;
    }
    //2.递归
    public Node reverseList02(Node head) {
        //head 指向尾结点时 return
        if(head == null || head.next == null) {
            return head;
        }
        //cur 是尾结点，也是反转链表的头结点
        Node cur = reverseList02(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
