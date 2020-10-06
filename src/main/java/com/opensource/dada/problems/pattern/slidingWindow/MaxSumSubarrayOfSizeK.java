package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;

/**
 * Problem:
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * <p>
 * Example 2:
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] input = {2, 1, 5, 1, 3, 2};
        int result = findMaxSumSubArray(input, 3);
        System.out.println("Result-1:" + result);

        input = new int[]{2, 3, 4, 1, 5};
        result = findMaxSumSubArray(input, 2);
        System.out.println("Result-2:" + result);
    }

    static int findMaxSumSubArray(int[] array, int K) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += array[i];
        }
        int maxSum = sum;
        for (int i = K; i < array.length; i++) {
            sum = sum - array[i - K] + array[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
