package com.smile.lc.medium;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public static List<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        method_1(root);
        return;
    }
    
    public static void method_1(TreeNode root) {
        if (root == null) {
            return;
        }
        method_1(root.left);
        list.add(root.val);
        method_1(root.right);
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
