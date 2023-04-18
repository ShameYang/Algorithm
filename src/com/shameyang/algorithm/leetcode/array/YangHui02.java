package com.shameyang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShameYang
 * @date 2023/4/17 17:08
 * @description 杨辉三角，返回指定行
 */
public class YangHui02 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(); //记录上一行数据
        list.add(1); //开头 1
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) { //从尾到头避免覆盖
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1); //末尾 1
        }
        return list;
    }
}
