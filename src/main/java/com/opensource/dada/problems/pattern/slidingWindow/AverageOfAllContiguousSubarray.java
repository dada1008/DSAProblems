package com.opensource.dada.problems.pattern.slidingWindow;

import java.util.Arrays;

/**
 * Problem:
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * Let’s understand this problem with a real input:
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array.
 * Let’s solve this:
 *
 * For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
 * The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
 * For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
 * …
 * Here is the final output containing the averages of all contiguous subarrays of size 5:
 *
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class AverageOfAllContiguousSubarray {
    public static void main(String[] args) {
        int[] input = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] result = getAverage(input, 5);
        System.out.println("Result:"+ Arrays.toString(result));
    }
    static double[] getAverage(int[] array, int K) {
        double[] result = new double[array.length-K+1];
        double sum = 0;
        for (int i = 0; i < K; i++) {
            sum += array[i];
        }
        result[0] = sum/K;
        for (int i = K; i < array.length; i++) {
            sum = sum -array[i-K] + array[i];
            result[i-K+1] = sum/K;
        }
        return result;
    }
}
