package com.smile.lc.JzOffer;

public class T_15_二进制中1的个数 {

    public static void main(String[] args) {
        System.out.println(method_1(111111111));
    }

    // n 以 二进制形式注入、输入
    public static int method_1(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1){
                sum ++;
            }
            n >>>= 1;
        }
        return sum;
    }
}
