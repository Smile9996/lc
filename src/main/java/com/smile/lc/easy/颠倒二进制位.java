package com.smile.lc.easy;

public class 颠倒二进制位 {

    public static void main(String[] args) {
        String s = "00111100101000110101110010101110";
        Integer integer = Integer.valueOf(s, 2);
        System.out.println(method_1(integer));
    }

    /**
     * 思路大概是
     * 每次取出源二进制的最后一位(n & 1)，并将取出的该数向左移位31-该数从左到右所在位置i（从零开始）
     * 这样倒数第一个数就会变成正数第一个数
     * 倒数第二个就会变成正数第二个
     * n每次被取出最后一位后都要逻辑右移一位
     * 直到 n = 0 为止
     *
     * 每次得到的结果依次和上一次的结果进行或运算，这样保留了上一次翻转的二进制数
     * 如 1001 0111
     * 第一次 result = 0 | 1000 0000 = 1000 0000
     * 第二次 result = 1000 0000 | 0100 0000 = 11000000
     * 当然也可以直接相加
     */
    public static int method_1(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i ++) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
