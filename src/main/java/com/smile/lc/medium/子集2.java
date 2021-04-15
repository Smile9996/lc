package com.smile.lc.medium;

import java.util.*;

public class 子集2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,3,2,3};
        Arrays.sort(nums);
        method_1(nums);
    }

    public static List<List<Integer>> method_1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int mask = 0; mask < 1<<n; mask ++) {
            t.clear();
            for (int i = 0; i < n; i ++) {
                if ((mask & 1 << i) != 0) {
                    t.add(nums[i]);
                }
            }
            if (map.containsKey(Arrays.toString(t.toArray()))){
                continue;
            }else {
                map.put(Arrays.toString(t.toArray()),"");
            }
            result.add(new ArrayList<>(t));
        }

        return result;
    }
}
