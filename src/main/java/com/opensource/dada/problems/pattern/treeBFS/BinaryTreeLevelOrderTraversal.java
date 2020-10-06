package com.opensource.dada.problems.pattern.treeBFS;

import com.opensource.dada.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem:
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 *
 * Example 1:
 *
 *          1
 *        /   \
 *       2     3
 *     /  \  /   \
 *   4    5 6     7
 *  Level Order Traversal:
 *  [[1],[2,3],[4,5,6,7]]
 * Example 2:
 *
 *          12
 *        /   \
 *       7     1
 *     /     /   \
 *   9     10     5
 *   Level Order Traversal:
 *  [[12],[7,1],[9,10,5]]
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        test1();
        test2();
    }
    static void test1() {
        TreeNode<Integer> tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println("Result:"+levelOrderTraversal(tree));
    }
    static void test2() {
        TreeNode<Integer> root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Result:"+levelOrderTraversal(root));
    }
    static List<List<Integer>> levelOrderTraversal(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> node = queue.poll();
                levelList.add(node.value);
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
