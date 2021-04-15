package com.smile.lc.JzOffer;

public class T_16_数值的整数次方 {

    public static void main(String[] args) {

        double x = 2.0;
        int n = -12;
        int abs = Math.abs(n);
        double result = pow(x, abs);
        if (n < 0) {
            System.out.println(1/result); // return
        }
        System.out.println(result); // return
    }

    public static double pow(double x, int n) {
        if (n == 0 || x == 0){
            return 1;
        }
        if (x == 1) {
            return x;
        }
        double result = pow(x, n >>> 1);
        result *= result;
        if ((n & 0x1) == 1) {
            return result * x;
        }
        return result;
    }
}
