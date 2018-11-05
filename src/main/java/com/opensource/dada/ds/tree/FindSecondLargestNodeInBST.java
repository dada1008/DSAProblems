package com.opensource.dada.ds.tree;

public class FindSecondLargestNodeInBST {

    public static int findSecondLargest(TreeNode<Integer> rootNode) {

        if (rootNode == null || (rootNode.getLeft() == null && rootNode.getRight() == null)) {
            throw new RuntimeException("Unacceptable input");
        }

        TreeNode<Integer> result = null;
        TreeNode currNode = rootNode;

        while (currNode.getRight() != null) {
            result = currNode;
            currNode = currNode.getRight();
        }
        if (currNode.getLeft() != null) {
            currNode = currNode.getLeft();
            while (currNode.getRight() != null) {
                currNode = currNode.getRight();
            }
            result = currNode;
        }

        return result.getValue();
    }

}
