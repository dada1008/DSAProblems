package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Given an array of numbers sorted in ascending order,
 * find the range of a given number ‘key’. The range of the ‘key’ will be the first
 * and last position of the ‘key’ in the array.
 * <p>
 * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 6, 6, 6, 9], key = 6
 * Output: [1, 3]
 * Example 2:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 10
 * Output: [3, 3]
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 12
 * Output: [-1, -1]
 */
public class NumberRange {
    public static void main(String[] args) {

    }

    static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        result[0] = search(arr, key, false);
        // no need to search, if 'key' is not present in the input array
        if (result[0] != -1) {
            result[1] = search(arr, key, true);
        }
        return result;
    }

    static int search(int[] arr, int key, boolean findMaxIndex) {
        int start = 0, end = arr.length - 1;
        int keyIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                keyIndex = mid;
                if (findMaxIndex) {
                    // search ahead to find the last index of 'key'
                    start = mid + 1;
                } else {
                    // search behind to find the first index of 'key'
                    end = mid - 1;
                }
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return keyIndex;
    }
}
