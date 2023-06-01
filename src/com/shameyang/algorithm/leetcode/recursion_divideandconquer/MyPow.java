package com.shameyang.algorithm.leetcode.recursion_divideandconquer;

/**
 * @author ShameYang
 * @date 2023/5/22 17:07
 * @description 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数
 * 快速幂 + 递归
 */
public class MyPow {
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
    }

    public double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
