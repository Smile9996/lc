package com.smile.lc.JzOffer;

import java.util.Stack;

public class T_9_用两个栈实现队列 {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        appendTail(stack, 1);
        appendTail(stack, 2);
        appendTail(stack, 3);
        appendTail(stack, 4);
        Object o = deleteHead(stack);
        System.out.println(o);

    }

    public static void appendTail(Stack<Object> stack, Object e) {
        stack.push(e);
    }

    public static Object deleteHead(Stack<Object> stack) {
        Stack<Object> fakeStack = new Stack<>();
        while (!stack.empty()) {
            fakeStack.push(stack.pop());
        }
        Object e = fakeStack.pop();
        while ((!fakeStack.empty())) {
            stack.push(fakeStack.pop());
        }
        return e;
    }
}
