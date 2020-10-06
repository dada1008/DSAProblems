package com.opensource.dada.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
    /* Constructed binary tree is
           1
         /   \
       2      3
      / \    / \
     4   5  6   7
    / \
   8   9
    */
        /* Inverted binary tree is
               1
             /   \
           3      2
          / \    / \
         7   6  5   4
                   / \
                  9   8
         Inorder: 7 3 6 1 5 2 9 4 8
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.left.left = new TreeNode<>(8);
        root.left.left.right = new TreeNode<>(9);
        invertBinaryTreeIterative(root);
        TreeTraversals.inOrder(root);
    }

    public static void test2() {
    /* Constructed binary tree is
           1
         /   \
       2      3
      / \    / \
     4   5  6   7
    / \
   8   9
    */
        /* Inverted binary tree is
               1
             /   \
           3      2
          / \    / \
         7   6  5   4
                   / \
                  9   8
         Inorder: 7 3 6 1 5 2 9 4 8
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.left.left = new TreeNode<>(8);
        root.left.left.right = new TreeNode<>(9);
        invertBinaryTreeRecursive(root);
        TreeTraversals.inOrder(root);
    }

    static void invertBinaryTreeIterative(TreeNode<Integer> root) {

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();
            if (current==null) {
                continue;
            }
            TreeNode<Integer> left = current.left;
            TreeNode<Integer> right = current.right;
            current.left = right;
            current.right = left;
            if (right!=null) {
                queue.offer(right);
            }
            if (left!=null) {
                queue.offer(left);
            }
        }

    }

    static void invertBinaryTreeRecursive(TreeNode<Integer> root) {
        if (root==null) {
            return;
        }
        TreeNode<Integer> left = root.left;
        TreeNode<Integer> right = root.right;
        root.left = right;
        root.right = left;

        invertBinaryTreeIterative(right);
        invertBinaryTreeIterative(left);
    }
}
