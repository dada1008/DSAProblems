package com.opensource.dada.problems.pattern.treeBFS;

import com.opensource.dada.ds.tree.TreeNode;
import com.opensource.dada.ds.tree.TreeTraversals;

/**
 * Problem: https://www.geeksforgeeks.org/level-order-tree-traversal/
 */
public class LevelOrderTreeTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Level order traversal of binary tree is - ");
        TreeTraversals.breadthFirst(root);//1 2 3 4 5
    }
}
