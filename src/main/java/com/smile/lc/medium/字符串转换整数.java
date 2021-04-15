package com.smile.lc.medium;

public class 字符串转换整数 {

    public static void main(String[] args) {
        String s = "-000000000000000000000000000000000000000000000000001";
        System.out.println(method_1(s));
    }

    public static int method_1(String s) {
        int pre = 0;
        int last = 0;
        if (s.length() == 1) {
            return "123456789".contains(s)? Integer.parseInt(s):0;
        }

        for (int i = 0; i < s.length(); i ++) {
            if (!" +-0123456789".contains(String.valueOf(s.charAt(i)))) return 0;
            if ((s.charAt(i) == '+' && !"0123456789".contains(String.valueOf(s.charAt(i+1)))) || (s.charAt(i) == '-' && !"0123456789".contains(String.valueOf(s.charAt(i+1)))) ){
                return 0;
            }
            if ("0123456789".contains(String.valueOf(s.charAt(i)))) {
                pre = i;
                while (i < s.length() && "0123456789".contains(String.valueOf(s.charAt(i)))) {
                    i++;
                }
                last = i;
                break;
            }
        }
        if (pre==last) {
            return 0;
        }
        long l=Long.MAX_VALUE;
        try {
            l = Long.parseLong(s.substring(pre, last));
        }catch (Exception e) {
            //l = Long.MAX_VALUE;
        }
        if (pre > 0 && "-".equals(String.valueOf(s.charAt(pre-1)))) {
            l = -l;
        }
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }else if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l;
    }
}
