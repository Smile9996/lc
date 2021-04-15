package com.smile.lc.easy;

import java.util.Arrays;

public class 移动零 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0};
        System.out.println(Arrays.toString(method_2(nums)));
    }

    //此方法不可取，太慢
    public static int[] method_1(int[] nums) {
        for (int i = nums.length - 1; i >= 0; --i) {
            move(nums, i);
        }
        return nums;
    }

    public static void move(int[] nums, int i) {
        if (i == nums.length - 1) {
            return;
        }
        if (nums[i] == 0) {
            nums[i] = nums[i+1];
            nums[i+1] = 0;
        }
        move(nums, i+1);
    }

    public static int[] method_2(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp = i;
                while (nums[tmp] == 0 && tmp < nums.length -1) {
                    tmp++;
                }
                nums[i] = nums[tmp];
                nums[tmp] = 0;
            }
            if (tmp == nums.length-1){
                break;
            }
        }
        return nums;
    }


}
