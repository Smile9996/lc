package com.smile.lc.JzOffer;

import java.util.Arrays;

public class T_4_二维数组中的查找 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2,  8,  9},
                {2, 4,  9,  12},
                {4, 7,  10, 13},
                {6, 8,  11, 15}
        };
        for (int[] n: nums) {
            for (int i : n) {
                System.out.println(method_3(nums, i));
            }
        }
    }

    /**
     * 二分法只适用于每一行的最后一个都比下一行的第一个元素小
     *  {1, 2,  8,  9},
     *  {2, 4,  9,  12},
     *  {4, 7,  10, 13},
     *  {6, 8,  11, 15}
     *  上面这种就不适合
     */
    public static boolean method_1(int[][] nums, int target) {
        int low = 0, high = nums.length * nums[0].length - 1;
        int col = nums[0].length;
        while (low < high) {
            int mid = (low + high) / 2;
            int value = nums[mid % col][mid % col];
            if (value == target) {
                return true;
            }else if (value >target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 递归方法也只适合和 method_1 相同的情况
     * @param nums
     * @param target
     * @return
     */
    public static boolean method_2(int[][] nums, int target) {
        return find(nums, target, 0, 0);
    }

    public static boolean find(int[][] nums, int target, int i, int j) {
        if (i<0 || i>nums.length - 1 || j < 0 || j > nums[0].length - 1) {
            return false;
        }
        if (nums[i][j] == target) {
            return true;
        }else if (target < nums[i][j]) {
            return find(nums, target, --i, j) || find(nums, target, i, --j);
        }else {
            return find(nums, target, ++i, ++j);
        }
    }

    /**
     * 还是用自己的方法吧
     * 就是从右上角一直到左下角或者从左下角一直到右上角
     * 因为这条线上每个元素，上面的比自己小，下面的比自己大
     */
    public static boolean method_3(int[][] nums, int target) {
        int i = 0, j = nums[0].length - 1;
        return find_3(nums, target, i, j);
    }

    public static boolean find_3(int[][] nums, int target, int i, int j) {
        if (i > nums.length - 1 || j < 0)
            return false;
        if (nums[i][j] == target)
            return true;
        if (nums[i][j] < target)
            return find_3(nums, target, ++i, j);
        else if (nums[i][j] > target)
            return find_3(nums, target, i, --j);
        return false;
    }
}
