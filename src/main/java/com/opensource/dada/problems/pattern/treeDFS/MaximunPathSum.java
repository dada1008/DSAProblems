package com.opensource.dada.problems.pattern.treeDFS;

import com.opensource.dada.ds.tree.TreeNode;

/**
 * Problem:
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum. A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
 *
 *  Example 1:
 *   1
 *   2
 *   3
 *   4
 *   5
 *   6
 *  Output: 16
 *  Explanation: The path with maximum sum is: [4, 2, 1, 3, 6]
 *  Example 2:
 *   1
 *   2
 *   3
 *   1
 *   3
 *   5
 *   6
 *   7
 *   8
 *   9
 *   Output: 31
 *   Explanation: The path with maximum sum is: [8, 5, 3, 6, 9]
 */
public class MaximunPathSum {
    static int globalMaxSum = 0;
    public static void main(String[] args) {

    }

    static int findMaximumPathSum(TreeNode<Integer> root) {
        globalMaxSum = Integer.MIN_VALUE;
        findMaxSumPath(root);
        return globalMaxSum;
    }

    static int findMaxSumPath(TreeNode<Integer> root) {
        if (root==null) {
            return 0;
        }
        int leftSum = findMaxSumPath(root.left);
        int rightSum = findMaxSumPath(root.right);

        // ignore paths with negative sums, since we need to find the maximum sum we should
        // ignore any path which has an overall negative sum.
        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);
        // maximum path sum at the current node will be equal to the sum from the left subtree +
        // the sum from right subtree + val of current node
        int localMaxSum = leftSum + rightSum + root.value;

        globalMaxSum = Math.max(localMaxSum, globalMaxSum);

        // maximum sum of any path from the current node will be equal to the maximum of
        // the sums from left or right subtrees plus the value of the current node
        return Math.max(leftSum, rightSum) + root.value;
    }

}
