package com.smile.lc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,7,9};
        int[] nums2 = new int[]{2,4,6,8,10};
        int[] nums3 = new int[]{0,2,3,4,8};
        List<int[]> list = new ArrayList<>();
        list.add(nums1);
        list.add(nums2);
        list.add(nums3);
        List<int[]> list1 = method_1(list);
        Object[] objects = list1.toArray();
        System.out.println(Arrays.toString(objects));
    }

    public static List<int[]> method_1(List<int[]> list) {
        int n = list.size();
        if ( n == 1) {
            return list;
        }
        for (int i = 0; i < n; i += 2) {
            int[] nums1 = list.remove(0);
            int[] nums2 = list.remove(0);
            int[] ints = Arrays.copyOf(nums1, nums1.length + nums2.length);
            System.arraycopy(nums2, 0 , ints, nums1.length, nums2.length);
            Arrays.sort(ints);
            list.add(ints);
        }
        return method_1(list);
    }
}
