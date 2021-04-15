package com.smile.lc.JzOffer;

public class T_6_从尾到头打印链表 {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
        method_1(head);
    }

    public static void method_1(ListNode head) {
        if (head == null) {
            return;
        }
        method_1(head.next);
        System.out.println(head.val); // 这里可替换成加入数组或者入栈，入队列，etc..
    }

}
