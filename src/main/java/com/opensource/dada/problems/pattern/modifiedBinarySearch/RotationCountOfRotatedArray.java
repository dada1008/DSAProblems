package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Given an array of numbers which is sorted in ascending order
 * and is rotated ‘k’ times around a pivot, find ‘k’.
 *
 * You can assume that the array does not have any duplicates.
 *
 * Example 1:
 * Input: [10, 15, 1, 3, 8]
 * Output: 2
 * Explanation: The array has been rotated 2 times.
 * Original array: 1 3 8 10 15
 * Array after 2 rotations: 10 15 1 3 8
 *
 * Example 2:
 * Input: [4, 5, 7, 9, 10, -1, 2]
 * Output: 5
 * Explanation: The array has been rotated 5 times.
 * Original array: -1 2 4 5 7 9 10
 * Array after 5 rotations: 4 5 7 9 10 -1 2
 *
 * Example 3:
 * Input: [1, 3, 8, 10]
 * Output: 0
 * Explanation: The array has been not been rotated.
 */
public class RotationCountOfRotatedArray {
    public static void main(String[] args) {

    }

    static int countRotations(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end -start)/2;
            // if mid is greater than the next element
            if (mid < end && arr[mid] > arr[mid +1]) {
                return mid +1;
            }
            // if mid is smaller than the previous element
            if (mid > start && arr[mid -1 ] > arr[mid]) {
                return mid;
            }

            // left side is sorted, so the pivot is on right side
            if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                // right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }

        // the array has not been rotated
        return 0;
    }
}
