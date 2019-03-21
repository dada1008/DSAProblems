package com.opensource.dada.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class FindKthLargestNodeInBST {

    // Function to find k'th largest element in BST
    // Here i denotes the number of nodes processed so far
    public static int kthLargest(TreeNode<Integer> root, AtomicInteger i, int k) {
        // base case
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // search in right subtree
        int left = kthLargest(root.right, i, k);

        // if k'th smallest is found in left subtree, return it
        if (left != Integer.MAX_VALUE) {
            return left;
        }

        // if current element is k'th smallest, return its value
        if (i.incrementAndGet() == k) {
            return root.value;
        }

        // else search in left subtree
        return kthLargest(root.left, i, k);
    }

    // Function to find k'th smallest element in BST
    public static int kthLargest(TreeNode<Integer> root, int k) {
        // maintain index to count number of nodes processed so far
        AtomicInteger i = new AtomicInteger(0);

        // traverse the tree in in-order fashion and return k'th element
        return kthLargest(root, i, k);
    }

    // main function
    public static void main(String[] args) {
        TreeNode<Integer> root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = TreeNode.insert(root, key);
        }

        int k = 2;
        int res = kthLargest(root, k);

        if (res != Integer.MAX_VALUE) {
            System.out.println(res);
        } else {
            System.out.println("Invalid Input");
        }
    }
}