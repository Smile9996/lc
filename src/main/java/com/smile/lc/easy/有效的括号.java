package com.smile.lc.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class 有效的括号 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public static void main(String[] args) {
        System.out.println(method_2("[](()){{(})}"));
    }

    public static boolean method_1(String str) {
        Map<Character, Character> map = new HashMap<Character, Character>()
        {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Deque<Character> deque = new LinkedList<>();
        deque.push(str.charAt(0));

        for (int i = 1; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (deque.isEmpty()) {
                deque.push(c);
                continue;
            }
            try {
                if (c == map.get(deque.peekFirst())) {
                    deque.pop();
                } else {
                    deque.push(c);
                }
            }catch (Exception e) {
                return false;
            }

        }

        return deque.isEmpty();
    }

    // 方法二
    // 利用栈，把括号的反括号入栈，然后再当遇到括号的反括号时出栈相比，不等就不符合要求
    // {(})
    // push('}',')')
    // pop() 为 ')' 与 '}' 不等，所以不符合要求
    public static boolean method_2(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') deque.push(')');
            else if (c == '{') deque.push('}');
            else if (c == '[') deque.push(']');
            else if (deque.isEmpty() || c != deque.pop()) return false;
        }
        return deque.isEmpty();
    }
}
