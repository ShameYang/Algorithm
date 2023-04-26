package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/26 15:23
 * @description 旋转链表
 * 思路：
 * 前后指针，同时指向head，前指针先走 k % n 步
 *      先判断是否需要旋转，然后遍历得到链表长度，对 k 进行取余（本题 k%=n 等价于 k=n），
 *      前后指针
 */
public class RotateRight {
    public Node rotateRight(Node head, int k) {
        //判断是否需要旋转
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //遍历得到长度
        Node cur = head;
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        //对 k 取余
        k %= n;
        if (k == 0) {
            return head;
        }
        //前后指针
        Node first = head;
        Node last = head;
        Node prev = null;
        for (int i = 1; i <= k; i++) {
            first = first.next;
        }
        //当前指针为空时，后指针指向结果链表的头结点
        while (first != null) {
            first = first.next;
            prev = last;
            last = last.next;
        }
        //形成环然后断开前驱结点
        cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        prev.next = null;
        return last;
    }
}
