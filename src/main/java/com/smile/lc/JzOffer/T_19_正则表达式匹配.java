package com.smile.lc.JzOffer;

import java.util.Scanner;

public class T_19_正则表达式匹配 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a str");
        String s = sc.next();
        System.out.println("Please enter a p");
        String p = sc.next();
        System.out.println(method_1(s, p));
    }

    public static boolean method_1(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int j = 0;  //表示源字符串位置
        for (int i = 0; i < pp.length; ++ i) {
            char P = pp[i];
            if (P == '*') {
                char pre = pp[i-1];
                if (ss[j] != pre) {
                    continue;
                }
                while (j <= ss.length-1 && ss[j] == pre) {
                    j++;
                }
            }else if (P == '.') {
                j++;
            }else {
                if (j < ss.length && ss[j] == pp[i]) {
                    j++;
                }else if (pp[i + 1] == '*'){
                    i += 1;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
