package com.opensource.dada.problems.pattern.cyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
 * The array can have duplicates, which means some numbers will be missing.
 * Find all those missing numbers.
 *
 * Example 1:
 *
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 * Example 2:
 *
 * Input: [2, 4, 1, 2]
 * Output: 3
 * Example 3:
 *
 * Input: [2, 3, 2, 1]
 * Output: 4
 */
public class FindAllMissingNumber {
    public static void main(String[] args) {
        System.out.println("Result:"+ findMissingNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1}));
        System.out.println("Result:"+ findMissingNumbers(new int[]{2, 4, 1, 2}));
        System.out.println("Result:"+ findMissingNumbers(new int[]{2, 3, 2, 1}));
    }

    static List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
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
                missingNumbers.add(j+1);
            }
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
