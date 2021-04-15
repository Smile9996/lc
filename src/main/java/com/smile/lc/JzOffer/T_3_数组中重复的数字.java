package com.smile.lc.JzOffer;

import java.util.*;

public class T_3_数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3,4,5,2,5};
        method_1(nums);
        method_2(nums);
    }

    /**
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public static Set<Integer> method_1(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            }else {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 只适用于 n 个数字组成的数组，取值范围为0——n-1，否则会造成死循环
     * 时间复杂度O(n)，空间复杂度O(1)
     * 貌似已经造成死循环
     */
    public static Set<Integer> method_2(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <0 || nums[i] >= nums.length) {
                return null;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    set.add(nums[i]);
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return set;
    }
}
