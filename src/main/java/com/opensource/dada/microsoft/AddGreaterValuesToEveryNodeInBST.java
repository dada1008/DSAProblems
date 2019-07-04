package com.opensource.dada.microsoft;

import com.opensource.dada.ds.tree.TreeNode;

/**
 * Problem: https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 *
 */
public class AddGreaterValuesToEveryNodeInBST {
    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode<>(50);

          /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        TreeNode.insert(tree,30);
        TreeNode.insert(tree,20);
        TreeNode.insert(tree,40);
        TreeNode.insert(tree,70);
        TreeNode.insert(tree,60);
        TreeNode.insert(tree,80);

        System.out.println("Before change tree inorder:");
        inOrder(tree);
        System.out.println("\n");

        addGreaterValuesToEveryNode(tree);

        System.out.println("After adding greater value change tree inorder:");
        inOrder(tree);

    }

    // This class initialises the value of sum to 0
    static class Sum {
        int sum = 0;
    }
    static void addGreaterValuesToEveryNode(TreeNode<Integer> tree) {
        Sum sum = new Sum();
        addGreaterValuesToEveryNode(tree,sum);
    }

    static void addGreaterValuesToEveryNode(TreeNode<Integer> tree, Sum sum) {
        if (tree==null) {
            return;
        }
        addGreaterValuesToEveryNode(tree.right, sum);
        sum.sum += tree.value;
        tree.value = sum.sum;
        addGreaterValuesToEveryNode(tree.left, sum);
    }

    static void inOrder(TreeNode<Integer> node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
}
