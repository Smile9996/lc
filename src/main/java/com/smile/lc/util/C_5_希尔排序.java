package com.smile.lc.util;

import java.util.Arrays;

/**
 * 希尔排序适用于基本有序数组（大的基本在后面，小的基本在前面)
 * 需要定义一个增量序列
 * 时间复杂度：O(n^3/2)
 */
public class C_5_希尔排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {6,1,2,5,3,7,8,0};
        method_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method_1(int[] nums) {
        int n = nums.length;
        int increment = n;
        for (increment = n/2; increment > 0; increment/=2) {
            //从increment 开始 逐个对其所在的组进行排序
            for (int i = increment; i < n; ++i) {
                int j = i;
                int temp = nums[j];
                if (temp < nums[j - increment]) {
                    while (j - increment >= 0 && nums[j - increment] > temp) {
                        nums[j] = nums[j - increment];
                        j -= increment;
                    }
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
}
