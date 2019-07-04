package com.opensource.dada.problems.pattern.treeBFS;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.Stack;

/**
 * Problem: https://www.geeksforgeeks.org/zigzag-tree-traversal/
 */
public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        printZigZagTraversal(tree);//1 3 2 7 6 5 4
    }

    public static void printZigZagTraversal(TreeNode<Integer> tree) {
        Stack<TreeNode<Integer>> currentLevel = new Stack<>();
        Stack<TreeNode<Integer>> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(tree);
        while (!currentLevel.isEmpty()) {
            TreeNode<Integer> node = currentLevel.pop();
            System.out.print(node.value+" ");
            if (leftToRight) {
                if (node.left!=null) {
                    nextLevel.push(node.left);
                }
                if (node.right!=null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right!=null) {
                    nextLevel.push(node.right);
                }
                if (node.left!=null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode<Integer>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}
