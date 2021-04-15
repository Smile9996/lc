package com.smile.lc.JzOffer;

public class T_11_旋转数组的最小数字 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6,7,8,1,2};
        System.out.println(method_2(nums));
    }

    //利用左右的下表
    public static int method_1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[right]) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static int method_2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
