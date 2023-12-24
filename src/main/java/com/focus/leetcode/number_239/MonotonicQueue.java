package com.focus.leetcode.number_239;

import java.util.LinkedList;

/**
 * 单调递减队列
 * 在队列头部get值，在队列尾部add值
 */
public class MonotonicQueue {

    private LinkedList<Integer> deque = new LinkedList<>();

    public Integer peek() {
        return deque.peekFirst();
    }

    public Integer poll() {
        return deque.pollFirst();
    }

    public void offer(Integer add) {
        while (!deque.isEmpty() && deque.peekLast() < add) {
            deque.pollLast();
        }

        deque.offerLast(add);
    }

    public void clear() {
        deque.clear();
    }

    public static void main(String[] args) {
        MonotonicQueue queue = new MonotonicQueue();
        for (int i : new int[]{1, 3, -1, -3, 5, 3, 6, 7}) {
            queue.offer(i);
            System.out.println(queue.deque);
        }
    }
}
