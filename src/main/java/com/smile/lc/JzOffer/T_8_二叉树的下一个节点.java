package com.smile.lc.JzOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T_8_二叉树的下一个节点 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
    }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(6, new TreeNode(7), new TreeNode(8)));
        List<Integer> list = new ArrayList<>();
        method_1(root, list);
        Object[] objects = list.toArray();
        int target = 5;
        for (int i = 0; i < objects.length; i ++) {
            if (target == (int) objects[i]) {
                System.out.println(objects[i+1]);
            }
        }

    }

    public static void method_1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        method_1(root.left, list);
        //System.out.println(root.val);
        list.add(root.val);
        method_1(root.right, list);
    }

}
