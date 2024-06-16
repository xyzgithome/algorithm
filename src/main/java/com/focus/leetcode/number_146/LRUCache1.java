package com.focus.leetcode.number_146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/lru-cache/
 *
 * least recently used
 */
public class LRUCache1 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    };

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer integer = cache.get(key);

        if (Objects.isNull(integer)) {
            return -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    @Override
    public String toString() {
        return "LRUCache1{" +
                "capacity=" + capacity +
                ", cache=" + cache +
                '}';
    }

    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(3);

        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        lruCache1.put(3, 3);

        Integer integer = lruCache1.get(1);

        lruCache1.put(4, 4);

        lruCache1.put(5, 5);
        System.out.println(lruCache1);
    }
}


