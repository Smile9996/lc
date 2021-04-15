package com.smile.lc.JzOffer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T_25_合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(-1))));
        ListNode l2 = new ListNode(3, new ListNode( 1, new ListNode(9, new ListNode(2))));
        method_1(l1,l2);
    }

    public static ListNode method_1(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) {
            return l2;
        }else if(l1 != null && l2 == null) {
            return l1;
        }else if(l1 == null) {
            return null;
        }
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while(l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }

        int[] nums = new int[deque1.size() + deque2.size()];
        int flag = 0;
        while(!deque1.isEmpty()) {
            nums[flag] = deque1.pop();
            flag ++;
        }
        while(!deque2.isEmpty()) {
            nums[flag] = deque2.pop();
            flag ++;
        }
        Arrays.sort(nums);
        ListNode result = new ListNode(nums[0]);
        ListNode feak = result;
        for(int i = 1; i < nums.length; ++i) {
            feak.next = new ListNode(nums[i]);
            feak = feak.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
