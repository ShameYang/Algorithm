package com.shameyang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author ShameYang
 * @date 2023/5/8 16:45
 * @description 最小栈
 * 思路：
 *      1.辅助栈
 *      2.链表
 */
public class MinStack {
    //1.辅助栈
    class MinStack01 {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        public MinStack01() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min_stack.empty() || val <= min_stack.peek()) {
                min_stack.push(val);
            }
        }

        public void pop() {
            if (stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

    //2.链表
    class MinStack02 {
        Node head;

        //每次加入的节点放到头部
        public void push(int val) {
            if (null == head) {
                head = new Node(val, val);
            } else {
                //当前值和之前头结点的最小值较小的做为当前的 min
                Node n = new Node(val, Math.min(val, head.min));
                n.next = head;
                head = n;
            }
        }

        public void pop() {
            if (head != null)
                head = head.next;
        }

        public int top() {
            if (head != null)
                return head.value;
            return -1;
        }

        public int getMin() {
            if (null != head)
                return head.min;
            return -1;
        }

        class Node {
            int value;
            int min;
            Node next;

            Node(int value, int min) {
                this.value = value;
                this.min = min;
                next = null;
            }
        }
    }
}
