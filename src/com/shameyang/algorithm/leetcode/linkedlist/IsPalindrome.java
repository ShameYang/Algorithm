package com.shameyang.algorithm.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/4/24 14:20
 * @description 回文链表
 * 思路：
 *      1.拷贝 + 双指针：先将值复制到数组列表，然后双指针从两端向中心遍历
 *      2.快慢指针：先利用快慢指针找到中间位置，然后将后半部分反转，判断回文，最后恢复链表
 */
public class IsPalindrome {
    //1.拷贝 + 双指针
    public boolean isPalindrome01(Node head) {
        if (head == null) {
            return true;
        }
        //将值复制到数组列表
        List<Integer> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        //双指针遍历
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //2.快慢指针
    public boolean isPalindrome02(Node head) {
        //空表或只有一个结点
        if (head == null || head.next == null) {
            return true;
        }
        //找到中点
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半部分
        Node prev = null;
        Node cur = slow.next;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //两端遍历，注意奇偶情况，否则出现空指针异常
        while (head != prev) {
            if (head.val != prev.val) {
                return false;
            }
            if (prev.next == null) {
                break;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
