package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 * You should assume that the array can have duplicates.
 *
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 *
 * Example 1:
 *
 * Input: [4, 6, 10], key = 10
 * Output: 2
 * Example 2:
 *
 * Input: [1, 2, 3, 4, 5, 6, 7], key = 5
 * Output: 4
 * Example 3:
 *
 * Input: [10, 6, 4], key = 10
 * Output: 0
 * Example 4:
 *
 * Input: [10, 6, 4], key = 4
 * Output: 2
 */
public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        System.out.println("Result:"+search(new int[]{4, 6, 10}, 10));//2
        System.out.println("Result:"+search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));//4
        System.out.println("Result:"+search(new int[]{10, 6, 4}, 10));//0
        System.out.println("Result:"+search(new int[]{10, 6, 4}, 4));//2
    }

    static int search(int[] arr, int key) {
        int start = 0, end = arr.length -1;
        boolean isAscending = arr[start] < arr[end];
        while (start <=end) {
            int mid = start + (end - start)/2;
            if (arr[mid]==key) {
                return mid;
            } else if (arr[mid] < key) {
                if (isAscending) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            } else {
                if (isAscending) {
                    end = mid -1;
                } else {
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
