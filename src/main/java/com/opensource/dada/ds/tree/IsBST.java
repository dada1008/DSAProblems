package com.opensource.dada.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class IsBST {
    public static void main(String[] args) {

    }

    static boolean isBST1(TreeNode<Integer> root) {
        return isBST1(root, new AtomicInteger(0));
    }

    static boolean isBST1(TreeNode<Integer> root, AtomicInteger previousValue) {
        if(root==null) {
            return true;
        }
        if (!isBST1(root.left, previousValue)) {
            return false;
        }

        if (root.value < previousValue.get()) {
            return false;
        }
        previousValue.set(root.value);
        return isBST1(root.right, previousValue);
    }

    static boolean isBST2(TreeNode<Integer> root) {
        return isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST2(TreeNode<Integer> root, int min, int max) {
        if(root==null) {
            return true;
        }
        return root.value > min && root.value < max && isBST2(root.left, min, root.value) && isBST2(root.right,
                root.value,
                max);
    }
}
