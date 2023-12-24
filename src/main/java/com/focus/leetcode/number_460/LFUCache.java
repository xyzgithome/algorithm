package com.focus.leetcode.number_460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    /**
     * key是缓存的key，value是一个node
     */
    private Map<Integer, Node> kvMap = new HashMap<>();

    /**
     * key是缓存的使用频度，value是一个由Node组成的双向链表
     */
    private Map<Integer, DoubleLinkList> freqMap = new HashMap<>();

    /**
     * 缓存容量
     */
    private int capacity;

    /**
     * 缓存使用的最小频度
     */
    private int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }

        Node node = kvMap.get(key);

        // 将节点频度+1，从旧链表转移至新链表
        freqMap.get(node.freq).remove(node);
        if (freqMap.get(node.freq).isEmpty() && node.freq == minFreq) {
            minFreq++;
        }

        node.freq++;

//        DoubleLinkList doubleLinkList = freqMap.get(node.freq);
//        if (doubleLinkList == null){
//            doubleLinkList = new DoubleLinkList();
//            freqMap.put(node.freq, doubleLinkList);
//        }
//
//        doubleLinkList.pushFirst(node);
        freqMap.computeIfAbsent(node.freq, v -> new DoubleLinkList()).pushFirst(node);

        return node.value;
    }

    /**
     * 更新：将节点的value更新，增加节点的使用频度，将其转移到频度+1的链表中
     *
     * 新增：检查是否超过容量, 若超过，淘汰minFreq链表的最后节点
     * 创建新节点，放入kvMap，并加入频度为1的双向链表中
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 更新
        if (kvMap.containsKey(key)) {
            Node node = kvMap.get(key);
            // 将原有频度的node删除
            freqMap.get(node.freq).remove(node);

            if (freqMap.get(node.freq).isEmpty() && node.freq == minFreq) {
                minFreq++;
            }
            node.freq++;

            freqMap.computeIfAbsent(node.freq, v -> new DoubleLinkList()).pushFirst(node);

            node.value = value;
            return;
        }

        // 新增
        // 超过容量, 删除minFreq链表的最后节点
        if (kvMap.size() + 1 > capacity) {
            Node lastNode = freqMap.get(minFreq).pollLast();
            kvMap.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        node.freq = 1;
        kvMap.put(key, node);
        freqMap.computeIfAbsent(1, v -> new DoubleLinkList()).pushFirst(node);
        minFreq = 1;
    }


    static class Node {
        private Node prev;
        private Node next;
        private Integer key;
        private Integer value;
        private Integer freq;

        public Node() {
        }

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleLinkList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleLinkList() {
            // 哨兵节点
            head = tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        // 头部新增
        public void pushFirst(Node node) {
            Node oldFirst = head.next;
            node.next = oldFirst;
            node.prev = head;
            head.next = node;
            oldFirst.prev = node;
            size++;
        }

        // 已知节点删除
        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        // 尾部删除
        public Node pollLast() {
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
