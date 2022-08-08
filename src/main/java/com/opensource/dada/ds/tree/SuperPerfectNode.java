package com.opensource.dada.ds.tree;

import java.util.Stack;

/**
 * /*
 *
 *          10
 *         /  \
 *        5    5
 *       / \    \
 *      2   0     0
 *     /   / \
 *    1   1   1
 *
 *
 * Identify all the perfect and super perfect nodes. Use non recursive approach
 *
 * perfect = (node == sum of immediate children)
 * super perfect = (node == sum of all children)
 * */

public class SuperPerfectNode {
    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(0);

        root.left.left = new TreeNode<>(2);
        root.left.left.left = new TreeNode<>(1);

        root.left.right = new TreeNode<>(0);
        root.left.right.left = new TreeNode<>(1);
        root.left.right.right = new TreeNode<>(1);

        Stack<TreeNode<Integer>> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode<Integer> current = nodes.pop();
            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                System.out.printf(current.getValue() + " ");
                current = current.getRight();
            }
        }
    }
}
