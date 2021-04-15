package com.smile.lc.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 旋转链表 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));


        ListNode listNode1 = method_2(listNode, 6);
        System.out.println("");
    }

    // 方法一：用一个栈和一个队列操作
    // 思路：把要放到前面的节点，从后面一个一个压入栈底，这样栈顶就是第一个节点，然后再一个一个出栈
    // 再把原来的出栈剩下的当作一个队列，从队尾开始移出
    // 对于Deque来说，栈顶是队首，栈底是队尾
    public static ListNode method_1(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode newH = head;
        Deque<Integer> deque = new LinkedList<>();
        Deque<Integer> deque1 = new LinkedList<>();
        while(newH != null) {
            deque.push(newH.val);
            newH = newH.next;
        }
        k = k % deque.size();
        if(k == 0) {
            return head;
        }
        for (int i = 0; i < k; i ++) {
            Integer pop = deque.pop();
            deque1.push(pop);
        }
        ListNode newL = new ListNode(0);
        ListNode feak = newL;
        while (!deque1.isEmpty()) {
            feak.next = new ListNode(deque1.pop());
            feak = feak.next;
        }
        while (!deque.isEmpty()) {
            feak.next = new ListNode(deque.pollLast());
            feak = feak.next;
        }
        return newL.next;
    }

    // 方法二：借鉴力扣
    // 主要思路就是把原来的链表构造成一个环，然后再适当的位置断开，就可以构造出一个新的满足要求的链表
    public static ListNode method_2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode newL = head;
        int n = 1;
        // 统计多少个节点
        while (newL.next != null) {
            newL = newL.next;
            n ++;
        }
        if (k % n == 0) {
            return head;
        }
        newL.next = head;
        n = n - k % n;
        ListNode iter = newL;
        // 判断断开的位置，设置当前位置为要断开的链的前一个节点（3456123456···），iter.val = 3
        while (n-- > 0) {
            iter = iter.next;
        }
        // 然后把iter.next 的即要断开链的后一个节点作为头创建一个新的链表（45612345612···）
        ListNode newHead = iter.next;
        // 这时候 iter 指向 3，座椅只要把3后面的断了，环就断了，就剩456123了
        iter.next = null;
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

