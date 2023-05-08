package com.shameyang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author ShameYang
 * @date 2023/5/8 18:19
 * @description 有效的括号
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.empty();
    }
}
