package com.smile.lc.JzOffer;


import java.util.Deque;
import java.util.LinkedList;

public class T_22_链表中倒数第k个节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(method_1(head, 4));
    }

    public static ListNode method_1(ListNode head, int k) {
        Deque<Integer> deque = new LinkedList<>();
        while(head != null) {
            deque.push(head.val);
            head = head.next;
        }
        ListNode result = new ListNode(0);
        ListNode feak = result;
        int l = deque.size();
        for (int i = 0; i < l - k; i ++){
            deque.removeLast();
        }
        while(!deque.isEmpty()){
            feak.next = new ListNode(deque.removeLast());
            feak = feak.next;
        }
        return result.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next =next;
        }
    }
}
