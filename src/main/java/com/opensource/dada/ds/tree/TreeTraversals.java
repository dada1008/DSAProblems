package com.opensource.dada.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
    public static void main(String[] args) {
        TreeNode<Character> root = new TreeNode<>('D');
        TreeNode<Character> b = new TreeNode<>('B');
        TreeNode<Character> e = new TreeNode<>('E');
        TreeNode<Character> a = new TreeNode<>('A');
        TreeNode<Character> c = new TreeNode<>('C');
        root.setLeft(b);
        root.setRight(e);
        b.setLeft(a);
        b.setRight(c);
        System.out.println("PreOrder: ");
        preOrder(root);
        System.out.println("\nInOrder: ");
        inOrder(root);
        System.out.println("\nPostOrder: ");
        postOrder(root);
        System.out.println("\nBreadth First: ");
        breadthFirst(root);
    }

    public static <T> void preOrder(TreeNode<T> node) {
        System.out.printf(node.getValue()+" ");
        if (node.getLeft()!=null) {
            preOrder(node.getLeft());
        }
        if (node.getRight()!=null) {
            preOrder(node.getRight());
        }
    }

    public static <T> void inOrder(TreeNode<T> node) {
        if (node.getLeft()!=null) {
            inOrder(node.getLeft());
        }
        System.out.printf(node.getValue()+" ");
        if (node.getRight()!=null) {
            inOrder(node.getRight());
        }
    }

    // Iterative function to perform in-order traversal of the tree
    public static <T> void inorderIterative(TreeNode<T> root)
    {
        // create an empty stack
        Stack<TreeNode> stack = new Stack();

        // start from root node (set current node to root node)
        TreeNode curr = root;

        // if current node is null and stack is also empty, we're done
        while (!stack.empty() || curr != null)
        {
            // if current node is not null, push it to the stack (defer it)
            // and move to its left child
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                // else if current node is null, we pop an element from stack,
                // print it and finally set current node to its right child
                curr = stack.pop();
                System.out.print(curr.value + " ");

                curr = curr.right;
            }
        }
    }

    public static<T>void postOrder(TreeNode<T> node) {
        if (node.getLeft()!=null) {
            postOrder(node.getLeft());
        }
        if (node.getRight()!=null) {
            postOrder(node.getRight());
        }
        System.out.printf(node.getValue()+" ");
    }

    public static void breadthFirst(TreeNode<?> node) {
        Queue<TreeNode<?>> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            TreeNode<?> treeNode = queue.remove();
            System.out.printf(treeNode.getValue()+" ");
            if (treeNode.getLeft()!=null) {
                queue.add(treeNode.getLeft());
            }
            if (treeNode.getRight()!=null) {
                queue.add(treeNode.getRight());
            }
        }
    }

}
