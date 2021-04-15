package com.smile.lc.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 绝对差值和 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,10,4,4,2,7};
        int[] nums2 = new int[]{9,3,5,1,7,4};
        System.out.println(method(nums1, nums2));
    }

    public static int method(int[] nums1, int[] nums2) {
        // 保留两个数组的每个列上的绝对值总和
        int result = 0;
        //找出差值绝对值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums1.length; i ++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            result = (int) ((result + abs) % (Math.pow(10, 9) +7));
            map.put(i, abs);
        }
        if (result == 0) {
            return 0;
        }
        Map<Integer, Integer> sortMapByValues = sortMapByValues(map);
        Map.Entry<Integer, Integer> next = sortMapByValues.entrySet().iterator().next();
        int maxSeat = next.getKey();
        // 保留两个数相减的绝对值
        int comRe1 = Math.abs(nums1[0] - nums2[maxSeat]);
        //双指针
        for (int i=0, j=nums1.length-1; i < j ; i ++, j--) {
            if (i == maxSeat || j== maxSeat) continue;
            if (comRe1 > Math.abs(nums1[i] - nums2[maxSeat])) {
                comRe1 = Math.abs(nums1[i] - nums2[maxSeat]);
            }
            if (comRe1 > Math.abs(nums1[j] - nums2[maxSeat])) {
                comRe1 = Math.abs(nums1[j] - nums2[maxSeat]);
            }
        }
        result = (result - Math.abs(nums1[maxSeat] - nums2[maxSeat]) + comRe1);
        return result ;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }
}
