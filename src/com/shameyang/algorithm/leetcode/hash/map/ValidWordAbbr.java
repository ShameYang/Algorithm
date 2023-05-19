package com.shameyang.algorithm.leetcode.hash.map;

import java.util.*;

/**
 * @author ShameYang
 * @date 2023/5/19 17:06
 * @description 单词的唯一缩写
 *
 * 实现 ValidWordAbbr 类：
 *  ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
 *  boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
 *      字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
 *      字典 dictionary 中的所有缩写与该单词 word 的缩写相同的单词都与 word 相同 。

 */
public class ValidWordAbbr {
    //方法一：计数器，定义一个用来存储单词缩写的 map(abbr : words)
    private final Map<String, Set<String>> abbrDict = new HashMap<>();

    //添加单词缩写到词典
    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            Set<String> words = abbrDict.containsKey(abbr) ?
                    abbrDict.get(abbr) : new HashSet<>();
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = abbrDict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    //单词 -> 缩写
    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }

    static class ValidWordAbbr02 {
        //方法二：定义一个 map(abbr : containsKey(abbr)) 判断是否出现超过一次
        //定义 set 用来存储单词列表
        private final Map<String, Boolean> abbrDict = new HashMap<>();
        private final Set<String> dict;

        public ValidWordAbbr02(String[] dictionary) {
            dict = new HashSet<>(Arrays.asList(dictionary));
            for (String s : dict) {
                String abbr = toAbbr(s);
                abbrDict.put(abbr, !abbrDict.containsKey(abbr));
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            Boolean hasAbbr = abbrDict.get(abbr);
            return hasAbbr == null || (hasAbbr && dict.contains(word));
        }

        private String toAbbr(String s) {
            int n = s.length();
            if (n <= 2) {
                return s;
            }
            return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
        }
    }
}
