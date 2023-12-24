package com.focus.leetcode.number_239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 滑动窗口最大值
 */
public class Number_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        int[] results = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 检查队列头部元素是否超过滑动窗口范围，如果超过要移除
            if (i >= k && queue.peek() == nums[i-k]) {
                queue.poll();
            }

            queue.offer(nums[i]);

            if (i + 1 >= k) {
                results[i + 1 - k] = queue.peek();
            }
        }
        return results;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> inputList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            lists.add(inputList.subList(i, i + k));
        }

        List<Integer> resultList = new ArrayList<>();
        MonotonicQueue queue = new MonotonicQueue();
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                queue.offer(integer);
            }
            resultList.add(queue.peek());
            queue.clear();
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Number_239 o = new Number_239();
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] ints = {7,2,4};
        int k = 3;

        int[] results = o.maxSlidingWindow(ints, k);

        System.out.println(Arrays.toString(results));
    }

}
