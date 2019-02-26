package com.opensource.dada.ds.tree;

import java.util.Objects;

public class TreeNode<E> {
    private E value;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E value) {
        this.value = value;
    }

    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    /**
     * this method takes value to be inserted in left node, which return newly created left node
     * @param leftValue
     * @return TreeNode
     */
    public TreeNode<E> insertLeft(E leftValue) {
        this.left = new TreeNode(leftValue);
        return this.left;
    }

    /**
     * this method takes value to be inserted in right node, which return newly created right node
     * @param rightValue
     * @return TreeNode
     */
    public TreeNode<E> insertRight(E rightValue) {
        this.right = new TreeNode(rightValue);
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(value, treeNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
