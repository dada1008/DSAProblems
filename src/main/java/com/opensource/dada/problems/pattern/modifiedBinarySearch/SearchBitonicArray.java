package com.opensource.dada.problems.pattern.modifiedBinarySearch;

/**
 * Problem:
 * Given a Bitonic array, find if a given ‘key’ is present in it.
 * An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 *
 * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
 *
 * Example 1:
 *
 * Input: [1, 3, 8, 4, 3], key=4
 * Output: 3
 * Example 2:
 *
 * Input: [3, 8, 3, 1], key=8
 * Output: 1
 * Example 3:
 *
 * Input: [1, 3, 8, 12], key=12
 * Output: 3
 * Example 4:
 *
 * Input: [10, 9, 8], key=10
 * Output: 0
 */
public class SearchBitonicArray {
    public static void main(String[] args) {
        System.out.println("Result:"+search(new int[] {1, 3, 8, 4, 3}, 4));//3
        System.out.println("Result:"+search(new int[] {3, 8, 3, 1}, 8));//1
        System.out.println("Result:"+search(new int[] {1, 3, 8, 12}, 12));//3
        System.out.println("Result:"+search(new int[] {10, 9, 8}, 10));//0
    }

    static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int index = binarySearchAsc(arr, 0, maxIndex, key);
        if(index==-1) {
            index = binarySearchDesc(arr, maxIndex+1, arr.length -1, key);
        }
        return index;
    }

    static int binarySearchAsc(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end -start)/2;
            if (arr[mid]==key) {
                return mid;
            }
            if (arr[mid] > key) {
                end = mid -1;
            } else {
                start = mid +1 ;
            }
        }

        return -1;
    }

    static int binarySearchDesc(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end -start)/2;
            if (arr[mid]==key) {
                return mid;
            }
            if (arr[mid] > key) {
                start = mid +1 ;
            } else {
                end = mid -1;
            }
        }

        return -1;
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

        return start;
    }
}
