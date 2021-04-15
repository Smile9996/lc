package com.smile.lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,0,0,0};
        int[] nums2 = new int[]{2,3,5};
        int[] ints = method_1(nums, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] method_1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 - n2;
//        for (int i = n, j = n1-1, k = 0, m = n2 -1; i < j; i++,j--,k++,m--) {
//            nums1[i] = nums2[k];
//            nums1[j] = nums2[m];
//        }
        for (int i = n, j = 0, t1 = n1-1, t2 = n2-1; i <= t1;i++,j++,t1--,t2--) {
            nums1[i] = nums2[j];
            nums1[t1] = nums2[t2];
        }
        Arrays.sort(nums1);
        return nums1;
    }
}
