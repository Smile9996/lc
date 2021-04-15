package com.smile.lc.medium;

import java.util.*;
import java.util.stream.Collectors;

public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] ints = method_1(new int[]{1, 2, 4, 3, 5, 1, 2, 3, 5, 6}, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] method_1(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> map1 = sortMapByValues(map);
        int[] result = new int[k];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (count < k) {
                result[count] = entry.getKey();
                count ++;
            }
        }
        return result;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }

    // 还可以用堆解····
}
