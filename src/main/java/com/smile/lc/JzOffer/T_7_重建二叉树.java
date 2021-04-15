package com.smile.lc.JzOffer;

import java.util.Arrays;

public class T_7_重建二叉树 {

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
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] mid = new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode = method_1(pre, mid);
        System.out.println("");

    }

    /**
     * 递归（传入数组的拷贝）
     */
    public static TreeNode method_1(int[] pre, int[] mid) {
        if (pre.length == 0 || mid.length == 0 || pre == null || mid == null){
            return null;
        }
        if (pre.length != mid.length) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; ++i) {
            if (pre[0] == mid[i]) {
                treeNode.left = method_1(Arrays.copyOfRange(pre,1,i+1), Arrays.copyOfRange(mid,0,i));
                treeNode.right = method_1(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i + 1, mid.length));
            }
        }
        return treeNode;
    }
}
