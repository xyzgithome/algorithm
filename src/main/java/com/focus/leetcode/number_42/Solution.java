package com.focus.leetcode.number_42;

import java.util.LinkedList;
import java.util.Objects;

public class Solution {

    /**
     * 1. 维护一个单调栈
     * 2. 当加入一个新元素，如果发现需要弹出元素表示遇到了凹陷的位置，此时需要计算雨水的容量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        LinkedList<Data> stack = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            Data right = new Data(height[i], i);

            while (!stack.isEmpty()
                    && stack.peekLast().getHeight() < right.getHeight()) {
                Data poll = stack.pollLast();
                Data left = stack.peekLast();

                if (Objects.nonNull(left)){
                    // 计算水的容量
                    int width = right.getI() - left.getI() - 1;
                    int high = Math.min(right.getHeight(), left.getHeight())
                            - Objects.requireNonNull(poll).getHeight();

                    sum += width * high;
                }
            }
            stack.addLast(right);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.trap(ints));
    }

}
