package com.opensource.dada.problems.pattern.twoPointers;

import java.util.Arrays;

/**
 * Problem:
 * Given an array of sorted numbers and a target sum, find a pair in the array
 * whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such
 * that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        System.out.println("Result:"+ Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6)));//1,3
        System.out.println("Result:"+ Arrays.toString(search(new int[]{2, 5, 9, 11}, 11)));//0,2
    }
    static int[] search(int[] arr, int targetSum) {
        int start =0, end = arr.length -1;
        while (start < end) {
            int tempSum = arr[start] + arr[end];
            if (tempSum==targetSum) {
                return new int[]{start, end};
            } else if(tempSum > targetSum) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
