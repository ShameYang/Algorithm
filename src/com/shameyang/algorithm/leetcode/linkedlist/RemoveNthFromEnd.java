package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/21 19:28
 * @description 删除链表的倒数第 N 个结点
 * 思路：
 *      在 head 前创建一个哑结点(dummy node)，避免讨论头结点被删除的问题，直接返回 dummy.next 即可
 *      1.求链表长度，然后遍历
 *      2.前后指针，后指针指向 dummy，前指针指向 head，前指针先走，直到两指针的距离为 n，然后两指针同时走，
 *        当前指针指向链表尾部时，后指针的下一个即为删除的结点
 */
public class RemoveNthFromEnd {
    //1.求链表长度，然后遍历
    public Node removeNthFromEnd01(Node head, int n) {
        //在 head 前创建一个 dummy 结点
        Node dummy = new Node(0, head);
        int length = length(head);
        Node cur = dummy;
        //遍历到要删除结点的前一个
        for(int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        //删除操作
        cur.next = cur.next.next;
        //结果返回 dummy.next 即可
        return dummy.next;
    }
    //链表长度
    public int length(Node head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    //2.前后指针
    public Node removeNthFromEnd02(Node head, int n) {
        Node dummy = new Node(0, head);
        Node left = dummy; //后指针
        Node right = head; //前指针
        //前指针先走，让两指针距离为 n
        for(int i = 1; i < n; i++) {
            right = right.next;
        }
        //让前指针指到尾部
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
