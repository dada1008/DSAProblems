package com.opensource.dada.problems.pattern.treeDFS;

import com.opensource.dada.ds.tree.TreeNode;

/**
 * Problem:
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
 * The diameter of a tree may or may not pass through the root.
 *
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 *
 *  Example 1:
 *          1
 *        /   \
 *       2     3
 *     /     /   \
 *    4     5     6
 *  Output: 5
 *  Explaination: The diameter of the tree is: [4, 2, 1, 3, 6]
 *
 *  Example 2:
 *          1
 *        /   \
 *       2     3
 *           /   \
 *          5     6
 *        /   \     \
 *       7     8     9
 *            /     /
 *           10    11
 *
 */
public class TreeDiameter {
    static int treeDiameter = 0;
    public static void main(String[] args) {

    }

    static int findDiameter(TreeNode<Integer> root) {
        calculateHeight(root);
        return treeDiameter;
    }

    static int calculateHeight(TreeNode<Integer> root) {
        if (root==null) {
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        int diameter = leftHeight + rightHeight +1;
        treeDiameter = Math.max(diameter, treeDiameter);
        return Math.max(leftHeight, rightHeight) +1;
    }
}
