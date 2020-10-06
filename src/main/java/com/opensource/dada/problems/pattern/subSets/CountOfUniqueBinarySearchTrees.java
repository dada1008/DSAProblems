package com.opensource.dada.problems.pattern.subSets;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given a number ‘n’, write a function to return the count of
 * structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: As we saw in the previous problem, there are 2 unique BSTs storing numbers from 1-2.
 * Example 2:
 *
 * Input: 3
 * Output: 5
 * Explanation: There will be 5 unique BSTs that can store numbers from 1 to 5.
 */
public class CountOfUniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println("Result:"+ countUniqueTrees(2));
        System.out.println("Result:"+ countUniqueTrees(3));
    }

    static int countUniqueTrees(int n) {
        if (n <=1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int leftTrees = countUniqueTrees(i-1);
            int rightTrees = countUniqueTrees( n-i);
            count += (leftTrees * rightTrees);
        }
        return count;
    }
}
