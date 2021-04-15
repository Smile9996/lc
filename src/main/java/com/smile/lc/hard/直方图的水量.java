package com.smile.lc.hard;

public class 直方图的水量 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(method_1(nums));
    }

    public static int method_1(int[] nums) {
        int[] max_left = new int[nums.length];
        int[] max_right = new int[nums.length];

        //0,1,0,2,1,0,1,3,2,1,2,1
        // 第一列和最后一列肯定不会积水，所以i的取值范围是 1到 nums.length - 1
        for (int i = 1; i < nums.length; ++i) {
            max_left[i] = Math.max(max_left[i-1], nums[i-1]);
        }
        for (int j = nums.length -2; j >= 0; --j) {
            max_right[j] = Math.max(max_right[j+1], nums[j+1]);
        }
        int shortWall = 0;
        int result = 0;
        for (int i = 1; i < max_left.length - 1; ++i) {
            shortWall = Math.min(max_left[i], max_right[i]);
            if (shortWall > nums[i]) {
                result += shortWall - nums[i];
            }
        }
        return result;
    }
}
