package com.opensource.dada.problems.pattern.subSets;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given a number ‘n’, write a function to return all structurally
 * unique Binary Search Trees (BST) that can store values 1 to ‘n’?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: Here are all the structurally unique BSTs storing all numbers from 1 to 2:
 *   1           2
 *    \         /
 *     2       1
 *
 * Example 2:
 *
 * Input: 3
 * Output: 5
 * Explanation: Here are all the structurally unique BSTs storing all numbers from 1 to 3:
 *   1           1             2            3           3
 *    \           \          /   \         /           /
 *     2           3        1     3       1           2
 *      \         /                        \         /
 *       3       2                          2       1
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println("Result:"+findUniqueTrees(1,2).size());
        System.out.println("Result:"+findUniqueTrees(1,3).size());
        System.out.println("Result:"+findUniqueTrees(1,6).size());

        System.out.println("2 Result:"+numberOfBinaryTreeTopologies(2));
        System.out.println("2 Result:"+numberOfBinaryTreeTopologies(3));
        System.out.println("2 Result:"+numberOfBinaryTreeTopologies(6));
    }

    static List<TreeNode<Integer>> findUniqueTrees(int start, int end) {
        List<TreeNode<Integer>> result = new ArrayList<>();
        // base condition, return 'null' for an empty sub-tree
        // consider n=1, in this case we will have start=end=1, this means we should have only one tree
        // we will have two recursive calls, findUniqueTrees(1, 0) & (2, 1)
        // both of these should return 'null' for the left and the right child
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            // making 'i' root of the tree
            List<TreeNode<Integer>> leftTrees = findUniqueTrees(start, i-1);
            List<TreeNode<Integer>> rightTrees = findUniqueTrees( i+1, end);
            for (TreeNode<Integer> leftNode: leftTrees) {
                for (TreeNode<Integer> rightNode: rightTrees) {
                    TreeNode<Integer> root = new TreeNode<>(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }

        }
        return result;
    }

    //Complexity time: O(n ^2), space: O(n)
    //where n is length of String, m is length of sub String
    static int numberOfBinaryTreeTopologies(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        for (int i = 1; i < n+1; i++) {
            int numberOfTrees = 0;
            for (int leftTreeSize = 0; leftTreeSize < i; leftTreeSize++) {
                int rightTreeSize = i - 1 - leftTreeSize;
                int numberOfLeftTrees = cache[leftTreeSize];
                int numberOfRightTrees = cache[rightTreeSize];
                numberOfTrees+= (numberOfLeftTrees * numberOfRightTrees);
            }
            cache[i] = numberOfTrees;
        }
        return cache[n];
    }
}
