package com.shameyang.algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ShameYang
 * @date 2023/5/9 17:36
 * @description 用栈实现队列
 */
public class ImplementsQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public ImplementsQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
