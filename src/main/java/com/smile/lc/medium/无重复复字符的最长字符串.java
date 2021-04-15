package com.smile.lc.medium;


public class 无重复复字符的最长字符串 {

    public static void main(String[] args) {
        String s = "abcb";
        //System.out.println(method_1(s));
        System.out.println(Long.MIN_VALUE);
    }

    public static int method_1(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); ++ i) {
            for (int j = i + 1; j < s.length(); ++ j) {
                System.out.println(s.substring(i, j));
                System.out.println(s.charAt(j));
                System.out.println("_________________________________________");
                if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
                    if (max < (j-i)) {
                        max = j-i;
                    }
                    break;
                }
                if (j == s.length() - 1) {
                    max = Math.max(max, s.length() - i);
                    return max;
                }
            }
        }
        return max;
    }
}
