package com.shameyang.algorithm.leetcode.hash.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ShameYang
 * @date 2023/5/10 14:24
 * @description 设计哈希集合
 */
public class MyHashSet {
    private static final int BASE = 769; //距离 512 和 1024 都较远，且为质数，尽量增大加载因子
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    /* 哈希函数 */
    private static int hash(int key) {
        return key % BASE;
    }
}