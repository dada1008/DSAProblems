package com.opensource.dada.microsoft;

import com.opensource.dada.ds.tree.TreeNode;

/**
 * Problem: https://www.careercup.com/question?id=5139982465368064
 *
 */
public class NextLargerElementInBST {

    public static void main(String[] args) {
        //2,3,6,9,7,4,13,24,19

        TreeNode<Integer> root = new TreeNode<>(7);

        TreeNode.insert(root,6);
        TreeNode.insert(root,9);
        TreeNode.insert(root,4);
        TreeNode.insert(root,3);
        TreeNode.insert(root,2);
        TreeNode.insert(root,19);
        TreeNode.insert(root,13);
        TreeNode.insert(root,24);

        //immediate highest value for 9 should be 13
        /*TreeNode<Integer> result = findNextHigherValue(root, 9);

        System.out.println("Result:"+result);*/

        inOrderTraversal(root, 19);

    }

    public static TreeNode<Integer> findNextHigherValue(TreeNode<Integer> root, int value) {


        TreeNode<Integer> currentNode = root;
        TreeNode<Integer> parentOfKeyNode = null;
        TreeNode<Integer> rightOfKeyNode = null;
        TreeNode<Integer> nextHigherOfKeyNode = null;

        while (currentNode!=null) {

            TreeNode<Integer> leftNode = currentNode.left;
            TreeNode<Integer> rightNode = currentNode.right;
            if(value <= leftNode.value) {

            } else if(value > leftNode.value) {

            } else if (currentNode.value==value) {

            }
        }


        return nextHigherOfKeyNode;
    }

    /// <summary>
    /// Method to traverse the binary search tree InOrder and
    /// find the next largest element in the tree
    /// </summary>
    /// <param name="node">tree node</param>
    /// <param name="k">find the next largest value of k</param>ß
    public static void inOrderTraversal(TreeNode<Integer> node, int k, boolean printNext)
    {
        if (node == null)
            return;

        inOrderTraversal(node.left, k, printNext);

        // if the value is true, this is the next largest value of k, we are looking for.
        if (printNext)
        {
            // print the number
            System.out.println("Next value to " + k + " is: " + node.value);
            // set the value to false.
            printNext = false;
        }

        // if this is the value we are looking next largest number for,
        // set printNext to true
        if (node.value == k)
        {
            printNext = true;
        }

        inOrderTraversal(node.right, k, printNext);
    }

    static boolean printNext;
    public static void inOrderTraversal(TreeNode<Integer> node, int k)
    {
        if (node == null)
            return;

        inOrderTraversal(node.left, k);

        // if the value is true, this is the next largest value of k, we are looking for.
        if (printNext)
        {
            // print the number
            System.out.println("Next value to " + k + " is: " + node.value);
            // set the value to false.
            printNext = false;
        }

        // if this is the value we are looking next largest number for,
        // set printNext to true
        if (node.value == k)
        {
            printNext = true;
        }

        inOrderTraversal(node.right, k);
    }
}
