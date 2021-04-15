package com.smile.lc.JzOffer;

public class T_10_斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(method_2(4));
    }
    //求第n项
    public static int method_1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return method_1(n -1) + method_1(n - 2);
    }

    //近似动态规划，从f1开始算,不是fn = fn-1 + fn-2
    public static long method_2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long numOne = 1;
        long numTwo = 0;
        long numN = 0;
        for (int i = 2; i <= n; ++ i) {
            numN = numOne + numTwo;
            numTwo = numOne;
            numOne = numN;
        }
        return numN;
    }

    //动态规划

}
