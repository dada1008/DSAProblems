package com.opensource.dada.ds.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Let us consider the below traversals:
 *
 * Inorder sequence: D B E A F C
 * Preorder sequence: A B D E C F
 *
 *          A
 *        /   \
 *      /       \
 *     B         C
 *    / \        /
 *  /     \    /
 * D       E  F
 *
 *  Inorder Traversal: { 4, 2, 1, 7, 5, 8, 3, 6 }
 *  Preorder Traversal: { 1, 2, 4, 3, 5, 7, 8, 6 }
 *
             1
 *        /    \
 *      /       \
 *     2         3
 *    /         / \
 *  /          /   \
 * 4          5     6
 *           / \
            7   8
 *
 * @author dadasaheb
 */
public class TreeFromInorderPreorderTraversals {
    public static void main(String[] args) {
        System.out.print("\nTest-1 : \n");
        test1();
        System.out.print("\nTest-2 : \n");
        test2();
    }
    static void test1() {
        Integer[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        Integer[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };

        TreeNode<Integer> root = buildBinaryTree(inorder, preorder);

        // traverse the constructed tree
        System.out.print("Inorder  : \n");
        inorderTraversal(root);
        System.out.print("\n");

        System.out.print("Preorder : \n");
        preorderTraversal(root);
        System.out.print("\n");
    }

    static void test2() {
        Character[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
        Character[] preorder = { 'A', 'B', 'D', 'E', 'C', 'F' };

        TreeNode<Character> root = buildBinaryTree(inorder, preorder);

        // traverse the constructed tree
        System.out.print("Inorder  : \n");
        inorderTraversal(root);
        System.out.print("\n");
        System.out.print("Preorder : \n");
        preorderTraversal(root);
        System.out.print("\n");
    }

    static <T> TreeNode<T> buildBinaryTree(T[] inorder, T[] preorder) {
        // create a map to efficiently find the index of any element in
        // given inorder sequence
        Map<T, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        AtomicInteger pIndex = new AtomicInteger(0);
        return buildBinaryTree(inorderIndexMap, preorder, 0, inorder.length-1, pIndex);
    }
    static <T> TreeNode<T> buildBinaryTree(Map<T, Integer> inorderIndexMap, T[] preorder, int start, int end, AtomicInteger preIndex) {
        if (start > end || preorder.length-1 < preIndex.get()) {
            return null;
        }

        TreeNode<T> root = new TreeNode<>(preorder[preIndex.getAndIncrement()]);
        int inorderIndex = inorderIndexMap.get(root.value);
        root.left = buildBinaryTree(inorderIndexMap, preorder, start, inorderIndex-1, preIndex);
        root.right = buildBinaryTree(inorderIndexMap, preorder, inorderIndex+1, end, preIndex);
        return root;
    }

    public static <T> void inorderTraversal(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    public static <T> void preorderTraversal(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
