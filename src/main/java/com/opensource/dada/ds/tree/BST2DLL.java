package com.opensource.dada.ds.tree;

/**
 * Convert a Binary Tree to a Circular Doubly Link List
 * Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).
 *
 * The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
 * The order of nodes in List must be same as Inorder of the given Binary Tree.
 * The first node of Inorder traversal must be head node of the Circular List.
 * Example:
 * tree to list
 *                            10
 *                         /      \
 *                       /         \
 *                     12          15
 *                   /   \        /
 *                 /      \      /
 *                25      30    36
 *
 *       head
 *       |
 * DLL - 25->12->30->10->36->15--
 */
public class BST2DLL {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(12);
        root.right = new TreeNode<>(15);
        root.left.left = new TreeNode<>(25);
        root.left.right = new TreeNode<>(30);
        root.right.left = new TreeNode<>(36);

        TreeNode<Integer> dllRoot = treeToDLL(root);
        display(dllRoot);
    }
    public static <T> void display(TreeNode<T> head) {
        if (head == null) {
            return;
        }

        System.out.println("Circular Linked List is :");
        TreeNode<T> itr = head;
        do
        {
            System.out.print(itr.value+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }
    private static TreeNode<Integer> treeToDLL(TreeNode<Integer> root) {
        if (root==null) {
            return null;
        }
        // Recursively convert left and right subtrees
        TreeNode<Integer> left = treeToDLL(root.left);
        TreeNode<Integer> right = treeToDLL(root.right);

        // Make a circular linked list of single node 
        // (or root). To do so, make the right and 
        // left pointers of this node point to itself 
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list  
        //         with single node, i.e., current node)
        TreeNode<Integer> leftAppend = append(left, root);
        // Step 2 (concatenate the returned list with the 
        //         right List)
        TreeNode<Integer> rightAppend = append(leftAppend, right);
        return rightAppend;
    }

    private static TreeNode<Integer> append(TreeNode<Integer> leftList, TreeNode<Integer> rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        // Store the last Node of left List
        TreeNode<Integer> leftLast = leftList.left;

        // Store the last Node of right List
        TreeNode<Integer> rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

}
