package com.smile.lc.medium;

import org.junit.jupiter.api.AfterEach;

public class 两数相加 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(7)));

//        try {
//            Thread.sleep(100000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //int n = getSum(listNode,1, 0) + getSum(listNode1, 1, 0);
        //method_1(listNode, listNode1);
        ListNode result = method_2(listNode, listNode1);
        System.out.println("");
    }

    // 方法可以但是不能超过int的最大数值
    public static ListNode method_1(ListNode l1, ListNode l2) {
        int n = getSum(l1,1, 0) + getSum(l2, 1, 0);
        int i;
        ListNode listNode = new ListNode(n % 10);
        ListNode fake = listNode;
        n /= 10;
        while (n != 0) {
            i = n % 10;
            fake.next = new ListNode(i);
            fake = fake.next;
            n /= 10;
        }
        return listNode;
    }
    public static int getSum(ListNode node, int i, int sum) {
        if (node != null) {
            sum += node.val * i;
        }else {
            return sum;
        }
        return getSum(node.next, i * 10, sum);
    }


    public static ListNode method_2(ListNode l1, ListNode l2) {
        int n = 0, m = 0;
        int l11, l22;
        ListNode listNode = new ListNode(0);
        ListNode fake = listNode;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l11 = l1.val;
                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    l1 = null;
                }
            } else {
                l11 = 0;
            }

            if (l2 != null) {
                l22 = l2.val;
                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    l2 = null;
                }
            } else {
                l22 = 0;
            }
            n = l11 + l22 + m;
            if (n >= 10) {
                n %= 10;
                m = 1;
            } else {
                m = 0;
            }
            fake.next = new ListNode(n);
            fake = fake.next;
        }
        if (m == 1) {
            fake.next = new ListNode(m);
        }
        return listNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val;};
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
