package com.smile.lc.easy;

import java.util.Arrays;

public class 采购方案 {

    public static void main(String[] args) {
        System.out.println(1000000007);
        int[] nums = new int[]{2,5,3,5};
        System.out.println(method_1(nums, 6));
    }

    public static int method_1(int[] nums, int target) {
        Arrays.sort(nums);
        int n = 0;
        int maxSeat = nums.length -1;
        while (nums[maxSeat] > target) {
            maxSeat--;
        }
        for (int i = maxSeat; i > 0; i --) {
            int j = i - 1;
            while (nums[j] + nums[i] > target) {
                j--;
                if (j < 0) break;
            }
            n = n % 1000000007 + (j + 1) % 1000000007;
        }
        return n;
    }

    //正解，双指针
    public static int method_2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = 0;
        int right = nums.length -1;
        int left = 0;
        while(left < right){
            if(nums[left] + nums[right] > target) {
                right --;
            }else{
                n = n%1000000007 + (right - left)%1000000007 ;
                left ++;
            }
        }
        return n;
    }
}
