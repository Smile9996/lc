package com.smile.lc.medium;


import java.util.*;

public class 模式132 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,4,5,3};
        System.out.println(method_1_1(nums));
        TreeMap<Integer, Integer> rightAll = new TreeMap<>(Comparator.naturalOrder());

        for (int k = 2; k < nums.length; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }
        System.out.println(rightAll);
    }

    public static boolean method_1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        for (int first = 0; first < n; first ++ ) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            for (int second = first + 1; second < n; second ++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                int third = n - 1;
                while (second < third) {
                    if (nums[first] < nums[third] && nums[third] < nums[second]) {
                        System.out.println(nums[first] + "\t" + nums[second] + "\t" + nums[third]);
                        return true;
                    }
                    --third;
                }
            }
        }
        return false;
    }

    public static boolean method_1_1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        for (int first = 0; first < n; first ++ ) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            for (int second = first + 1; second < n; second ++) {
                if ((second > first + 1 && nums[second] == nums[second - 1]) || nums[second] < nums[first]) {
                    continue;
                }
                int third = n - 1;
                while (second < third || nums[second] > nums[third]) {
                    if (nums[first] < nums[third] && nums[third] < nums[second]) {
                        System.out.println(nums[first] + "\t" + nums[second] + "\t" + nums[third]);
                        return true;
                    }
                    --third;
                }
            }
        }
        return false;
    }

    public static boolean method_2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // 假设j的下标从1开始，那么左面就一个数，即为最小数
        int leftMin = nums[0];
        for (int k = 2; k < n; k++) {
            //统计key出现的次数，归并
            treeMap.put(nums[k], treeMap.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; j ++) {
            if (leftMin < nums[j]) {
                Integer key = treeMap.ceilingKey(leftMin + 1);
                if (key != null && key < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            treeMap.put(nums[j + 1], treeMap.get(nums[j + 1]) - 1);
            if (treeMap.get(nums[j + 1]) == 0) {
                treeMap.remove(nums[j + 1]);
            }
        }

        return false;
    }

    public static boolean method_3(int[] nums) {

        int n = nums.length;

        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[n - 1]);
        // 用 mask 来标记2
        int mask = Integer.MIN_VALUE;

        for (int i = n - 2; i > 0; i ++) {
            // 判断这个数能不能当1
            if (nums[i] < mask) {
                return true;
            }

            // 将现在的数与栈顶的数进行比较，如果比它打的话，就出栈，并且赋值给2，这样mask一直是最大的
            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                mask = deque.pop();
            }

            // 如果这个数比2大，则可能是2的候选元素，放入栈中备用，大的永远都在最底下
            if (nums[i] > mask) {
                deque.push(nums[i]);
            }
        }
        return false;
    }
}
