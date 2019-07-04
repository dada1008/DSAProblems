package com.opensource.dada.problems.pattern.treeDFS;

import com.opensource.dada.ds.tree.TreeNode;

/**
 * Problem: https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 *          https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumOfPathNumbers {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        /**
         *          6
         *        /  \
         *      3     5
         *    /  \     \
         *   2    5     4
         *       / \
         *      7   4
         *   There are 4 leaves, hence 4 root to leaf paths:
         *    Path                    Number
         *   6->3->2                   632
         *   6->3->5->7               6357
         *   6->3->5->4               6354
         *   6->5>4                    654
         * Answer = 632 + 6357 + 6354 + 654 = 13997
         */
        TreeNode<Integer> tree = new TreeNode(6);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(5);

        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);

        tree.right.right = new TreeNode(4);

        tree.left.right.left = new TreeNode(7);
        tree.left.right.right = new TreeNode(4);

        System.out.println("Test1 Sum: "+sumNumbers(tree, 0));
    }

    public static void test2() {
        /**
         *     1
         *    / \
         *   2   3
         * Output: 25
         * Explanation:
         * The root-to-leaf path 1->2 represents the number 12.
         * The root-to-leaf path 1->3 represents the number 13.
         * Therefore, sum = 12 + 13 = 25.
         */
        TreeNode<Integer> tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        System.out.println("Test2 Sum: "+sumNumbers(tree, 0));
    }

    public static void test3() {
        /**
         *     4
         *    / \
         *   9   0
         *  / \
         * 5   1
         * Output: 1026
         * Explanation:
         * The root-to-leaf path 4->9->5 represents the number 495.
         * The root-to-leaf path 4->9->1 represents the number 491.
         * The root-to-leaf path 4->0 represents the number 40.
         * Therefore, sum = 495 + 491 + 40 = 1026.
         */
        TreeNode<Integer> tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);

        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(1);

        System.out.println("Test3 Sum: "+sumNumbers(tree, 0));
    }

    public static int sumNumbers(TreeNode<Integer> tree, int sum) {
        if (tree==null) {
            return 0;
        }

        sum = sum*10 + tree.value;

        if (tree.left == null && tree.right == null) {
            return sum;
        }

        int leftSum =sumNumbers(tree.left, sum);
        int rightSum = sumNumbers(tree.right, sum);
        return leftSum + rightSum;
    }
}
