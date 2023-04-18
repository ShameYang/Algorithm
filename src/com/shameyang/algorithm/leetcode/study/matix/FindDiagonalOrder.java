package com.shameyang.algorithm.leetcode.matix;

/**
 * @author ShameYang
 * @date 2023/4/17 16:21
 * @description 对角线遍历
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int count = row + col - 1;
        int[] ans = new int[row * col];
        int m = 0;
        int n = 0;
        int index = 0;

        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                while (m >= 0 && n < col) {
                    ans[index++] = mat[m][n];
                    m--;
                    n++;
                }
                if (n < col) {
                    m++;
                } else {
                    m += 2;
                    n--;
                }
            } else {
                while (m < row && n >= 0) {
                    ans[index++] = mat[m][n];
                    m++;
                    n--;
                }
                if (m < row) {
                    n++;
                } else {
                    m--;
                    n += 2;
                }
            }
        }

        return ans;
    }
}
