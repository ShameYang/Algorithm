package com.shameyang.algorithm.leetcode.recursion_divideandconquer;

/**
 * @author ShameYang
 * @date 2023/5/22 17:34
 * @description 不用加减乘除做加法
 */
public class Add {
    public int add(int a, int b) {
        while (b != 0) { //进位为 0 时跳出
            int carry = (a & b) << 1; //计算进位
            a ^= b; //计算本位
            b = carry;
        }
        return a;
    }
}
