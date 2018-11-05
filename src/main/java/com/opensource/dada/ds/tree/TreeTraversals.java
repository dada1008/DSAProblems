package com.opensource.dada.ds.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

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
        System.out.println("\nDepthFirst: ");
        depthFirst(root);
    }

    public static void preOrder(TreeNode<Character> node) {
        System.out.printf(node.getValue()+" ");
        if (node.getLeft()!=null) {
            preOrder(node.getLeft());
        }
        if (node.getRight()!=null) {
            preOrder(node.getRight());
        }
    }

    public static void inOrder(TreeNode<Character> node) {
        if (node.getLeft()!=null) {
            inOrder(node.getLeft());
        }
        System.out.printf(node.getValue()+" ");
        if (node.getRight()!=null) {
            inOrder(node.getRight());
        }
    }

    public static void postOrder(TreeNode<Character> node) {
        if (node.getLeft()!=null) {
            postOrder(node.getLeft());
        }
        if (node.getRight()!=null) {
            postOrder(node.getRight());
        }
        System.out.printf(node.getValue()+" ");
    }

    public static void depthFirst(TreeNode<Character> node) {
        Queue<TreeNode<Character>> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            TreeNode<Character> treeNode = queue.remove();
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
