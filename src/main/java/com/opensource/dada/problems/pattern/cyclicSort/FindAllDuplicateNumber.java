package com.opensource.dada.problems.pattern.cyclicSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array has some duplicates, find all the duplicate numbers without using any extra space.
 *
 * Example 1:
 *
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 * Example 2:
 *
 * Input: [5, 4, 7, 2, 3, 5, 3]
 * Output: [3, 5]
 */
public class FindAllDuplicateNumber {
    public static void main(String[] args) {
        System.out.println("Result:"+ findDuplicateNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1}));
        System.out.println("Result:"+ findDuplicateNumbers(new int[]{2, 4, 1, 2}));
        System.out.println("Result:"+ findDuplicateNumbers(new int[]{2, 3, 2, 1}));
    }

    static List<Integer> findDuplicateNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
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
                duplicateNumbers.add(nums[j]);
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
