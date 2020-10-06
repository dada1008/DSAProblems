package com.opensource.dada.problems.pattern.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible,
 * return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * <p>
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * <p>
 * Example 3:
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println("Result:" + threeSumClose(new int[]{-2, 0, 1, 2}, 2));
        System.out.println("Result:" + threeSumClose(new int[]{-3, -1, 1, 2}, 1));
        System.out.println("Result:" + threeSumClose(new int[]{1, 0, 1, 1}, 100));
    }

    static int threeSumClose(int[] arr, int target) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                int tempDiff = target - sum;
                if (tempDiff == 0) {
                    return target - tempDiff;
                }

                if (Math.abs(minDiff) > Math.abs(tempDiff)) {
                    minDiff = tempDiff;
                }

                if (tempDiff > 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return target - minDiff;
    }
}
