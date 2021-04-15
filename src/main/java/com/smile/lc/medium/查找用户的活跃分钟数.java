package com.smile.lc.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 查找用户的活跃分钟数 {

    public static void main(String[] args) {
        int[][] logs = new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}};
        System.out.println(Arrays.toString(method_1(logs, 5)));
    }

    public static int[] method_1(int[][] logs, int k) {
        int[] answer = new int[k];
        //  ID          活跃分钟    次数
        Map<Integer, Map<Integer, Integer>> mapMap = new HashMap<>();
        for (int[] subLog : logs) {
            if (!mapMap.containsKey(subLog[0])){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(subLog[1], 1);
                mapMap.put(subLog[0], map);
            }else {
                Map<Integer, Integer> map = mapMap.get(subLog[0]);
                int key = subLog[1];
                if (!map.containsKey(key)){
                    map.put(key, 1);
                    mapMap.replace(subLog[0], map);
                }
            }
        }
        for (Integer id : mapMap.keySet()) {
            int result = 0;
            Map<Integer, Integer> map = mapMap.get(id);
            for (Integer minute : map.keySet()) {
                result += map.get(minute);
            }
            answer[result-1] += 1;
        }
        return answer;
    }
}
