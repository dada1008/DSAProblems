package com.opensource.dada.problems.pattern.subSets;

import java.util.*;

/**
 * Problem: https://www.geeksforgeeks.org/find-distinct-subsets-given-set/
 *          https://leetcode.com/problems/subsets-ii/
 */
public class SubSetsWithOutDuplicates {

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1, 2, 2};

        printPowerSet(input, input.length);
        System.out.println("Recursive way:");
        findPowerSet(input);
    }

    static void printPowerSet(Object[] set,
                              int set_size) {

        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
                (long) Math.pow(2, set_size);
        int counter, j;
        Set<String> list = new HashSet<>();
        /*Run from counter 000..0 to
        111..1*/
        for (counter = 0; counter <
                pow_set_size; counter++) {
            String subset = "";
            for (j = 0; j < set_size; j++) {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if ((counter & (1 << j)) > 0) {
                    subset += (set[j] + "|");
                }
                if (!subset.isEmpty() && !list.contains(subset)) {
                    list.add(subset);
                }
            }

        }
        for (String subset: list) {
            String[] arr = subset.split("|");
            for (String str: arr) {
                System.out.print(str+" ");
            }
            System.out.println("");
        }
    }
    //Recursive
    public static void findPowerSet(Integer[] S) {
        // sort the set
        Arrays.sort(S);

        // create an empty list to store elements of a subset
        List<Integer> out = new ArrayList<>();
        findPowerSet(S, out, S.length - 1);
    }
    // Recursive function to print all distinct subsets of S
    // S	--> input set
    // out  --> list to store subset
    // i	--> index of next element in set S to be processed
    public static void findPowerSet(Integer[] S, List<Integer> out, int i)
    {
        // if all elements are processed, print the current subset
        if (i < 0) {
            System.out.println(out);
            return;
        }

        // include current element in the current subset and recur
        out.add(S[i]);
        findPowerSet(S, out, i - 1);

        // exclude current element in the current subset
        out.remove(out.size() - 1); // backtrack

        // remove adjacent duplicate elements
        while (i > 0 && S[i] == S[i - 1]) {
            i--;
        }

        // exclude current element in the current subset and recur
        findPowerSet(S, out, i - 1);
    }
}
