package com.focus.csdn.od.阿里巴巴找黄金宝箱;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 补种未成活胡杨.png
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] ints = new int[n];
        Arrays.fill(ints, 1);
        for (int i = 0; i < m; i++) {
            ints[scanner.nextInt() - 1] = 0;
        }

        int k = scanner.nextInt();
        System.out.println(getResult(n,k, ints));
    }

    private static int getResult(int n, int k, int[] ints) {
        int maxLength = 0;
        int left = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int right = 0; right < ints.length; right++) {
            if (ints[right] == 0) {
                list.add(right);
            }

            if (list.size() > k) {
                left = list.pollFirst() + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
