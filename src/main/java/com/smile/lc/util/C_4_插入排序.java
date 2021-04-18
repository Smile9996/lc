package com.smile.lc.util;

import java.util.Arrays;

/**
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
public class C_4_插入排序 {

    public static void main(String[] args) {
        int[] nums = new int[] {6,1,2,5,3,7,8,0};
        method_1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] method_1(int[] nums) {
        int n = nums.length;
        int j;
        for (int i = 1; i < n; ++ i) {
            if (nums[i] < nums[i-1]) {
                int sentinel = nums[i];
                for (j = i - 1; j >= 0 && nums[j] > sentinel; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = sentinel;
            }
        }
        return nums;
    }
}
