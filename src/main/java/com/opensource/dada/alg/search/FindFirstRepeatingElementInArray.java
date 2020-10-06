package com.opensource.dada.alg.search;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given an array of integers, find the first repeating element in it.
 * We need to find the element that occurs more than once and whose index of first occurrence is smallest.
 * Examples:
 * <p>
 * Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
 * Output: 5 [5 is the first element that repeats]
 * <p>
 * Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
 * Output: 6 [6 is the first element that repeats]
 * <p>
 * Input:  arr[] = {3,2,1,2,2,3}
 * Output: 3 [3 is the first element that repeats]
 */
public class FindFirstRepeatingElementInArray {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        printFirstRepeating(arr);//5
        arr = new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10};
        printFirstRepeating(arr);//6
        arr = new int[]{3,2,1,2,2,3};
        printFirstRepeating(arr);//3

    }

    // This function prints the first repeating element in arr[]
    static void printFirstRepeating(int arr[]) {
        // Initialize index of first repeating element
        int min = -1;
        // Creates an empty hashset
        Set<Integer> set = new HashSet<>();
        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If element is already in hash set, update min
            if (set.contains(arr[i])) {
                min = i;
            } else {  // Else add element to hash set
                set.add(arr[i]);
            }
        }
        // Print the result
        if (min != -1)
            System.out.println("The first repeating element is " + arr[min]);
        else
            System.out.println("There are no repeating elements");
    }
}
