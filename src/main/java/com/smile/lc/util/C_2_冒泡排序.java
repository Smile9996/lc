package com.smile.lc.util;

import java.util.Arrays;

public class C_2_冒泡排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {6,1,2,5,3,7,8,0};
        method_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method_1(int[] nums) {
        int n = nums.length;
        // n个元素需要迭代n-1次
        for (int j = 0; j < n - 1; ++ j) {
            for (int i = 0; i < n-1; ++i) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }
}
