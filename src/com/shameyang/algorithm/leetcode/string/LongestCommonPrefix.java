package com.shameyang.algorithm.leetcode.string;

/**
 * @author ShameYang
 * @date 2023/4/17 17:21
 * @description 最长公共前缀
 * 思路：
 *      1.纵向扫描
 *      2.API，找到最短字符串，然后使用 startsWith() 和 substring() 方法
 */
public class LongestCommonPrefix {
    //1.纵向扫描
    public String longestCommonPrefix01(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //纵向扫描
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    //2.API
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //找到最短字符串
        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        //公共前缀
        String common = shortest;
        int shortestLen = shortest.length();
        for (int i = 0; i < shortestLen; i++) {
            //遍历 strs，判断前缀是否为 common
            for (String str : strs) {
                //若最长公共前缀不是 common，则截取 [0, length - 1]
                if (!str.startsWith(common)) {
                    common = common.substring(0, common.length() - 1);
                }
            }
        }
        return common;
    }
}
