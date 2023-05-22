package com.shameyang.algorithm.leetcode.recurtion_divedeandconquer;

/**
 * @author ShameYang
 * @date 2023/5/22 17:56
 * @description 不使用 * 实现乘法运算
 */
public class Multiply {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (B == 1) {
            return A;
        }
        if (A < B) {
            swap(A, B);
        }
        return A + multiply(A, B - 1);
    }

    private void swap(int a, int b) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }
}
