package com.smile.lc.JzOffer;

public class T_5_替换空格 {
    public static void main(String[] args) {
        String s = "We are happy.";
        //System.out.println(s.replace(" ", "%20"));
        System.out.println(method_1(s));
    }

    //利用StringBuilder
    public static String method_1(String s) {
        if (s.length() <=0) return "";
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s2 : s1) {
            sb.append(s2).append("%20");
        }
        return sb.substring(0, sb.length() - 3);
    }
}
