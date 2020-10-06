package com.opensource.dada.problems.pattern.slidingWindow;

/**
 * Problem:
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 * <p>
 * Example 1:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * <p>
 * Example 2:
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * <p>
 * Example 3:
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class SmallestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] input = {2, 1, 5, 2, 3, 2};
        int result = findSmallestSubarrayWithGivenSum(input, 7);
        System.out.println("Result-1:" + result);//2

        input = new int[]{2, 1, 5, 2, 8};
        result = findSmallestSubarrayWithGivenSum(input, 7);
        System.out.println("Result-2:" + result);//2

        input = new int[]{3, 4, 1, 1, 6};
        result = findSmallestSubarrayWithGivenSum(input, 8);
        System.out.println("Result-3:" + result);//3
    }

    static int findSmallestSubarrayWithGivenSum(int[] array, int S) {
        int sum = 0;
        int startIndex = 0;
        int smallestSubArrayLength = Integer.MAX_VALUE;
        for (int endIndex = 0; endIndex < array.length; endIndex++) {
            sum += array[endIndex];
            while (sum >= S) {
                smallestSubArrayLength = Math.min(smallestSubArrayLength, endIndex - startIndex + 1);
                sum -= array[startIndex];
                startIndex++;
            }
        }
        return smallestSubArrayLength==Integer.MAX_VALUE ? 0: smallestSubArrayLength;
    }
}
