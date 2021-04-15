package com.smile.lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 对称二叉树 {

    private static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        if(treeNode.left == null && treeNode.right == null) {
            System.out.println("true");
        }
        System.out.println(method_1(treeNode, treeNode));
    }

    // 不能用中序遍历，然后比较字符串和字符串的反转
    public static boolean method_1(TreeNode root, TreeNode rootFake) {
        return check(root, rootFake);
    }

    // 递归检查两个TreeNode一不一样
    public static boolean check(TreeNode root, TreeNode rootFake) {
        if (root == null && rootFake == null) {
            return true;
        }
        if (root == null || rootFake == null) {
            return false;
        }
        return root.val == rootFake.val && check(root.left, rootFake.right) && check(root.right, rootFake.left);
    }

    static class TreeNode {
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
}
