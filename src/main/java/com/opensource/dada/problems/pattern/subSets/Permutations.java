package com.opensource.dada.problems.pattern.subSets;

import java.util.*;

/**
 * Problem:
 * Given a set of distinct numbers, find all of its permutations.
 *
 * Permutation is defined as the re-arranging of the elements of the set.
 * For example, {1, 2, 3} has the following six permutations:
 *
 * {1, 2, 3}
 * {1, 3, 2}
 * {2, 1, 3}
 * {2, 3, 1}
 * {3, 1, 2}
 * {3, 2, 1}
 * If a set has ‘n’ distinct elements it will have n!n! permutations.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Permutations {
    public static void main(String[] args) {
        System.out.println("result:"+findPermutations(new int[] {1,3 ,5}));
        System.out.println("result:"+findPermutationsAlternate(new int[] {1,3 ,5}));
    }

    static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (Integer currentNumber: nums) {
            // we will take all existing permutations and insert the current number
            // in them to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutations = permutations.poll();
                // create a new permutation by adding the current number at every position.
                for (int j = 0; j <= oldPermutations.size(); j++) {
                    List<Integer> newPermutations = new ArrayList<>(oldPermutations);
                    newPermutations.add(j,currentNumber);
                    if (newPermutations.size()==nums.length) {
                        result.add(newPermutations);
                    } else {
                        permutations.add(newPermutations);
                    }
                }
            }
        }
        return result;
    }

    static List<List<Integer>> findPermutationsAlternate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutationHelper(0, nums, result);
        return result;
    }
    static void permutationHelper(int i, int[] nums, List<List<Integer>> result) {
        if (i==nums.length-1) {
            List<Integer> newPermutations = new ArrayList<>();
            for (int num: nums) {
                newPermutations.add(num);
            }
            result.add(newPermutations);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permutationHelper(i+1, nums, result);
                swap(nums, i, j);
            }
        }
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
