package com.opensource.dada.ds.tree;

/**
 * @author dadasaheb
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Print all k-sum paths in a binary tree
 * A binary tree and a number k are given.
 * Print every path in the tree with sum of the nodes in the path as k.
 * A path can start from any node and end at any node and must be downward only,
 * i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.
 *
 * Examples:
 *
 * Input : k = 5
 *         Root of below binary tree:
 *            1
 *         /     \
 *       3        -1
 *     /   \     /   \
 *    2     1   4     5
 *         /   / \     \
 *        1   1   2     6
 *
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
public class PrintAllKsumPathsInBinaryTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new  TreeNode<>(3);
        root.left.left = new  TreeNode<>(2);
        root.left.right = new  TreeNode<>(1);
        root.left.right.left = new  TreeNode<>(1);
        root.right = new  TreeNode<>(-1);
        root.right.left = new  TreeNode<>(4);
        root.right.left.left = new  TreeNode<>(1);
        root.right.left.right = new  TreeNode<>(2);
        root.right.right = new  TreeNode<>(5);
        root.right.right.right = new  TreeNode<>(2);

        int k = 5;
        printKPath(root, k);

    }

    static List<Integer> list = new ArrayList<>();
    private static void printPath(List<Integer> q, int index) {
        for (int i= index; i < q.size(); i++) {
            System.out.print( q.get(i) + " ");
        }
        System.out.println();
    }
    private static void printKPath(TreeNode<Integer> root, int sum) {
        if (root==null) {
            return;
        }

        list.add(root.value);

        printKPath(root.left, sum);

        printKPath(root.right, sum);

        int count = 0;
        for (int i=list.size()-1; i>=0; i--) {
            count += list.get(i);
            if (count==sum) {
                printPath(list, i);
            }
        }
        list.remove(list.size()-1);
    }
}
