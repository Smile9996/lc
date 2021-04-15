package com.smile.lc.JzOffer;

public class T_15_1_判断一个整数是否是2的整数次方 {

    public static void main(String[] args) {

    }

    public static boolean method_1(int n) {
        return (n & (n - 1)) == 0;
    }
}
