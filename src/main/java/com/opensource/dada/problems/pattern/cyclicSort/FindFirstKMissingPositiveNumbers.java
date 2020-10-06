package com.opensource.dada.problems.pattern.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem:
 * Given an unsorted array containing numbers and a number ‘k’,
 * find the first ‘k’ missing positive numbers in the array.
 *
 * Example 1:
 *
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 * Example 2:
 *
 * Input: [2, 3, 4], k=3
 * Output: [1, 5, 6]
 * Explanation: The smallest missing positive numbers are 1, 5 and 6.
 * Example 3:
 *
 * Input: [-2, -3, 4], k=2
 * Output: [1, 2]
 * Explanation: The smallest missing positive numbers are 1 and 2.
 */
public class FindFirstKMissingPositiveNumbers {
    public static void main(String[] args) {
        System.out.println("Result:"+ findMissingNumbers(new int[] {3, -1, 4, 5, 5}, 3));
        System.out.println("Result:"+ findMissingNumbers(new int[] {2, 3, 4}, 3));
        System.out.println("Result:"+ findMissingNumbers(new int[] {-2, -3, 4}, 2));
    }

    static List<Integer> findMissingNumbers(int[] nums, int k) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for (int j = 0; j < nums.length && missingNumbers.size() < k; j++) {
            if (nums[j] != j+1) {
                missingNumbers.add(j+1);
                extraNumbers.add(nums[j]);
            }
        }

        for (int j = 1; missingNumbers.size() < k; j++) {
            int candidateNumber = j + nums.length;
            if(!extraNumbers.contains(candidateNumber)) {
                missingNumbers.add(candidateNumber);
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
