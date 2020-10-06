package com.opensource.dada.problems.pattern.subSets;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given a set with distinct elements, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 * Example 2:
 *
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println("result:"+findSubsets(new int[] {1,3 ,5}));
    }
    static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (Integer currentNumber: nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
