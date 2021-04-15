package com.smile.lc.JzOffer;

import java.util.Deque;
import java.util.LinkedList;

public class T_24_反转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode next = head.next;
        next.next = new ListNode(3);
        method_1(head);
    }

    public static ListNode method_1(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(0);
        ListNode feak = result;
        while (!deque.isEmpty()){
            feak.next = new ListNode(deque.pop());
            feak = feak.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
