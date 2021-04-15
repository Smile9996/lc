package com.smile.lc.medium;

import java.util.Arrays;

public class 不同路径 {

    public static int y, x;
    public static Integer k = 0;
    public static void main(String[] args) {
        System.out.println(method_1(23,12));
        System.out.println(method_2(23, 12));
        System.out.println(method_3(23, 12));
    }

    // 排列组合
    public static int method_1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    // method_3的优化，借鉴力扣
    public static int method_2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    // 动态规划
    public static int method_3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) dp[i][0] = 1;
        for (int j = 0; j < n; j ++) dp[0][j] = 1;
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
