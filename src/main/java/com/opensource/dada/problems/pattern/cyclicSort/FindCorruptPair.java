package com.opensource.dada.problems.pattern.cyclicSort;

import java.util.Arrays;

/**
 * Problem:
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
 * one of the numbers got duplicated which also resulted in one number going missing.
 * Find both these numbers.
 *
 * Example 1:
 *
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * Example 2:
 *
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 */
public class FindCorruptPair {
    public static void main(String[] args) {
        System.out.println("Corrupt pair:"+ Arrays.toString(findCorruptNumbers(new int[] {3, 1, 2, 5, 2})));
        System.out.println("Corrupt pair:"+ Arrays.toString(findCorruptNumbers(new int[] {3, 1, 2, 3, 6, 4})));
    }

    static int[] findCorruptNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                return new int[]{nums[j], j+1};
            }
        }

        return new int[]{-1,-1};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
