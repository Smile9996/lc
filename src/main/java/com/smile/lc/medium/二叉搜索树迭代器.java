package com.smile.lc.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉搜索树迭代器 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(root);
    }


    static class BSTIterator {
        public Deque<Integer> deque;
        public BSTIterator(TreeNode root) {
            deque = new LinkedList<>();
            inOrderTraversal(root, deque);
        }

        public int next() {
            return deque.pollLast();
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        public void inOrderTraversal(TreeNode root, Deque<Integer> deque) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left, deque);
            deque.push(root.val);
            inOrderTraversal(root.right, deque);
        }
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
