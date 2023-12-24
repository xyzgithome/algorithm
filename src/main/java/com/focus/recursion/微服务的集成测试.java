package com.focus.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class 微服务的集成测试 {
    static int[] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cache = new int[n];
        Arrays.fill(cache, -1);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        System.out.println(getResult(matrix, n, k));
    }

    public static int getResult(int[][] matrix, int n, int k) {
        return dfs(k - 1, matrix);
    }

    public static int dfs(int k, int[][] matrix) {
        // cache用于记录每个服务所需要时间，避免多个子服务依赖同一个父服务时，对父服务启动时间的重复递归求解
        if (cache[k] != -1) return cache[k];

        int[] preK = matrix[k];

        int maxPreTime = 0;
        for (int i = 0; i < preK.length; i++) {
            if (i != k && preK[i] != 0) {
                maxPreTime = Math.max(maxPreTime, dfs(i, matrix));
            }
        }

        cache[k] = matrix[k][k] + maxPreTime;

        return cache[k];
    }
}
