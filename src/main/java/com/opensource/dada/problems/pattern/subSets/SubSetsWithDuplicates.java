package com.opensource.dada.problems.pattern.subSets;

import java.util.*;

/**
 * Problem: https://www.geeksforgeeks.org/power-set/
 *
 * Given a set of numbers that might contain duplicates, find all of its distinct subsets.
 *
 * Example 1:
 *
 * Input: [1, 3, 3]
 * Output: [], [1], [3], [1,3], [3,3], [1,3,3]
 * Example 2:
 *
 * Input: [1, 5, 3, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 *
 */
public class SubSetsWithDuplicates {

    static void printPowerSet(Object[] set,
                              int set_size) {

        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
                (long) Math.pow(2, set_size);
        int counter, j;

        /*Run from counter 000..0 to
        111..1*/
        for (counter = 0; counter <
                pow_set_size; counter++) {
            for (j = 0; j < set_size; j++) {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if ((counter & (1 << j)) > 0)
                    System.out.print(set[j]);
            }

            System.out.println();
        }
    }

    // Driver program to test printPowerSet
    public static void main(String[] args) {
        Character[] set = {'1', '1', '3'};
        printPowerSet(set, 3);
        System.out.println("Recursive way:");
        findPowerSet(set);
    }

    //Recursive
    public static void findPowerSet(Object[] S)
    {
        Deque<Object> set = new ArrayDeque<>();
        findPowerSet(S, set, S.length);
    }
    // Function to generate power set of given set S
    public static void findPowerSet(Object[] S, Deque<Object> set, int n)
    {
        // if we have considered all elements
        if (n == 0) {
            System.out.println(set);
            return;
        }

        // consider nth element
        set.addLast(S[n - 1]);
        findPowerSet(S, set, n - 1);

        // or don't consider nth element
        set.removeLast();
        findPowerSet(S, set, n - 1);
    }

    static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex =0, endIndex = 0;
        for (int i=0; i<nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets
            // added in the previous step
            if (i>0 && nums[i]==nums[i-1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() -1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

}
