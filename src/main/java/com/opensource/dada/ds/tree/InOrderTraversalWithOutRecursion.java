package com.opensource.dada.ds.tree;

import java.util.Stack;

public class InOrderTraversalWithOutRecursion {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        TreeNode<Character> root = new TreeNode<>('D');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> e = new TreeNode<>('E');
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> c = new TreeNode<>('C');
        root.setLeft(b);
        root.setRight(e);
        b.setLeft(a);
        b.setRight(c);
        // Output: A B C D E
        System.out.println("In-order traversal recursive: ");
        TreeTraversals.inOrder(root);
        System.out.println("\n");
        System.out.println("In-order traversal iterative: ");
        inOrderIterative(root);
        System.out.println("\n");
    }

    public static void test2() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);

        root.left.left = new TreeNode<>(4);
        root.left.left.right = new TreeNode<>(9);

        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        // Output: 4 9 2 1 6 3 7
        System.out.println("In-order traversal recursive: ");
        TreeTraversals.inOrder(root);
        System.out.println("\n");
        System.out.println("In-order traversal iterative: ");
        inOrderIterative(root);
        System.out.println("\n");
    }

    public static <T> void inOrderIterative(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = node;
        while (current!=null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                System.out.printf(current.getValue() + " ");
                current = current.getRight();
            }
        }
    }
}
