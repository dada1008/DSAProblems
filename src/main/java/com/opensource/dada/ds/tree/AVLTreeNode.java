package com.opensource.dada.ds.tree;

import java.util.Objects;

public class AVLTreeNode<E extends Comparable<E>> implements Comparable{
    public int height;
    public E value;
    public AVLTreeNode<E> left;
    public AVLTreeNode<E> right;

    public AVLTreeNode(E value) {
        this.value=value;
    }

    public AVLTreeNode(E value, AVLTreeNode left, AVLTreeNode right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public AVLTreeNode(E value, AVLTreeNode left, AVLTreeNode right, int height) {
        this(value, left, right);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public E getValue() {
        return value;
    }

    public AVLTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<E> left) {
        this.left = left;
    }

    public AVLTreeNode<E> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<E> right) {
        this.right = right;
    }

    /**
     * this method takes value to be inserted in left node, which return newly created left node
     * @param leftValue
     * @return AVLTreeNode
     */
    public AVLTreeNode<E> insertLeft(E leftValue) {
        this.left = new AVLTreeNode(leftValue);
        return this.left;
    }

    /**
     * this method takes value to be inserted in right node, which return newly created right node
     * @param rightValue
     * @return AVLTreeNode
     */
    public AVLTreeNode<E> insertRight(E rightValue) {
        this.right = new AVLTreeNode(rightValue);
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AVLTreeNode<?> treeNode = (AVLTreeNode<?>) o;
        return Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static <E extends Comparable<E>> AVLTreeNode<E> insert(AVLTreeNode<E> root, AVLTreeNode<E> parent, E data) {
        if (root==null) {
            root = new AVLTreeNode<>(data);
        } else if (root.value.compareTo(data) < 0){
            root.left = insert(root.left, root, data);
            if (height(root.left)-height(root.right)==2) {
                if (root.left.value.compareTo(data) < 0) {
                    root = singleRotateLeft(root);
                } else {
                    root = doubleRotateWithLeft(root);
                }
            }
        } else if (root.value.compareTo(data) > 0){
            root.right = insert(root.right, root, data);
            if (height(root.right)-height(root.left)==2) {
                if (root.right.value.compareTo(data) < 0) {
                    root = singleRotateRight(root);
                } else {
                    root = doubleRotateWithRight(root);
                }
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
    }

    static <E extends Comparable<E>> AVLTreeNode<E> singleRotateLeft(AVLTreeNode<E> node) {
        AVLTreeNode<E> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        updateHeight(node);
        updateHeight(newNode);
        return newNode;
    }
    static <E extends Comparable<E>> AVLTreeNode<E> singleRotateRight(AVLTreeNode<E> node) {
        AVLTreeNode<E> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        updateHeight(node);
        updateHeight(newNode);
        return newNode;
    }

    static <E extends Comparable<E>> AVLTreeNode<E> doubleRotateWithLeft(AVLTreeNode<E> node) {
        node.left = singleRotateRight(node.left);
        return singleRotateLeft(node);
    }

    static <E extends Comparable<E>> AVLTreeNode<E> doubleRotateWithRight(AVLTreeNode<E> node) {
        node.right = singleRotateLeft(node.right);
        return singleRotateRight(node);
    }

    static <E extends Comparable<E>> void updateHeight(AVLTreeNode<E> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    static <E extends Comparable<E>> int height(AVLTreeNode<E> n) {
        return n == null ? -1 : n.height;
    }

    static <E extends Comparable<E>> int getBalance(AVLTreeNode<E> n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Comparable) {
            return this.value.compareTo((E) o);
        }
        return -1;
    }
}
