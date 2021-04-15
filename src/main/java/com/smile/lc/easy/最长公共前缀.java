package com.smile.lc.easy;

import java.util.Arrays;

public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] strings = new String[]{"floer","flosd","floight"};
        System.out.println(method_1(strings));
    }

    public static String method_1(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int shortest = getShortest(strs)[0];
        int seat = getShortest(strs)[1];
        //拿出最短的那个
        String s = strs[seat];
        String result = s;

        for (int i = shortest; i > 0; i --) {
            int count = 0;
            for (int j = 0; j < strs.length; j ++) {
                if (j == seat) {
                    continue;
                }
                if (result.equals(strs[j].substring(0, i))) {
                    result = s.substring(0, i);
                    count ++;
                    if (count == strs.length-1){
                        return result;
                    }
                }else {
                    result = s.substring(0, i-1);
                }
            }
        }
        return result;
    }

    public static int[] getShortest(String[] strs) {
        int shortest = strs[0].length();
        int seat = 0;
        for (int i = 0; i < strs.length; i ++){
            if (shortest > strs[i].length()) {
                shortest = strs[i].length();
                seat = i;
            }
        }
        return new int[]{shortest, seat};
    }
}
