package com.shameyang.algorithm.leetcode.recursion_divideandconquer.linkedlist;

/**
 * @author ShameYang
 * @date 2023/6/1 14:31
 * @description 合并两个有序数组
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //终止条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
