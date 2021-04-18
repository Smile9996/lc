package com.smile.lc.util;

import java.util.Arrays;

/**
 *
 */
public class C_1_简单交换排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {6,1,2,5,3,7,8,0};
        method_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method_1(int[] nums) {
        int n = nums.length;
        //int count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i+1; j < n; j ++) {
                //count ++;
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //System.out.println(count);
        return nums;
    }
}
