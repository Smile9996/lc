package com.smile.lc.JzOffer;

public class T_14_剪绳子 {

    public static void main(String[] args) {

    }

    public static int method_1(int n) {
        int oneMNum = 1;
        int towMNum = 1;
        int threeMNum = 2;
        for (int i = 4; i <= n; ++i) {
            threeMNum = oneMNum + towMNum;
            oneMNum = towMNum;
            towMNum = threeMNum;
        }
        return threeMNum;
    }
}
