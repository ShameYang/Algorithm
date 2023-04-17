package com.shameyang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/4/17 17:06
 * @description 杨辉三角，生成前 n 行
 */
public class YangHui01 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
