package com.opensource.dada.ds.tree;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {

    }
    static TreeNode<Integer> sortedArrayToBST(int[] sortedArray) {
        return sortedArrayToBST(sortedArray, 0, sortedArray.length-1);
    }

    private static TreeNode<Integer> sortedArrayToBST(int[] sortedArray, int start, int end) {
        int mid = (start + end)/2;
        TreeNode<Integer> root = new TreeNode<>(sortedArray[mid]);
        root.left = sortedArrayToBST(sortedArray, start, mid-1);
        root.right = sortedArrayToBST(sortedArray, mid+1, end);

        return root;
    }
}
