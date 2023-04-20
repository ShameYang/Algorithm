package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/20 16:21
 * @description 设计链表 - 双链表
 * 思路：与单链表同理，但是需要注意插入或删除时元素的位置
 */
public class DoubleLinkedList {
    int size;
    Node head;

    //初始化
    public DoubleLinkedList() {
        size = 0;
        head = new Node(0);
    }

    //头插，需要注意是否为空表
    public void addAtHead(int val) {
        if (size == 0) {
            Node node = new Node(val);
            node.prev = head;
            head.next = node;
            size++;
        } else {
            Node node = new Node(val);
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
    }

    //尾插
    public void addAtTail(int val) {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        Node node = new Node(val);
        node.prev = cur;
        cur.next = node;
        size++;
    }

    //添加，注意添加位置
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (index == size) {
            addAtTail(val);
        } else {
            Node node = new Node(val);
            node.next = cur.next;
            cur.next.prev = node;
            node.prev = cur;
            cur.next = node;
            size++;
        }

    }

    //删除，注意删除位置
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (index == size - 1) {
            cur.next = cur;
        } else {
            cur.next = cur.next.next;
            cur.next.prev = cur;
        }
        size--;
    }

    //查找
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
}
