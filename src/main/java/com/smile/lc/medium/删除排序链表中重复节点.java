package com.smile.lc.medium;

import java.util.List;

public class 删除排序链表中重复节点 {
    public static void main(String[] args) {
        //[1,2,3,3,4,4,5]
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5,null)))))));

        ListNode listNode1 = method_1(listNode);
        System.out.println("sdf");
    }

    public static ListNode method_1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode newl = new ListNode(0, head);
        ListNode fake = newl;
        int x;
        while (fake.next != null && fake.next.next != null) {
            if (fake.next.val == fake.next.next.val) {
                x = fake.next.val;
                while (fake.next != null && x == fake.next.val) {
                    fake.next = fake.next.next;
                }
            } else {
                fake = fake.next;
            }
        }

        return newl.next;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}