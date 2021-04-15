package com.smile.lc.JzOffer;

import java.util.Arrays;

public class T_17_打印从1到最大的n位数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(6)));
    }

    public static int[] printNumbers(int n) {
        int total = (int)Math.pow(10, n) - 1;
        int[] nums = new int[total];
        for(int i = 1; i <= total; ++ i) {
            nums[i-1] = i;
        }
        return nums;
    }
}
