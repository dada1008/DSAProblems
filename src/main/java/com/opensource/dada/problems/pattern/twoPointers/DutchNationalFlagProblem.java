package com.opensource.dada.problems.pattern.twoPointers;

import java.util.Arrays;

/**
 * Problem:
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects,
 * hence, we can’t count 0s, 1s, and 2s to recreate the array.
 *
 * The flag of the Netherlands consists of three colors: red, white and blue;
 * and since our input array also consists of three different numbers
 * that is why it is called Dutch National Flag problem.
 *
 * Example 1:
 *
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 *
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        int[] input = {1, 0, 2, 1, 0};
        sort(input);
        System.out.println("Result:"+ Arrays.toString(input));
    }

    public static void test2() {
        int[] input = {2, 2, 0, 1, 2, 0};
        sort(input);
        System.out.println("Result:"+ Arrays.toString(input));
    }

    static void sort(int[] arr) {
        int start =0, mid=0, end = arr.length -1;
        while (mid <= end) {
            int leftNum = arr[mid];
            if (leftNum==2) {
                int temp = arr[end];
                arr[end]= arr[mid];
                arr[mid] = temp;
                end--;
            } else if(leftNum==1) {
                mid++;
            } else {
                int temp = arr[start];
                arr[start]= arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            }
        }
    }
}
