package com.opensource.dada.ds.tree;

import org.junit.jupiter.api.Test;

import static com.opensource.dada.ds.tree.FindSecondLargestNodeInBST.findSecondLargest;
import static org.junit.jupiter.api.Assertions.*;

public class FindSecondLargestNodeInBSTTests {

    @Test
    public void findSecondLargestTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        final TreeNode<Integer> a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final TreeNode<Integer> b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftChildTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        final TreeNode<Integer> a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70).insertLeft(60);
        final int actual = findSecondLargest(root);
        final int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftSubtreeTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        final TreeNode<Integer> a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final TreeNode<Integer> b = root.insertRight(70).insertLeft(60);
        b.insertLeft(55).insertRight(58);
        b.insertRight(65);
        final int actual = findSecondLargest(root);
        final int expected = 65;
        assertEquals(expected, actual);
    }

    @Test
    public void secondLargestIsRootNodeTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        final TreeNode<Integer> a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70);
        final int actual = findSecondLargest(root);
        final int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void descendingLinkedListTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20);
        final int actual = findSecondLargest(root);
        final int expected = 40;
        assertEquals(expected, actual);
    }

    @Test
    public void ascendingLinkedListTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        root.insertRight(60).insertRight(70).insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test
    public void exceptionWithTreeThatHasOneNodeTest() {
        final TreeNode<Integer> root = new TreeNode<>(50);
        assertThrows(Exception.class, () -> {
            findSecondLargest(root);
        });
    }

    @Test
    public void exceptionWithEmptyTreeTest() {
        assertThrows(Exception.class, () -> {
            findSecondLargest(null);
        });
    }
}
