package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Find the maximum value in a given Bitonic array.
 * An array is considered bitonic if it is monotonically increasing
 * and then monotonically decreasing. Monotonically increasing
 * or decreasing means that for any index i in the array arr[i] != arr[i+1].
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 12, 4, 2]
 * Output: 12
 * Explanation: The maximum number in the input bitonic array is '12'.
 * Example 2:
 *
 * Input: [3, 8, 3, 1]
 * Output: 8
 * Example 3:
 *
 * Input: [1, 3, 8, 12]
 * Output: 12
 * Example 4:
 *
 * Input: [10, 9, 8]
 * Output: 10
 */
public class BitonicArrayMaximum {
    public static void main(String[] args) {
        System.out.println("Result:"+findMax(new int[] {1, 3, 8, 12, 4, 2}));//12
        System.out.println("Result:"+findMax(new int[] {3, 8, 3, 1}));//8
        System.out.println("Result:"+findMax(new int[] {1, 3, 8, 12}));//12
        System.out.println("Result:"+findMax(new int[] {10, 9, 8}));//10
    }

    static int findMax(int[] arr) {
        int start = 0, end = arr.length -1;

        while (start < end) {
            int mid = start + (end -start)/2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid +1 ;
            }
        }

        return arr[start];
    }
}
