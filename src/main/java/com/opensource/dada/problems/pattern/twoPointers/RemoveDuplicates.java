package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
 * after removing the duplicates in-place return the new length of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 * <p>
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println("Result:" + remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println("Result:" + remove(new int[]{2, 2, 2, 11}));

        System.out.println("Result-2:" + remove2(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println("Result-2:" + remove2(new int[]{2, 2, 2, 11}));
    }

    static int remove(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return -1;
        }
        int start = 0, end = 1, removalCount = 0;
        while (end < arr.length && start < end) {
            int leftNum = arr[start];
            int rightNum = arr[end];

            if (leftNum == rightNum) {
                removalCount++;
            } else {
                start = end;
            }
            end++;
        }
        return arr.length - removalCount;
    }

    //Alternative solution
    static int remove2(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return -1;
        }
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}
