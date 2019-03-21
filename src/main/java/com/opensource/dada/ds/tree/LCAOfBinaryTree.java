package com.opensource.dada.ds.tree;

public class LCAOfBinaryTree {
    public static void main(String[] args) {

    }

    static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root,
                                                  TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root==null) {
            return null;
        }

        if (root==p || root==q) {
            return root;
        }

        TreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);

        if (left==null && right==null) {
            return null;
        } else if(left!=null && right!=null) {
            return root;
        } else {
            return left==null?right:left;
        }

    }
}
