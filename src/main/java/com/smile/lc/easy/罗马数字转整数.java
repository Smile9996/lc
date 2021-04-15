package com.smile.lc.easy;

public class 罗马数字转整数 {

    public static void main(String[] args) {
        String s = "XXII";
        System.out.println(method_2(s));
    }

    //method_1
    public static int method_1(String s){
        String[] strings = s.split("");
        int result=0;
        for (int i = 0;i < strings.length; i++) {
            switch (strings[i]) {
                case "I":
                    if (i < strings.length -1 && strings[i+1].equals("V")) {
                        result += 4;
                        i += 1;
                    } else if (i < strings.length -1 && strings[i+1].equals("X")) {
                        result += 9;
                        i += 1;
                    } else {
                        result += 1;
                    }
                    break;
                case "V":
                    result += 5;
                    break;
                case "X":
                    if (i < strings.length -1 && strings[i+1].equals("L")) {
                        result += 40;
                        i += 1;
                    } else if (i < strings.length -1 && strings[i+1].equals("C")) {
                        result += 90;
                        i += 1;
                    } else {
                        result += 10;
                    }
                    break;
                case "L":
                    result += 50;
                    break;
                case "C":
                    if (i < strings.length -1 && strings[i+1].equals("D")) {
                        result += 400;
                        i += 1;
                    } else if (i < strings.length -1 && strings[i+1].equals("M")) {
                        result += 900;
                        i += 1;
                    } else {
                        result += 100;
                    }
                    break;
                case "D":
                    result += 500;
                    break;
                case "M":
                    result += 1000;
                    break;
                default:
                    return 0;
            }
        }
        return result;
    }


    /**
     *
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     */
    //method_2
    public static int method_2(String s){
        int prenum = getNum(s.charAt(0));
        int result = 0;
        for (int i=1; i < s.length(); i++) {
            if (prenum < getNum(s.charAt(i))){
                result -= prenum;
            } else {
                result +=prenum;
            }
            prenum = getNum(s.charAt(i));
        }
        result += prenum;
        return result;
    }
    public static int getNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
