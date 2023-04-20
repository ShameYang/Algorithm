package com.shameyang.algorithm.leetcode.matix;

/**
 * @author ShameYang
 * @date 2023/4/17 15:09
 * @description 零矩阵
 * 思路：使用一个标记变量标记第一列原本是否有 0，然后使用其他行处理第一行和第一列，
 *      然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        boolean flagCol = false; //标记

        for (int i = 0; i < col; i++) {
            //检查第一列是否有 0
            if (matrix[i][0] == 0) {
                flagCol = true;
            }
            //给 0 所在行和列（除第一列）的第一个元素赋 0
            for (int j = 1; j < row; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        //倒序遍历
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 1; j < row; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            //更新第一列
            if (flagCol) {
                matrix[i][0] = 0;
            }
        }

    }
}
