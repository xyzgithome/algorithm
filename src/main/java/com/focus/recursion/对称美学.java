package com.focus.recursion;

import java.util.Scanner;

public class 对称美学 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        double[][] arr = new double[t][2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        }

        getResult(arr);
    }

    public static void getResult(double[][] arr) {
        for (double[] nk : arr) {
            System.out.println(getNK(nk[0], nk[1]));
        }
    }

    public static String getNK(double n, double k) {
        if (n == 1) {
            return "red";
        }

        if (n == 2) {
            if (k == 0) return "blue";
            else return "red";
        }

        double half = Math.pow(2, n - 2);

        if (k >= half) {
            return getNK(n - 1, k - half);
        } else {
            return "red".equals(getNK(n - 1, k)) ? "blue" : "red";
        }
    }
}
