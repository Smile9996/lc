package com.smile.lc.JzOffer;

public class T_18_删除链表的节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode next = head.next;
        next.next = new ListNode(3);
        method_1(head, 2);
        System.out.println("");
    }

    public static ListNode method_1(ListNode headRoot, int k) {
        if (headRoot.val == k) {
            return headRoot.next;
        }
        ListNode head = headRoot;
        ListNode feak = headRoot.next;
        while(feak.next != null && feak.val != k) {
            head = feak;
            feak = feak.next;
        }
        head.next = feak.next;
        return headRoot;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
