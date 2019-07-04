package com.opensource.dada.problems.pattern.treeDFS;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://www.geeksforgeeks.org/print-paths-root-specified-sum-binary-tree/
 *          https://leetcode.com/problems/path-sum-ii/
 */
public class AllPathsForSum {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        /**
         * sum = 8,
         *
         *          1
         *        /   \
         *      20      3
         *            /    \
         *          4       15
         *         /  \     /  \
         *        6    7   8    9
         * Output :
         * Path: 1 3 4
         */

        TreeNode<Integer> tree = new TreeNode(1);
        tree.left = new TreeNode(20);
        tree.right = new TreeNode(3);

        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(15);

        tree.right.left.left = new TreeNode(6);
        tree.right.left.right = new TreeNode(7);

        tree.right.right.left = new TreeNode(8);
        tree.right.right.right = new TreeNode(9);

        System.out.println("Test1 Sum path:");
        printPathForSum(tree, 8);
    }

    static void test2() {
        /**
         * sum = 38,
         *           10
         *        /     \
         *      28       13
         *            /     \
         *          14       15
         *         /   \     /  \
         *        21   22   23   24
         * Output : Path found: 10 28
         *         Path found: 10 13 15
         */
        TreeNode<Integer> tree = new TreeNode(10);
        tree.left = new TreeNode(28);
        tree.right = new TreeNode(13);

        tree.right.left = new TreeNode(14);
        tree.right.right = new TreeNode(15);

        tree.right.left.left = new TreeNode(21);
        tree.right.left.right = new TreeNode(22);

        tree.right.right.left = new TreeNode(23);
        tree.right.right.right = new TreeNode(24);

        System.out.println("Test2 Sum path:");
        printPathForSum(tree, 38);
    }

    static void test3() {
        /**
         * Given the below binary tree and sum = 22,
         *
         *       5
         *      / \
         *     4   8
         *    /   / \
         *   11  13  4
         *  /  \    / \
         * 7    2  5   1
         * Return:
         * [
         *    [5,4,11,2],
         *    [5,8,4,5]
         * ]
         */
        TreeNode<Integer> tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);

        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);

        System.out.println("Test3 Sum path:");
        printPathForSum(tree, 22);
    }


    static void printPathForSum(TreeNode<Integer> tree, int sum) {
        printPathForSum(tree, sum, new ArrayList<>());
    }

    static void printPathForSum(TreeNode<Integer> tree, int sum, List<Integer> paths) {

        sum = sum - tree.value;
        paths.add(tree.value);
        if (sum==0) {
            System.out.println("Path: "+paths);
        }
        if (tree.left!=null) {
            printPathForSum(tree.left, sum, paths);
        }

        if (tree.right!=null) {
            printPathForSum(tree.right, sum, paths);
        }
        paths.remove(paths.size()-1);
    }

}
