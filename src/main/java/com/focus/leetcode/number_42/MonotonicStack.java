package com.focus.leetcode.number_42;

import java.util.LinkedList;

/**
 * 单调递减栈
 */
public class MonotonicStack {

    private LinkedList<Integer> stack = new LinkedList<>();

    public Integer peek(){
        return stack.peekLast();
    }

    public Integer poll(){
        return stack.pollLast();
    }

    public void offer(Integer add){
        while (!stack.isEmpty() && stack.peekLast() < add) {
            stack.pollLast();
        }

        stack.offerLast(add);
    }
}
