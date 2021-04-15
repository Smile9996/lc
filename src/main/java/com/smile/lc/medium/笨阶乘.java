package com.smile.lc.medium;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 笨阶乘 {

    public static void main(String[] args) throws ScriptException {
        long time;
        System.out.println(time = new Date().getTime());
        System.out.println(method_1(4567));
        long time1 = new Date().getTime();
        System.out.println(time1 - time);
        System.out.println(method_2(4567));
        //System.out.println(13*12/11+10-9*8/7+6-5*4/3+2-1);
        System.out.println(new Date().getTime() - time1);
    }

    // 可行，但严重超时，所以还是不可行
    public static int method_1(int N) throws ScriptException {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("*");
        deque.offerLast("/");
        //deque.offerLast("+");
        deque.offerLast("-");
        StringBuffer stringBuffer = new StringBuffer();
        int[] sum = new int[N/4];
        for (int n = N, i = 1, count = 1; n > 0; n --, count ++) {
            if (count % 4 == 0) {
                sum[i - 1] = n;
                i ++;
                continue;
            }
            String operation = deque.pollFirst();
            stringBuffer.append(n).append(operation);
            deque.offerLast(operation);
        }
        String result = stringBuffer.toString().substring(0, stringBuffer.toString().length()-1);
        String[] split = result.split("-");
        int[] v = new int[split.length + 1];
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        int res = 0;
        for (int i = 0; i < split.length; i ++) {
            v[i + 1] = ((Double) jse.eval("Number(" + split[i] + ")")).intValue();
            res -= v[i+1];
        }
        res += 2* v[1];
        for (int j : sum) {
            res += j;
        }
        return res;
    }

    public static int method_2(int N) throws ScriptException {
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        while (N > 0) {
            switch (i % 4) {
                case 0:
                    if (i == 0) {
                        deque.push(N);
                        break;
                    }
                    deque.push(-N);
                    break;
                case 1:
                    deque.push(deque.pop() * N);
                    break;
                case 2:
                    deque.push(deque.pop() / N);
                    break;
                case 3:
                    deque.push(N);
                    break;
            }
            i ++;
            N --;
        }
        int res = 0;
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }

    // 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
    // 12 * 11 / 10 + 9 - 8 * 7 / 6 + 5 - 4 * 3 / 2 + 1
}
