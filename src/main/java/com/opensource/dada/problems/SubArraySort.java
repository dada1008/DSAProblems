package com.opensource.dada.problems;

public class SubArraySort {
    public static void main(String[] args) {

    }

    //Time complexity: O(n)
    static int[] subArraySort(int[] array) {
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(num, minOutOfOrder);
                maxOutOfOrder = Math.max(num, maxOutOfOrder);
            }
        }
        if (minOutOfOrder==Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int leftIndex = 0;
        while (minOutOfOrder >= array[leftIndex]) {
            leftIndex++;
        }
        int rightIndex = array.length - 1;
        while (maxOutOfOrder <= array[rightIndex]) {
            rightIndex--;
        }
        return new int[]{leftIndex, rightIndex};
    }

    private static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i==0) {
            return num > array[i+1];
        }
        if (i==array.length -1) {
            return num < array[i -1];
        }
        return num > array[i+1] || num < array[i -1];
    }
}
