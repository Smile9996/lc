package com.smile.lc.medium;


import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {

    long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(2, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(4, new TreeNode(3), new TreeNode(5)));
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
//        验证二叉搜索树 test = new 验证二叉搜索树();
//        System.out.println(test.method_2(root));
        System.out.println(method_1(root, new ArrayList<>()));
    }

    // 中序遍历
    public static boolean method_1(TreeNode root, List<Integer> list) {
        inOrderTraversal(root, list);
        int minValue = Integer.MIN_VALUE;
        int count = 0;
        for (Integer i : list) {
            count ++;
            if (i == minValue && count == 1) {
                continue;
            }
            if (i > minValue) {
                minValue = i;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return true;
        }
        boolean l =  inOrderTraversal(root.left, list);
        //System.out.println(root.val);
        list.add(root.val);
        boolean r = inOrderTraversal(root.right, list);
        return l && r;
    }

    // 中序遍历 改进版， 实时判断值是否符合要求
    public boolean method_2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean l = method_2(node.left);
        if (pre >= node.val) {
            return false;
        }
        pre = node.val;
        return l && method_2(node.right);
    }

    // 利用递归，实时更新lower 和 upper，思想基本和中序遍历一样
    public static boolean method_3(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return method_3(node.left, lower, node.val) && method_3(node.right, node.val, upper);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}