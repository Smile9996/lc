package com.smile.lc.JzOffer;

public class T_53_最大子序和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(method_1(nums));
    }

    //状态转移方程
    //f(i) = max(f(i-1) + n[i], n[i])
    public static int method_1(int[] nums) {
        int[] f = new int[nums.length+1];
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < nums.length; ++i) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
