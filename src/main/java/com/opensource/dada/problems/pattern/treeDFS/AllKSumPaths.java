package com.opensource.dada.problems.pattern.treeDFS;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
 * https://leetcode.com/problems/path-sum-iii/
 */
public class AllKSumPaths {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        /**
         * k = 5
         *            1
         *         /     \
         *       3        -1
         *     /   \     /   \
         *    2     1   4     5
         *         /   / \     \
         *        1   1   2     6
         * Output :
         * 3 2
         * 3 1 1
         * 1 3 1
         * 4 1
         * 1 -1 4 1
         * -1 4 2
         * 5
         * 1 -1 5
         */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(1);
        root.left.right.left = new TreeNode<>(1);
        root.right = new TreeNode<>(-1);
        root.right.left = new TreeNode<>(4);
        root.right.left.left = new TreeNode<>(1);
        root.right.left.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(5);
        root.right.right.right = new TreeNode<>(2);

        System.out.println("Test1 Sum path:");
        printPathForSum(root, 5);
    }

    static void test2() {
        /**
         * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
         *
         *       10
         *      /  \
         *     5   -3
         *    / \    \
         *   3   2   11
         *  / \   \
         * 3  -2   1
         *
         * Return 3. The paths that sum to 8 are:
         *
         * 1.  5 -> 3
         * 2.  5 -> 2 -> 1
         * 3. -3 -> 11
         */
        TreeNode<Integer> tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(-3);

        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(2);

        tree.right.right = new TreeNode(11);

        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);

        tree.left.right.right = new TreeNode(1);

        System.out.println("Test2 Sum path:");
        printPathForSum(tree, 8);
    }

    static void printPathForSum(TreeNode<Integer> tree, int sum) {
        printPathForSum(tree, sum, new ArrayList<>());
    }

    static void printPathForSum(TreeNode<Integer> root, int k, List<Integer> path) {

        if (root == null)
            return;

        // add current node to the path
        path.add(root.value);

        // check if there's any k sum path
        // in the left sub-tree.
        printPathForSum(root.left, k, path);

        // check if there's any k sum path
        // in the right sub-tree.
        printPathForSum(root.right, k, path);

        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);

            // If path sum is k, print the path
            if (f == k) {
                printVector(path, j);
            }
        }

        // Remove the current element from the path
        path.remove(path.size() - 1);
    }

    //utility function to print contents of
//a vector from index i to it's end
    static void printVector(List<Integer> v, int i) {
        for (int j = i; j < v.size(); j++) {
            System.out.print(v.get(j) + " ");
        }
        System.out.println();
    }
}
