package com.opensource.dada.problems.leetcode;

import com.opensource.dada.ds.tree.TreeNode;

/*
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (46.46%)
 * Likes:    5658
 * Dislikes: 311
 * Total Accepted:    750.1K
 * Total Submissions: 1.6M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 * 
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {

    public static void main(String[] args) {
        //[1,2,2,3,null,null,3,4,null,null,4]
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(2);

        root.left.left = new TreeNode<>(3);
        root.right.right = new TreeNode<>(3);

        root.left.left.left = new TreeNode<>(4);
        root.right.right.right = new TreeNode<>(4);

        System.out.println("Result:"+isBalanced(root));
    }

    public static boolean isBalanced(TreeNode<Integer> root) {
        if(root==null) {
            return true;
        }
        int leftDepth = 0;
        if(root.left!=null) {
            leftDepth = getDepth(root.left);
        }
        int rightDepth = 0;
        if(root.right!=null) {
            rightDepth = getDepth(root.right);
        }
        return (Math.abs(leftDepth - rightDepth) <=1) && isBalanced(root.left) &&isBalanced(root.right);
    }
    
    public static int getDepth(TreeNode<Integer> root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        int leftDepth = 0;
        if(root.left!=null) {
            leftDepth = getDepth(root.left);
        }
        int rightDepth = 0;
        if(root.right!=null) {
            rightDepth = getDepth(root.right);
        }
        return Math.max(leftDepth, rightDepth) + 1;
    } 
}

