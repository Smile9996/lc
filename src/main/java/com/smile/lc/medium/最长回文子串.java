package com.smile.lc.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "cccc";
        System.out.println(method_1(s));
    }

    // 错误的方法，要用到dp
    public static String method_1(String s) {
        if ("".equals(s) || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        Map<Integer, Integer> map1 = new ConcurrentHashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            int j = 1;
            while (i-j >= 0 && i + j < chars.length) {
                if (chars[i - j] == chars[i + j]) {
                    ++j;
                }else {
                    break;
                }
            }
            int k = i;
            int m = i+1;
            while (k >=0 && m < chars.length) {
                if (chars[k] == chars[m]) {
                    k--;
                    m++;
                }else {
                    break;
                }
            }
            // key代表的是中间的两边（不包括中间那个元素）有多宽，比如abcba，c就是中间，宽度就是2，value就是中间那个元素的位置
            if (j != 1) {
                map.put(j-1, i);
            }
            // key 代表的是长度，value代表的是字符串开始的位置
            if (k != i && m != i+1) {
                map1.put(m - k - 1, i);
            }
        }
        String substring = "";
        if (map.size() > 0) {
            Object[] values = map.keySet().toArray();
            Arrays.sort(values);
            int max = (int) values[values.length - 1];
            substring = s.substring(map.get(max) - max, map.get(max) + max + 1);
        }
        String substring1 = "";
        if (map1.size() > 0) {
            Object[] values1 = map1.keySet().toArray();
            Arrays.sort(values1);
            int max1 = (int) values1[values1.length - 1];
            substring1 = s.substring(map1.get(max1) - max1/2 + 1, map1.get(max1) + max1);
        }
        return substring.length() > substring1.length() ? substring : substring1;
    }
}
