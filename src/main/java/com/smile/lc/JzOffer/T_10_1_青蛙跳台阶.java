package com.smile.lc.JzOffer;

public class T_10_1_青蛙跳台阶 {

    public static void main(String[] args) {
    }

    /**
     * 设跳上 n级 台阶有 f(n) 种跳法
     * 青蛙跳一级或者是二级，跳到n级
     * 当青蛙差最后一步跳上n级台阶时
     * 有两种可能，要么是跳1级，要么是跳2级
     * 跳1级：以前的 n-1 个有 f(n-1) 种跳法
     * 跳2级：以前的 n-2 个有 f(n-2) 种跳法
     * 所以 f(n) = f(n-1) + f(n-2)
     * 就演化成了斐波那契数列
     * f(0)=1,f(1)=1,f(2)=2
     **/
    public static int method_1(int target) {
        int oneNum = 1;
        int twoNum = 1;
        int threeNum = 0;
        for (int i = 0; i < target; ++ i) {
            threeNum = oneNum + twoNum;
            oneNum = twoNum;
            twoNum = threeNum;
        }
        System.out.println(threeNum);
        return threeNum;
    }

    /**
     * 一次可跳（n）级
     */
    public static int method_2(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
