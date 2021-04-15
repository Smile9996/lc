package com.smile.lc.JzOffer;

public class T_18_1_删除链表重复的节点 {

    public static void main(String[] args) {

    }

    public static ListNode method_1(ListNode head) {
        ListNode feak = head;
        while(head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return feak;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
