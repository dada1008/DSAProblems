package com.opensource.dada.ds.tree;

/**
 * @author dadasaheb
 */
public class CheckPathExistanceWithSum {
    public static void main(String[] args) {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(8);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(2);

        if (haspathSum(root, sum)) {
            System.out.println("There is a root to leaf path with sum " + sum);
        } else {
            System.out.println("There is no root to leaf path with sum " + sum);
        }

    }

    private static boolean haspathSum(TreeNode<Integer> root, int sum) {
        if (root==null) {
            return false;
        }

        int remaining = sum - root.value;
        if (remaining==0 && root.left==null && root.right==null) {
            return true;
        }
        boolean hasPath = false;
        if (root.left!=null) {
            hasPath = hasPath || haspathSum(root.left, remaining);
        }
        if (root.right!=null) {
            hasPath = hasPath || haspathSum(root.right, remaining);
        }

        return hasPath;
    }
}
