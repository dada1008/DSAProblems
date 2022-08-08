package com.opensource.dada.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class FindKthSmallestNodeInBST {

    // Function to find k'th smallest element in BST
    // Here i denotes the number of nodes processed so far
    public static int kthSmallest(TreeNode<Integer> root, AtomicInteger i, int k) {
        // base case
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // search in left subtree
        int left = kthSmallest(root.left, i, k);//9822682759 - call in between 5:30-6:30pm monday to friday for appointment

        // if k'th smallest is found in left subtree, return it
        if (left != Integer.MAX_VALUE) {
            return left;
        }

        // if current element is k'th smallest, return its value
        if (i.incrementAndGet() == k) {
            return root.value;
        }

        // else search in right subtree
        return kthSmallest(root.right, i, k);
    }

    // Function to find k'th smallest element in BST
    public static int kthSmallest(TreeNode<Integer> root, int k) {
        // maintain index to count number of nodes processed so far
        AtomicInteger i = new AtomicInteger(0);

        // traverse the tree in in-order fashion and return k'th element
        return kthSmallest(root, i, k);
    }

    // main function
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        TreeNode<Integer> root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = TreeNode.insert(root, key);
        }

        int k = 2;
        int res = kthSmallest(root, k);

        if (res != Integer.MAX_VALUE) {
            System.out.println(res);
        } else {
            System.out.println("Invalid Input");
        }
    }

    static void test2() {
        /* Let us create following BST
            50
        /     \
        30     70
        / \ / \
    20 40 60 80 */
        TreeNode<Integer> root = null;
        root = TreeNode.insert(root, 50);
        TreeNode.insert(root, 30);
        TreeNode.insert(root, 20);
        TreeNode.insert(root, 40);
        TreeNode.insert(root, 70);
        TreeNode.insert(root, 60);
        TreeNode.insert(root, 80);

        for (int k=1; k<=7; k++) {
            System.out.print(kthSmallest(root, k) + " ");
        }
    }
}