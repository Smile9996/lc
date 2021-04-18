package com.smile.lc.util;

import java.util.Arrays;

public class C_3_简单选择排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {6,1,2,5,3,7,8,0};
        method_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method_1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++ i) {
            int min = i;
            for (int j = i + 1; j < n; ++ j) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }
}
