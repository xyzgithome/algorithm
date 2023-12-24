package com.focus.recursion;

import java.util.Scanner;

public class 分糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLong()));
    }

    public static long getResult(long num) {
        int[] ans = {Integer.MAX_VALUE};
        recursive(num, 0, ans);
        return ans[0];
    }

    public static void recursive(long num, int count, int[] ans) {
        if (num == 1) {
            ans[0] = Math.min(ans[0], count);
            return;
        }

        if (num % 2 == 0) {
            recursive(num / 2, count + 1, ans);
        } else {
            recursive(num + 1, count + 1, ans);
            recursive(num - 1, count + 1, ans);
        }
    }
}