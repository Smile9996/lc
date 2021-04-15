package com.smile.lc.easy;

public class 数字反转 {

    public static void main(String[] args) {
        int x = 123;
        System.out.println(method_1(x));
    }

    public static int method_1(int x){
        int rev = 0;
        int p = 0;
        while(x!=0){
            p = x%10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && p > 7)){
                return 0;
            }
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && p < -8)){
                return 0;
            }
            rev = rev * 10 + p;
        }
        return rev;
    }
}
