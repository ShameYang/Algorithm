package com.shameyang.algorithm.leetcode.trie;

import java.util.List;

/**
 * @author ShameYang
 * @date 2023/6/8 16:52
 * @description 单词替换
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        MyTrie MyTrie = new MyTrie();
        //建立前缀树
        for (String s : dictionary) {
            MyTrie.insert(s);
        }
        //产生替换后的句子
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(MyTrie.find(word));
        }
        return res.toString();
    }
}

class MyTrie {
    private MyTrie[] next = new MyTrie[26];
    private String sentence;

    public MyTrie() {

    }

    public void insert(String word) {
        MyTrie node = this;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new MyTrie();
            }
            node = node.next[idx];
        }
        node.sentence = word;
    }

    public String find(String prefix) {
        MyTrie node = this;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (node == null) {
                break;
            }
            //如果当前节点已有词根，那么直接返回该词根
            //保证每个继承词都是被最短词根替换的
            if (node.sentence != null) {
                return node.sentence;
            }
            int idx = c - 'a';
            node = node.next[idx];
        }
        //没有在字典中找到该继承词所对应的词根，因此不产生替换
        return prefix;
    }
}
