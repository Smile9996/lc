package com.smile.lc.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] days = new int[]{7,1,4,3,1};
        System.out.println(method_1(days));
    }

    public static int method_1(int[] days) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int day : days) {
            if (min > day) {
                min = day;
            }
            if (max < day - min) {
                max = day - min;
            }
        }
        return max;
    }
}
