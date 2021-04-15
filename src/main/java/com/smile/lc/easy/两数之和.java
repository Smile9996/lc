package com.smile.lc.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(method_1(nums, 7)));
    }

    //method_1
    public static int[] method_1(int[] nums, int target) {
        int[] mynums = nums;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<mynums.length; i++) {
            if(map.containsKey(target-mynums[i])) {
                return new int[]{i, map.get(target-mynums[i])};
            }
            map.put(mynums[i],i);
        }
        return new int[0];
    }

    //method_2
    public static int[] method_2(int[] nums, int target) {
        int[] mynums = nums;
        int[] result;
        int s = mynums.length;
        for(int i=0; i<s; i++) {
            for(int j=s-1; j>0; j--) {
                if(j==i) {
                    continue;
                }
                if(mynums[i] + mynums[j] == target){
                    result = new int[]{i,j};
                    return result;
                }
            }
        }
        return mynums;
    }
}
