package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/19 19:55
 * @description 设计链表 - 单链表
 */
public class SingleLinkedList {
    int size;
    Node head;

    //初始化
    public SingleLinkedList() {
        size = 0;
        head = new Node(0);
    }

    //头插
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    //尾插
    public void addAtTail(int val) {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        Node node = new Node(val);
        cur.next = node;
        size++;
    }

    //增加
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
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    //删除
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
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