package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Given an array of numbers sorted in ascending order,
 * find the element in the array that has the minimum difference with the given ‘key’.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 6, 10], key = 7
 * Output: 6
 * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 * Example 2:
 * <p>
 * Input: [4, 6, 10], key = 4
 * Output: 4
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 12
 * Output: 10
 * Example 4:
 * <p>
 * Input: [4, 6, 10], key = 17
 * Output: 10
 */
public class MinimumDifferenceElement {
    public static void main(String[] args) {

    }

    static int searchMinDiffElement(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        if (key < arr[0]) {
            return arr[0];
        }
        if (key > arr[end]) {
            return arr[end];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int startDiff = Math.abs(arr[start] - key);
        int endDiff = Math.abs(arr[end] - key);
        if (startDiff > endDiff) {
            return arr[end];
        }
        return arr[start];
    }
}
