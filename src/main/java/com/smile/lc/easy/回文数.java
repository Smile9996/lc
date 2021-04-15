package com.smile.lc.easy;

public class 回文数 {

    public static void main(String[] args) {
        System.out.println(method_1(12321));
    }

    //method_1
    public static boolean method_1(int x) {
        //负数不存在回文数
        if(x < 0) {
            return false;
        }
        return reverse(x)==x;
    }

    public static int reverse(int x){
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
