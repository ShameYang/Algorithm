package com.shameyang.algorithm.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShameYang
 * @date 2023/5/9 17:57
 * @description 用队列实现栈
 */
public class ImplementsStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public ImplementsStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
