package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/20 16:21
 * @description 设计链表 - 双链表
 */
public class DoubleLinkedList {
    int size;
    Node head;


    public DoubleLinkedList() {
        size = 0;
        head = new Node(0);
    }

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
