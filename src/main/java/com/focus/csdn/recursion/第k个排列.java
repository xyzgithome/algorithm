package com.focus.csdn.recursion;

import java.util.Arrays;

import java.util.Scanner;

public class 第k个排列 {
    static int[] fact;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        fact = new int[n + 1];
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;

        System.out.println(getNK(n, k, arr));
    }

    public static String getNK(int n, int k, int[] arr) {
        if (n == 1) return "1";

        int f = fact[n - 1];
        int prefix = arr[(k - 1) / f];
        k %= f;
        k = k == 0 ? f : k;

        arr = Arrays.stream(arr).filter(ele -> ele != prefix).toArray();

        if (k == 1) {
            StringBuilder sb = new StringBuilder();
            for (int v : arr) sb.append(v);
            return prefix + sb.toString();
        } else {
            return prefix + getNK(n - 1, k, arr);
        }
    }
}