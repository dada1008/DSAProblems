package com.opensource.dada.alg.dynamicprogramming;

public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int[] array = {7, 10, 12, 7, 9, 14};
        //result {7, 10, 19, 19, 28, 33};
    }

    //Time complexity: O(n), Space complexity: O(n)
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array==null || array.length==0) {
            return -1;
        }
        if (array.length==1) {
            return array[0];
        }
        int[] maxSums = new int[array.length];
        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + array[i]);
        }
        return maxSums[maxSums.length -1];
    }

    //Time complexity: O(n), Space complexity: O(1)
    public static int maxSubsetSumNoAdjacentSpaceOptimized(int[] array) {
        if (array==null || array.length==0) {
            return -1;
        }
        if (array.length==1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }
}
