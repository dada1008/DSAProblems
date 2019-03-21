package com.opensource.dada.ds.tree;

public class TwoTreesAreMirror {
    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<Integer>(1);
        TreeNode<Integer> b = new TreeNode<Integer>(1);
        a.left = new TreeNode<Integer>(2);
        a.right = new TreeNode<Integer>(3);
        a.left.left = new TreeNode<Integer>(4);
        a.left.right = new TreeNode<Integer>(5);

        b.left = new TreeNode<Integer>(3);
        b.right = new TreeNode<Integer>(2);
        b.right.left = new TreeNode<Integer>(5);
        b.right.right = new TreeNode<Integer>(4);

        if (areMirror(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean areMirror(TreeNode<Integer> a, TreeNode<Integer> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return a.value == b.value && areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

}
