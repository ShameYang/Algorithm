package com.shameyang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author ShameYang
 * @date 2023/5/8 19:29
 * @description 每日温度
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<>();
        int length = t.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.add(i);
        }
        return result;
    }
}
