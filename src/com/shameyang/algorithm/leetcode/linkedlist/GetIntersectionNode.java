package com.shameyang.algorithm.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShameYang
 * @date 2023/4/21 19:01
 * @description 相交链表
 * 思路：
 *      1.哈希集合：将一个链表遍历并添加到集合 Set 中，然后遍历另一个链表，判断结点是否在集合中存在
 *      2.双指针：创建两个 Node，当链表不相交时，循环遍历两链表，其中一个为空则指向另一个
 */
public class GetIntersectionNode {
    //1.哈希集合
    public Node getIntersectionNode01(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<Node> visited = new HashSet<>();
        Node temp = headA;
        //遍历并添加其中一个链表
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        //遍历另一个链表，判断结点是否存在
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    //2.双指针
    public Node getIntersectionNode02(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Node a = headA;
        Node b = headB;
        //a 与 b 指向不同链表时，则向后遍历
        while(a != b) {
            //a 为空则指向 headB
            if(a != null) {
                a = a.next;
            } else {
                a = headB;
            }
            //b 为空则指向 headA
            if(b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;
    }
}
