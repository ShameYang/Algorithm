package com.shameyang.algorithm.leetcode.linkedlist;

/**
 * @author ShameYang
 * @date 2023/4/26 14:17
 * @description 两数逆序相加
 * 思路：虚拟头结点，遍历链表，一个链表为空时补 0，最后处理末尾
 */
public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        //定义一个虚拟头结点
        Node dummy = new Node(0);
        //定义一个 cur 用来连接结果链表
        Node cur = dummy;
        //记录进位数
        int carry = 0;
        //当两个都为空时就退出循环，否则将空链表补 0
        while (l1 != null || l2 != null) {
            //补 0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //求和，加上进位数
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new Node(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //处理末尾
        if (carry == 1) {
            cur.next = new Node(1);
        }
        return dummy.next;
    }
}
