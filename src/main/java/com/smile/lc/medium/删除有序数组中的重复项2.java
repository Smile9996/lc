package com.smile.lc.medium;

import java.util.Arrays;

public class 删除有序数组中的重复项2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,2,2,2,3,3,3,4,5};
        System.out.println(method_1(nums));
    }

    public static int method_1(int[] nums) {
        int tail = nums.length-1;

        for (int i = tail; i >= 2; i--) {
            if (nums[i] == nums[i-2]) {
                int swap = nums[i];
                nums[i] = nums[tail];
                nums[tail] = swap;
                tail--;
            }
        }
        Arrays.sort(nums,0,++tail);
        return tail;
    }
}
