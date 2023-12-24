package com.focus.leetcode.number_146;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/lru-cache/
 *
 * least recently used
 */
public class LRUCache {
    private int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final DoubleLinkList doubleLinkList = new DoubleLinkList();


    static class Node {
        private Node prev;
        private Node next;
        private Integer key;
        private Integer value;

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
        }

        // 已知节点删除
        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // 尾部删除
        public Node pollLast() {
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取元素
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        doubleLinkList.remove(node);
        doubleLinkList.pushFirst(node);
        return node.value;
    }

    /**
     * 修改或新增元素
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 修改
        if (map.containsKey(key)) {
            Node node = map.get(key);
            doubleLinkList.remove(node);
            node.value = value;
            doubleLinkList.pushFirst(node);
            return;
        }

        // 新增
        Node node = new Node(key, value);
        doubleLinkList.pushFirst(node);
        map.put(key, node);

        if (map.size() > capacity) {
            Node lastNode = doubleLinkList.pollLast();
            map.remove(lastNode.key);
        }
    }
}


