package com.smile.lc.medium;


public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] ints = {{1}};
        System.out.println(method_1(ints, 2));

    }

    public static boolean method_1(int[][] nums, int target) {
        int m = nums.length, n = nums[0].length;
        int i;
        // 找到target所在的行
        // 用每一行的最后一个数和target进行比较，从第一行的最后开始比较
        // 如果比target小说明在后面，如果比target说明在这一行，break
        // 若刚好找到了，返回true
        for (i = 0; i < m; i++) {
            if (nums[i][n - 1] > target) {
                break;
            } else if (nums[i][n - 1] == target) {
                return true;
            }
        }
        if (i >= m) {
            return false;
        }
        int low = 0, high = n -1;
        int mid;
        while (low <= high) {
            mid = (low + high) /2;
            if (nums[i][mid] > target) {
                high = mid - 1;
            } else if (nums[i][mid] < target) {
                low = mid + 1;
            } else {
                System.out.println("i:" + i + "\ts:" + mid);
                return true;
            }
        }
        return false;
    }
}
